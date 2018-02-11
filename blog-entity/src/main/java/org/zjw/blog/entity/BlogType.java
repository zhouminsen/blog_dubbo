package org.zjw.blog.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author 周家伟
 * @date 2016-7-16
 */
public class BlogType implements Serializable {
	private Integer id;

	private String typeName;

	private Integer orderNo;

	private Date createDate;
	private String deleteFlag;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName == null ? null : typeName.trim();
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
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
		return "BlogType [id=" + id + ", typeName=" + typeName + ", orderNo="
				+ orderNo + ", getCreateDate()=" + getCreateDate()
				+ ", getDeleteFlag()=" + getDeleteFlag() + "]";
	}

}