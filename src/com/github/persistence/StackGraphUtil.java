package com.github.persistence;

import java.util.ArrayList;
import java.util.Map;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.index.UniqueFactory;

import com.github.model.Follower;
import com.stack.parser.comments.Comments;
import com.stack.parser.posts.Posts;
import com.stack.parser.tags.Tags;
import com.stack.parser.users.Users;

public class StackGraphUtil {
	static GraphDatabaseService graphDb;
	static GraphDatabaseFactory factory;
	static UniqueFactory.UniqueNodeFactory result;
	static UniqueFactory.UniqueNodeFactory result1;
	static UniqueFactory.UniqueNodeFactory result2,result3;
public static void startEngine() throws Exception
{
	
	factory=new GraphDatabaseFactory();
	graphDb = factory.newEmbeddedDatabase( "c:/shashank/dumps/github_mining/stack.db" );
	
	
	try ( Transaction tx = graphDb.beginTx() )
	{
		
		result = new UniqueFactory.UniqueNodeFactory( graphDb, "users" )
		
	    {
	        @Override
	        protected void initialize( Node created, Map<String, Object> properties )
	        {
	            created.addLabel( DynamicLabel.label( "User" ) );
	            created.setProperty( "id", properties.get( "id" ) );
	        }
	    };
		
		result1 = new UniqueFactory.UniqueNodeFactory( graphDb, "comments" )
	    {
	        @Override
	        protected void initialize( Node created, Map<String, Object> properties )
	        {
	            created.addLabel( DynamicLabel.label( "Comment" ) );
	            created.setProperty( "id", properties.get( "id" ) );
	        }
	    };
	    result2= new UniqueFactory.UniqueNodeFactory( graphDb, "posts" )
	    {
	        @Override
	        protected void initialize( Node created, Map<String, Object> properties )
	        {
	            created.addLabel( DynamicLabel.label( "Post" ) );
	            created.setProperty( "id", properties.get( "id" ) );
	        }
	    };
	    result3= new UniqueFactory.UniqueNodeFactory( graphDb, "tags" )
	    {
	        @Override
	        protected void initialize( Node created, Map<String, Object> properties )
	        {
	            created.addLabel( DynamicLabel.label( "Tag" ) );
	            created.setProperty( "id", properties.get( "id" ) );
	        }
	    };
		
		
	/*    Schema schema = graphDb.schema();
	    
	    indexDefinition = schema.indexFor( DynamicLabel.label( "Item" ) )
	            .on( "item" )
	            .create();
	    
	    indexDefinition1= schema.indexFor( DynamicLabel.label( "Collaborator" ) )
	            .on( "collaborator" )
	            .create();*/
	    
	    tx.success();
	}
	
	
	registerShutdownHook( graphDb );
	
}

private static void registerShutdownHook( final GraphDatabaseService graphDb )
{
    // Registers a shutdown hook for the Neo4j instance so that it
    // shuts down nicely when the VM exits (even if you "Ctrl-C" the
    // running application).
    Runtime.getRuntime().addShutdownHook( new Thread()
    {
        @Override
        public void run()
        {
            graphDb.shutdown();
        }
    } );
}

public static Node addOrFindUserNode(Users.Row user) throws Exception
{
	
	
	try ( Transaction tx = graphDb.beginTx() )
	{
		Node node = result.getOrCreate( "id", user.getAccountId() );
	    
	    System.out.println( "User created" );
	    tx.success();
	    return node;
	}
}


public static Node addOrFindTagNode(Tags.Row tag) throws Exception
{
	
	
	try ( Transaction tx = graphDb.beginTx() )
	{
		Node node = result3.getOrCreate( "id",tag.getTagName());
	    
	    System.out.println( "Tag created" );
	    tx.success();
	    return node;
	}
}

public static Node addOrFindCommentsNode(Comments.Row comment) throws Exception
{
	
	
	
	try ( Transaction tx = graphDb.beginTx() )
	{
	   

	    // Create some users
	    
	    Node node = result1.getOrCreate( "id", comment.getId() );
	       
	    
	    System.out.println( "Collab created" );
	    tx.success();
	    return node;
	}
}


public static Node addOrFindPostsNode(Posts.Row post) throws Exception
{
	
	
	
	try ( Transaction tx = graphDb.beginTx() )
	{
	   

	    // Create some users
	    
	    Node node = result2.getOrCreate( "id", post.getId());
	       
	    
	    System.out.println( "Collab created" );
	    tx.success();
	    return node;
	}
}
public static Node addOrFindFollowerNode(Follower follower) throws Exception
{
	String followerId=follower.getId().toString();
	
	
	try ( Transaction tx = graphDb.beginTx() )
	{
	   

	    // Create some users
	    
	    Node node = result2.getOrCreate( "id", followerId );
	       
	    
	    System.out.println( "Follower created" );
	    tx.success();
	    return node;
	}
}

public static void addRelationship(Node node1,Node node2,RelationshipType type) throws Exception
{
	try ( Transaction tx = graphDb.beginTx() )
	{
		
	    node1.createRelationshipTo(node2,type);

	    // Create some users
	    
	       
	    
	    System.out.println( "relationship created" );
	    tx.success();
	}
}

public static Node findItemNodeByID(String itemId) throws Exception
{
	Label label = DynamicLabel.label( "Item" );
	
	try ( Transaction tx = graphDb.beginTx() )
	{
	    try ( ResourceIterator<Node> users =
	            graphDb.findNodesByLabelAndProperty( label, "item", itemId ).iterator() )
	    {
	        ArrayList<Node> userNodes = new ArrayList<>();
	        while ( users.hasNext() )
	        {
	            userNodes.add( users.next() );
	        }

	        return userNodes.get(0);
	    }
	}
}

public static Node findCollabNodeByID(String collabID) throws Exception
{
	Label label = DynamicLabel.label( "Collaborator" );
	
	try ( Transaction tx = graphDb.beginTx() )
	{
	    try ( ResourceIterator<Node> users =
	            graphDb.findNodesByLabelAndProperty( label, "collaborator", collabID ).iterator() )
	    {
	        ArrayList<Node> collabNodes = new ArrayList<>();
	        while ( users.hasNext() )
	        {
	        	collabNodes.add( users.next() );
	        }

	        return collabNodes.get(0);
	    }
	}
}
}
