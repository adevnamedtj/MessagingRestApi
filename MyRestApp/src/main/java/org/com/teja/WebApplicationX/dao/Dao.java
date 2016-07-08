package org.com.teja.WebApplicationX.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.com.teja.WebApplicationX.model.*;

public class Dao {
 
	private static Map<String, Profile> ProfileMap = new HashMap<>();
	private static Map<Integer, Message> MessageMap = new HashMap<>();
	private static List<Integer> deletedMessageList = new ArrayList<>();
	
	public static List<Integer> getDeletedMessageList() {
		return deletedMessageList;
	}
	public static Map<Integer, Message> getMessageMap() {
		return MessageMap;
	}
	public static Map<String, Profile> getProfileMap() {
		return ProfileMap;
	}
	
}
