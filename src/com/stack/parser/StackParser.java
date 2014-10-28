package com.stack.parser;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.neo4j.graphdb.Node;

import com.github.persistence.RelTypes;
import com.github.persistence.StackGraphUtil;
import com.stack.parser.comments.Comments;
import com.stack.parser.posts.Posts;
import com.stack.parser.postshistory.Posthistory;
import com.stack.parser.tags.Tags;
import com.stack.parser.users.Users;
import com.stack.parser.votes.Votes;

public class StackParser {

	public static void main(String[] args) throws Exception {
		
		// TODO Auto-generated method stub
		//parseComments();
		//parsePosts();
		StackGraphUtil.startEngine();
		//parseUsers();
		//parseComments();
		//parsePosts();
		
		//parseTags("C:/shashank/dumps/github_mining/stackoverflow/datascience/Tags.xml");
		//parseTags("C:/shashank/dumps/github_mining/stackoverflow/codereview.stackexchange.com/Tags.xml");
		//parseTags("C:/shashank/dumps/github_mining/stackoverflow/android.stackexchange.com/Tags.xml");
		parsePosts();
	}
	
	public static void parseComments() throws Exception
	{
		
		File file = new File("C:/shashank/dumps/github_mining/stackoverflow/datascience/Comments.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Comments.class);
		
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Comments comments = (Comments) jaxbUnmarshaller.unmarshal(file);
		//Row row=(Row)comments.getRow().get(0);

		
		for(Comments.Row row :comments.getRow() )
		{
	
		
			Node commentNode=StackGraphUtil.addOrFindCommentsNode(row);
			
			Users.Row user=new Users.Row();
			user.setAccountId(new Integer(row.getUserId()));
			
			Node userNode=StackGraphUtil.addOrFindUserNode(user);
			StackGraphUtil.addRelationship(userNode, commentNode, RelTypes.HAS);
			
		}	
		
		//System.out.println(row.getText());
	}

	
	public static void parsePosts() throws Exception
	{
		
		File file = new File("C:/shashank/dumps/github_mining/stackoverflow/datascience/Posts.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Posts.class);
 
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Posts posts = (Posts) jaxbUnmarshaller.unmarshal(file);
		
		for(Posts.Row row :posts.getRow() )
		{
	
		
			/*Node postNode=StackGraphUtil.addOrFindPostsNode(row);
			
			if(row.getParentId()!=row.getId() && row.getParentId()!=null)
			{
				Posts.Row postRow=new Posts.Row();
				postRow.setId(row.getParentId());
				
				System.out.println(row.getId()+" parent="+row.getParentId());
				Node parentNode=StackGraphUtil.addOrFindPostsNode(postRow);
				StackGraphUtil.addRelationship(parentNode, postNode, RelTypes.HASPARENT);
			}
			*/
			
		//	Users.Row user=new Users.Row();
			//user.setAccountId(new Integer(row.getOwnerUserId()));
			
			String text=row.getBody();
			
			PrintWriter out = new PrintWriter("C:/shashank/dumps/github_mining/stackoverflow/files/"+row.getOwnerUserId());

			out.println(text);
			out.flush();
			out.close();
			//Node userNode=StackGraphUtil.addOrFindUserNode(user);
			//StackGraphUtil.addRelationship(userNode, postNode, RelTypes.HAS);
			
		}	
		
		
	}
	
	public static void parsePostsHistory() throws Exception
	{
		
		File file = new File("C:/shashank/dumps/github_mining/stackoverflow/datascience/PostHistory.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Posthistory.class);
 
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Posthistory comments = (Posthistory) jaxbUnmarshaller.unmarshal(file);
		Posthistory.Row row=(Posthistory.Row)comments.getRow().get(0);
		
		System.out.println(row.getText());
	}
	
	public static void parseVotes() throws Exception
	{
		
		File file = new File("C:/shashank/dumps/github_mining/stackoverflow/datascience/Votes.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Votes.class);
 
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Votes comments = (Votes) jaxbUnmarshaller.unmarshal(file);
		Votes.Row row=(Votes.Row)comments.getRow().get(0);
		
		System.out.println(row.getValue());
	}
	
	public static void parseUsers() throws Exception
	{
		
		File file = new File("C:/shashank/dumps/github_mining/stackoverflow/datascience/Users.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
 
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Users users = (Users) jaxbUnmarshaller.unmarshal(file);
		
		for(Users.Row row :users.getRow() )
		{
	
		
			StackGraphUtil.addOrFindUserNode(row);
			
			
		}	
		
	}
	
	
	public static void parseTags(String filePath) throws Exception
	{
		
		File file = new File(filePath);
		JAXBContext jaxbContext = JAXBContext.newInstance(Tags.class);
 
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Tags tags = (Tags) jaxbUnmarshaller.unmarshal(file);
		
		for(Tags.Row row :tags.getRow() )
		{
	
		
			StackGraphUtil.addOrFindTagNode(row);
			
			
		}	
		
	}
	
	
	public static List<String> parseStackTags(String filePath) throws Exception
	{
		List list=new ArrayList();
		
		File file = new File(filePath);
		JAXBContext jaxbContext = JAXBContext.newInstance(Tags.class);
 
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Tags tags = (Tags) jaxbUnmarshaller.unmarshal(file);
		
		for(Tags.Row row :tags.getRow() )
		{
	
		
			//StackGraphUtil.addOrFindTagNode(row);
			list.add(row.getTagName());
			
			
		}	
		return list;
		
	}
	
}
