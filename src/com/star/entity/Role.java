package com.star.entity;
 
public class Role {
 
	private String roleId;
	private String roleCode;
	private String roleName;
	private String supRoleId;
	private String createBy;
	private String createDate;
	private String updateBy;
	private String updateDate;
	private String isAdminRole;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getSupRoleId() {
		return supRoleId;
	}
	public void setSupRoleId(String supRoleId) {
		this.supRoleId = supRoleId;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getIsAdminRole() {
		return isAdminRole;
	}
	public void setIsAdminRole(String isAdminRole) {
		this.isAdminRole = isAdminRole;
	}
	
}