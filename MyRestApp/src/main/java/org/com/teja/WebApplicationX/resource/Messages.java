package org.com.teja.WebApplicationX.resource;

import java.net.URI;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.com.teja.WebApplicationX.exceptions.DataNotFoundException;
import org.com.teja.WebApplicationX.model.Message;
import org.com.teja.WebApplicationX.resource.subresource.messagesubresource.CommentResource;
import org.com.teja.WebApplicationX.services.MessageServices;

@Path("/messagesx")
public class Messages {
	private MessageServices messageservices = new MessageServices();
	
	//......................................................................................
	@GET
	@Path("/set")
	@Produces(MediaType.APPLICATION_JSON)
	public String getMessages()
	{
     messageservices.getservices();
		return "Done!";
	}
	

	//......................................................................................
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessagesFromResource(@QueryParam("year") int Year,
			                                         @QueryParam("start") int start,
			                                         @QueryParam("size") int size)
	{
		    if(Year >0)
			return new ArrayList<Message>(messageservices.getMessagesFromYear(Year));
			
			//if(start>=0 && size>=0)
			//return messageservices.getMessagesbyPagination(start, size);
			
		    else
		    return new ArrayList<Message>(messageservices.getAllMessages().values());
		
	}
	//......................................................................................
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{MessageId}")
	public Message getMessage(@PathParam("MessageId") Integer MessageId){
	Message messageTemp= messageservices.getMessage(MessageId);	
	if(messageTemp == null){
		throw new DataNotFoundException("Message with ID "+MessageId+" is not available");
	}
	return messageTemp;
	}
	//......................................................................................
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{MessageId}")
	public Message deleteMessage(@PathParam("MessageId") Integer MessageId){
	return messageservices.deleteMessage(MessageId)	;
	}
	
	//......................................................................................
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage( Message message, @Context UriInfo uriInfo){
	
		Message TempObject= messageservices.addMessage(message);
		String IdString = TempObject.getId().toString();
		URI uri = uriInfo.getAbsolutePathBuilder().path(IdString).build();
		return Response.created(uri).entity(TempObject).build();
	}
	
	//......................................................................................
	@PUT
	@Path("/{MessageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("MessageId") Integer Id, Message message){
		message.setId(Id);
		return messageservices.updateMessage(message);
	}
	
	//..........................................
	
	@Path("/{MessageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
}
