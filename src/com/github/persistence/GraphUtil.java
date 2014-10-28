package com.github.persistence;

import github.Collaborator;
import github.Item;

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
import org.neo4j.graphdb.schema.IndexDefinition;

import com.github.model.Follower;

public class GraphUtil {
	static GraphDatabaseService graphDb;
	static GraphDatabaseFactory factory;
	static UniqueFactory.UniqueNodeFactory result;
	static UniqueFactory.UniqueNodeFactory result1;
	static UniqueFactory.UniqueNodeFactory result2;
public static void startEngine() throws Exception
{
	
	factory=new GraphDatabaseFactory();
	graphDb = factory.newEmbeddedDatabase( "c:/shashank/dumps/github.db" );
	
	IndexDefinition indexDefinition,indexDefinition1;
	try ( Transaction tx = graphDb.beginTx() )
	{
		
		result = new UniqueFactory.UniqueNodeFactory( graphDb, "items" )
		
	    {
	        @Override
	        protected void initialize( Node created, Map<String, Object> properties )
	        {
	            created.addLabel( DynamicLabel.label( "Item" ) );
	            created.setProperty( "id", properties.get( "id" ) );
	        }
	    };
		
		result1 = new UniqueFactory.UniqueNodeFactory( graphDb, "collaborators" )
	    {
	        @Override
	        protected void initialize( Node created, Map<String, Object> properties )
	        {
	            created.addLabel( DynamicLabel.label( "Collaborator" ) );
	            created.setProperty( "id", properties.get( "id" ) );
	        }
	    };
	    result2 = new UniqueFactory.UniqueNodeFactory( graphDb, "followers" )
	    {
	        @Override
	        protected void initialize( Node created, Map<String, Object> properties )
	        {
	            created.addLabel( DynamicLabel.label( "Follower" ) );
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

public static Node addOrFindItemNode(Item item) throws Exception
{
	
	
	try ( Transaction tx = graphDb.beginTx() )
	{
		Node node = result.getOrCreate( "id", item.getId() );
	    
	    System.out.println( "Item created" );
	    tx.success();
	    return node;
	}
}
public static Node addOrFindCollaboratorNode(Collaborator collab) throws Exception
{
	String collabId=collab.getId().toString();
	
	
	try ( Transaction tx = graphDb.beginTx() )
	{
	   

	    // Create some users
	    
	    Node node = result1.getOrCreate( "id", collabId );
	       
	    
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
