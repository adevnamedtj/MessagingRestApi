package org.com.teja.WebApplicationX.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.com.teja.WebApplicationX.dao.Dao;
import org.com.teja.WebApplicationX.model.Message;

public class MessageServices {

	public static Map<Integer, Message> messageservieceMap = Dao.getMessageMap();
	public List<Integer> deleteList = Dao.getDeletedMessageList();
	
	
	public Map<Integer, Message> getAllMessages() {

		return messageservieceMap;

	}

	public List<Message> getMessagesFromYear(int Year) {
		List<Message> messagesbyYear = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		for (Message message : messageservieceMap.values()) {
			calendar.setTime(message.getCreateDate());
			if (calendar.get(Calendar.YEAR) == Year) {
				messagesbyYear.add(message);

			}
		}
		return messagesbyYear;
	}

	public List<Message> getMessagesbyPagination(int start, int size) {
		ArrayList<Message> messagesbyPaginationlist = new ArrayList<Message>(messageservieceMap.values());
//		if (messagesbyPaginationlist.size() == 0 && start + size > messagesbyPaginationlist.size())
//			return null;
//		else
			return messagesbyPaginationlist.subList(start, start+size);

	}

	public Message getMessage(Integer id) {
		return messageservieceMap.get(id);

	}

	

	public Message addMessage(Message message) {
		if (deleteList.isEmpty())
			message.setId(messageservieceMap.size() + 1);
		else {
			message.setId(deleteList.get(0));
			deleteList.remove(0);
		}
		message.setCreateDate();
		// message.setAuthor("Unknown");
		// message.setCreateDate(new Date());
		messageservieceMap.put(message.getId(), message);
		return message;

	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0)
			return null;
		else {
			messageservieceMap.put(message.getId(), message);
			return message;
		}

	}

	public Message deleteMessage(Integer Id) {
		messageservieceMap.remove(Id);
		deleteList.add(Id);
		System.out.println(deleteList);
		return new Message();
	}

	public void getservices() {
		// deleteList.add(0);
		messageservieceMap.put(1, new Message(1, "hi there, how are you?", "Teja"));
		messageservieceMap.put(2, new Message(2, "I am Fine, How about you?", "Ravi"));
		messageservieceMap.put(3, new Message(3, "I am Great, Lets Starts ", "Teja"));
		messageservieceMap.put(4, new Message(4, "Hi, the eagle was", "Sam"));
		messageservieceMap.put(5, new Message(5, "whats happening!", "Ravi"));
		messageservieceMap.put(6, new Message(6, "ITs OK, we will take care.....!", "Chandhu"));

	}

	
	
}
