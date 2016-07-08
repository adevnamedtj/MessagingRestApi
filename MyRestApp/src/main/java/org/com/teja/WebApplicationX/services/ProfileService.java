package org.com.teja.WebApplicationX.services;

import java.util.Map;

import org.com.teja.WebApplicationX.dao.Dao;
import org.com.teja.WebApplicationX.model.Profile;

public class ProfileService {
	private Map<String, Profile> profileservicemap = Dao.getProfileMap();
	
	public Map<String, Profile> setProfileService(){
		profileservicemap.put("teja",new Profile(1, "teja", "Teja", "Kalagara"));
		profileservicemap.put("ravi",new Profile(2,"ravi", "Ravi", "Kalagara"));
		return profileservicemap;
	}

	public Map<String, Profile> getProfiles() {
		// TODO Auto-generated method stub
		return profileservicemap;
	}

	public Profile getProfile(String profileUserId) {
		// TODO Auto-generated method stub
		if(profileUserId.isEmpty())
		return null;
		else
			return profileservicemap.get(profileUserId);
	}

	public Profile addProfile(Profile profile) {
		// TODO Auto-generated method stub
		profile.setProfileId(profileservicemap.size()+1);
		return 
		profileservicemap.put(profile.getProfileUserId(), profile);
	}

	public Profile updateProfile(Profile profile, String profileUserId) {
		// TODO Auto-generated method stub
		profile.setProfileUserId(profileUserId);
		
		return 
		profileservicemap.put(profileUserId, profile);
		
	}

	public Profile deleteProfile(String profileUserId) {
		
		return profileservicemap.remove(profileUserId);
	}
    
	
}
