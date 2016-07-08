package org.com.teja.WebApplicationX.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {
	
	private Integer id;
	private String messagedata;
	private String author;
	private Date createDate;
	private Map<Integer, Comment> CommentsMap = new HashMap<>();
	private List<Integer> commentDeleteList = new ArrayList<>();
	
	public Message()
	{
		
	}
	
	public Map<Integer , Comment> commentGenerator(Integer messageid, String message, String author){

		Map<Integer, Comment> CommentsMapTemp = new HashMap<>();
		for(int i=1; i<=8; i++){
			Comment comment = new Comment(i,"Comment "+i+" M "+messageid,author);
			CommentsMapTemp.put(comment.getCommentid(),comment);
		}
		return CommentsMapTemp;
		
		
		
	}
	
	public Message( Integer id, String message, String author){
		this.id=id;
		this.messagedata=message;
		this.author=author;
		this.createDate= new Date();
		this.CommentsMap = commentGenerator(id,message,author);
	}
	
	public String getMessage(String Data) {
		return Data;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMessage() {
		return messagedata;
	}
	public void setMessage(String message) {
		this.messagedata = message;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public void setCreateDate() {
		this.createDate = new Date();
	}
	@XmlTransient
	public Map<Integer, Comment> getCommentsMap() {
		return CommentsMap;
	}
	public void setCommentsMap(Map<Integer, Comment> commentsMap) {
		CommentsMap = commentsMap;
	}
	@XmlTransient
	public List<Integer> getCommentDeleteList() {
		return commentDeleteList;
	}
	public void setCommentDeleteList(List<Integer> commentDeleteList) {
		this.commentDeleteList = commentDeleteList;
	}

}
