package com.edc.entity;
import java.sql.Timestamp;
public class Blog {

	private int id;
	private String title;
	private Timestamp createTime;
	private String introduction;
	private String content;
	private String lable;
	private String uId;
	private String uName;
	private String uAvator;
	private String uAddress;
	public Blog() {
		super();
	}
	public Blog(int id, String title, Timestamp createTime, String introduction, String content, String lable,
			String uId, String uName, String uAvator, String uAddress) {
		super();
		this.id = id;
		this.title = title;
		this.createTime = createTime;
		this.introduction = introduction;
		this.content = content;
		this.lable = lable;
		this.uId = uId;
		this.uName = uName;
		this.uAvator = uAvator;
		this.uAddress = uAddress;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLable() {
		return lable;
	}
	public void setLable(String lable) {
		this.lable = lable;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuAvator() {
		return uAvator;
	}
	public void setuAvator(String uAvator) {
		this.uAvator = uAvator;
	}
	public String getuAddress() {
		return uAddress;
	}
	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}
	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", createTime=" + createTime + ", introduction=" + introduction
				+ ", content=" + content + ", lable=" + lable + ", uId=" + uId + ", uName=" + uName + ", uAvator="
				+ uAvator + ", uAddress=" + uAddress + "]";
	}

	



	
	
}
