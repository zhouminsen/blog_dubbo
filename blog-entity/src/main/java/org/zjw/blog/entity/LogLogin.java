package org.zjw.blog.entity;


import java.io.Serializable;
import java.util.Date;

public class LogLogin implements Serializable {

    private static final long serialVersionUID = 8121983725196276787L;
    private Integer id;

    private String username;

    private String password;

    private Integer status;

    private Integer type;

    private String description;

    private String ipAddress;

    private Date createDate;
    private String deleteFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
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
		return "LogLogin [id=" + id + ", username=" + username + ", password="
				+ password + ", status=" + status + ", type=" + type
				+ ", description=" + description + ", ipAddress=" + ipAddress
				+ ", getCreateDate()=" + getCreateDate() + ", getDeleteFlag()="
				+ getDeleteFlag() + "]";
	}
    
}