package org.zjw.blog.controller.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.BeanUtils;
import org.zjw.blog.entity.Blogger;
import org.zjw.blog.entity.Menu;
import org.zjw.blog.entity.Operation;
import org.zjw.blog.entity.Role;
import org.zjw.blog.service.BloggerService;
import org.zjw.blog.service.MenuService;
import org.zjw.blog.service.OperationService;
import org.zjw.blog.service.RoleService;
import org.zjw.blog.vo.AuthUser;

import javax.annotation.Resource;
import java.util.*;

/**
 * 
 * @author 周家伟
 * @date 2016-7-16
 */
public class CustomRealm extends AuthorizingRealm {

	@Resource
	private BloggerService bloggerService;
	
	@Resource
	private RoleService roleService;
	
	@Resource
	private MenuService menuService;
	
	@Resource
	private OperationService operationService;
	

	@Override
	public void setName(String name) {
		super.setName("customRealm");
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// 获得当前登录成功的用户该用户存在shiro中
		AuthUser authUser = (AuthUser) principals.getPrimaryPrincipal();
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("userId", authUser.getBlogger().getId());
		// 获得当前用户的角色,拿到所用的菜单和权限的ids
		List<Role> roleList = roleService.getByUserId(queryMap);
		String[] menuIds = roleList.get(0).getMenuIds().split(",");
		String[] operationIds = roleList.get(0).getOperationIds().split(",");
		Set<String> permissionList = new HashSet<String>();
		for (int i = 0; i < menuIds.length; i++) {
			//添加菜单
			Menu menu=menuService.getById(Integer.parseInt(menuIds[i]));
			authUser.getMenuList().add(menu);
		}
		for (String id : operationIds) {
			//添加权限和权限名
			Operation operation=operationService.getById(Integer.parseInt(id));
			authUser.getOperationList().add(operation);
			//拼接权限字符串 (链接管理:删除)
			String perminssion=operation.getMenuName()+":"+operation.getOperationName();
			permissionList.add(perminssion);
			System.out.println(perminssion);
		}
		//将权限设置到session中
		SecurityUtils.getSubject().getSession().setAttribute("permissionList",permissionList);
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setStringPermissions(permissionList);
		return authorizationInfo;
	}
	
	/**
	 * 此方法验证失败后or抛出异常都会跳转到配置文件中loginUrl中
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		System.out.println("我来到身份证明这里了");
//		UsernamePasswordToken token2 = (UsernamePasswordToken) token;
		String username = (String) token.getPrincipal();
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("username", username);
		List<Blogger> bloggerList = bloggerService.selectByCondition(queryMap);
		if (bloggerList.isEmpty()) {
			throw new UnknownAccountException("没有此账号");
		}
		String password = new String((char[]) token.getCredentials());
		password = new Md5Hash(password,username).toString();
		if (!bloggerList.get(0).getPassword().equals(password)) {
			throw new IncorrectCredentialsException("密码错误");
		}
		AuthUser authUser = new AuthUser();
		authUser.setBlogger(bloggerList.get(0));
		BeanUtils.copyProperties(bloggerList.get(0), authUser);
		queryMap.put("userId", authUser.getId());
		List<Role> roleList = roleService.getByUserId(queryMap);
		authUser.setRole(roleList.get(0));
		//账号密码没有错误,将当前用户设置到session中
		SecurityUtils.getSubject().getSession().setAttribute("currentUser", authUser);
		//cachedSession.setAttribute(ServletAPI.getRequest(), ServletAPI.getResponse(), "currentUser", authUser);
		AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
						authUser, 
						bloggerList.get(0).getPassword(),//对比查询到密码, 对输入的密码进行加盐md5加密 
						ByteSource.Util.bytes(bloggerList.get(0).getUsername()), 
						this.getName());
		return authenticationInfo;
	}

	@Override
	protected void assertCredentialsMatch(AuthenticationToken authcToken,
			AuthenticationInfo info) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		System.out.println("你到底过来没有啊");
	    // 若单点登录，则使用单点登录授权方法。  
		super.assertCredentialsMatch(token, info);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
