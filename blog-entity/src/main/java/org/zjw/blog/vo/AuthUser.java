package org.zjw.blog.vo;


import org.zjw.blog.entity.Blogger;
import org.zjw.blog.entity.Menu;
import org.zjw.blog.entity.Operation;
import org.zjw.blog.entity.Role;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AuthUser implements Serializable {

	private Integer id;

	private String username;

	private String password;


	private Role role;

	/**

	 * 当前登录的用户
	 */
	private Blogger blogger;
	/**
	 * 拥有的权限
	 */
	private List<Operation> operationList = new ArrayList<Operation>();
	/**
	 * 拥有的菜单
	 */
	private List<Menu> menuList = new ArrayList<Menu>();

	public List<Operation> getOperationList() {
		return operationList;
	}

	public void setOperationList(List<Operation> operationList) {
		this.operationList = operationList;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public Blogger getBlogger() {
		return blogger;
	}

	public void setBlogger(Blogger blogger) {
		this.blogger = blogger;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
