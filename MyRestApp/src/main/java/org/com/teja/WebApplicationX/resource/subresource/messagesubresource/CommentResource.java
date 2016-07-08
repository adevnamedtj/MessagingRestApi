package org.com.teja.WebApplicationX.resource.subresource.messagesubresource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.com.teja.WebApplicationX.exceptions.DataNotFoundException;
import org.com.teja.WebApplicationX.model.Comment;
import org.com.teja.WebApplicationX.services.CommentService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {
	private CommentService commentService = new CommentService();
	
	@GET
	public List<Comment> getComments(@PathParam("MessageId") Integer messageId){
		return commentService.getMessageComments(messageId);
	}
	
	@POST
	public Response addComment(@PathParam("MessageId") Integer messageId, Comment comment, @Context UriInfo uriInfo ) throws URISyntaxException{
		Comment commentTemp= commentService.addComment(messageId, comment);
		String IdString = commentTemp.getCommentid().toString();
		URI uri = uriInfo.getAbsolutePathBuilder().path(IdString).build();
		return Response.created(uri).entity(commentTemp).build();
		//return Response.created(new URI("/MyRestApp/webapi/messagesx/"+messageId+"/comments/"+commentTemp.getCommentid())).entity(commentTemp).build();		       
		
	}
	
	@PUT
	@Path("/{CommentId}")
	public Comment updateComment(@PathParam("MessageId") Integer messageId,
								 @PathParam("CommentId") Integer commentId,
								 Comment comment){
		return commentService.updateComment(messageId, comment);
		
	}
	
	@DELETE
	@Path("/{CommentId}")
	public Comment deleteComment(@PathParam("MessageId") Integer messageId,
								 @PathParam("CommentId") Integer commentId){
		return commentService.deleteComment(messageId, commentId);
		
	}
	
	@GET
	@Path("/{CommentId}")
	public Comment getACommentOfAMessage(@PathParam("MessageId") Integer messageId,
								 @PathParam("CommentId") Integer commentId){
		Comment commentTemp= commentService.getACommentOfMessage(messageId, commentId);
		if(commentTemp==null){
				throw new DataNotFoundException("Comment with ID "+commentId+" of Message "+messageId+" is not available");
			
		}
		return commentTemp;
		
	}
	
	

}
