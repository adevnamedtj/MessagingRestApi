package org.com.teja.WebApplicationX.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.com.teja.WebApplicationX.model.Profile;
import org.com.teja.WebApplicationX.services.ProfileService;

@Path("/profiles")
public class ProfileResource {

	private ProfileService profileservice = new  ProfileService();
	

	//......................................................................................
		@GET
		@Path("/set")
		@Produces(MediaType.APPLICATION_JSON)
		public List<Profile> getProfiles()
		{
	     return new ArrayList<Profile>(profileservice.setProfileService().values());
			//return "What the Fuck !";
		}
		//......................................................................................
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List< Profile> getAllProfilesFromResource()
		{
			return new ArrayList<Profile>(profileservice.getProfiles().values());
		}
		//......................................................................................
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/{ProfileUserId}")
		public Profile getProfile(@PathParam("ProfileUserId") String ProfileUserId){
		return profileservice.getProfile(ProfileUserId);		
		}
	
		
		//......................................................................................
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Profile addProfile( Profile Profile){
			return profileservice.addProfile(Profile);
		}
		
		//......................................................................................
		@PUT
		@Path("/{ProfileUserId}")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Profile updateProfile(@PathParam("ProfileUserId") String profileUserId, Profile Profile){
			
			return profileservice.updateProfile(Profile, profileUserId);
			
			
		}
		//......................................................................................
		@DELETE
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/{ProfileUserId}")
		public Profile deleteProfile(@PathParam("ProfileUserId") String profileUserId){
		return profileservice.deleteProfile(profileUserId)	;
		}
}
