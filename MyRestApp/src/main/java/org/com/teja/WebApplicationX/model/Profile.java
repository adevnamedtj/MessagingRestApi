package org.com.teja.WebApplicationX.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Profile {
	private Integer profileId;
	private  String profileUserId;
	private  String profileUserFname;
	private  String profileUserLname;
	private Date Dob;
	
	public Profile(){
		
	}
	public Profile(	 
	  Integer profileIdx
	,  String profileUserIdx
	,  String profileUserFnamex
	,  String profileUserLnamex
	, Date Dobx ){
		this.profileId=profileIdx;
		this.profileUserId=profileUserIdx;
		this.profileUserFname=profileUserFnamex;
		this.profileUserLname=profileUserLnamex;
		this.Dob=Dobx;
		
	}
	public Profile(	 
			  Integer profileIdx
			,  String profileUserIdx
			,  String profileUserFnamex
			,  String profileUserLnamex
			){
				this.profileId=profileIdx;
				this.profileUserId=profileUserIdx;
				this.profileUserFname=profileUserFnamex;
				this.profileUserLname=profileUserLnamex;
				this.Dob=new Date();
				
			}
	public Integer getProfileId() {
		return profileId;
	}
	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}
	public String getProfileUserId() {
		return profileUserId;
	}
	public void setProfileUserId(String profileUserId) {
		this.profileUserId = profileUserId;
	}
	public String getProfileUserFname() {
		return profileUserFname;
	}
	public void setProfileUserFname(String profileUserFname) {
		this.profileUserFname = profileUserFname;
	}
	public String getProfileUserLname() {
		return profileUserLname;
	}
	public void setProfileUserLname(String profileUserLname) {
		this.profileUserLname = profileUserLname;
	}
	public Date getDob() {
		return Dob;
	}
	public void setDob(Date dob) {
		Dob = dob;
	}
	
	

}
