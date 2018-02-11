package org.zjw.blog.entity;

import java.io.Serializable;

public class Role implements Serializable {
    private Integer roleId;

    private String roleName;

    private String menuIds;

    private String operationIds;

    private String description;

    private String createDate;
    private String deleteFlag;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(String menuIds) {
        this.menuIds = menuIds == null ? null : menuIds.trim();
    }

    public String getOperationIds() {
        return operationIds;
    }

    public void setOperationIds(String operationIds) {
        this.operationIds = operationIds == null ? null : operationIds.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName
				+ ", menuIds=" + menuIds + ", operationIds=" + operationIds
				+ ", description=" + description + ", getCreateDate()="
				+ getCreateDate() + ", getDeleteFlag()=" + getDeleteFlag()
				+ "]";
	}
    

}