package com.github.persistence;

import github.Collaborator;
import github.Item;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.ws.rs.core.MediaType;

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
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class GraphRestUtil {
	
	static String SERVER_ROOT_URI="http://gitty.sb02.stations.graphenedb.com:24789/db/data/";
	static String username="gitty";
	static String password="AOFHqZnrbixIIGsxwn9A";
	static GraphDatabaseService graphDb;
	static GraphDatabaseFactory factory;
	static UniqueFactory.UniqueNodeFactory result;
	static UniqueFactory.UniqueNodeFactory result1;
	static UniqueFactory.UniqueNodeFactory result2;
public static void startEngine() throws Exception
{
	
	
	final String nodeEntryPointUri = SERVER_ROOT_URI + "index/node/people?uniqueness=get_or_create";
	// http://localhost:7474/db/data/node

	WebResource resource = Client.create()
	        .resource( nodeEntryPointUri );
	// POST {} to the node entry point URI
	resource.addFilter(new HTTPBasicAuthFilter(username, password));
	ClientResponse response = resource.accept( "application/json" )
	        .type( "application/json" )
	        .entity( "{\"key\" : \"name\",\"value\" : \"Tobias\"}" )
	        .post( ClientResponse.class );
	

	final URI location = response.getLocation();
	System.out.println(response.getClientResponseStatus());
	//System.out.println( String.format(
	  //      "POST to [%s], status code [%d], location header [%s]",
	    //    nodeEntryPointUri, response.getStatus(), location.toString() ) );
	response.close();

	
	
	
	
	
}


public static URI addRelationship( URI startNode, URI endNode,
        String relationshipType, String jsonAttributes,String id )
        throws URISyntaxException
{
    //URI fromUri = new URI( startNode.toString() + "/relationships" );
    final String nodeEntryPointUri = SERVER_ROOT_URI +  "index/relationship/rels?uniqueness=get_or_create";
  //  System.out.println("relation url="+fromUri.toString());
    String relationshipJson = generateJsonRelationship( startNode,endNode,
            relationshipType,id,null );
    System.out.println(relationshipJson);
    WebResource resource = Client.create()
            .resource( nodeEntryPointUri );
    resource.addFilter(new HTTPBasicAuthFilter(username, password));
    // POST JSON to the relationships URI
    ClientResponse response = resource.accept( MediaType.APPLICATION_JSON )
            .type( MediaType.APPLICATION_JSON )
            .entity( relationshipJson )
            .post( ClientResponse.class );

    final URI location = response.getLocation();
    
    System.out.println("relationship response="+response.getStatus());
    /*System.out.println( String.format(
            "POST to [%s], status code [%d], location header [%s]",
            nodeEntryPointUri, response.getStatus(), location.toString() ) );*/

    response.close();
    return location;
}


private static String generateJsonRelationship( URI startNode,URI endNode,
        String relationshipType ,String id,String[] jsonAttributes)
{
    StringBuilder sb = new StringBuilder();
    
    sb.append( "{ \"key\" : \"id" );
    
    sb.append( "\", " );

    
    sb.append( "\"value\" : \"" );
    sb.append( id );
    sb.append( "\", " );
    
    sb.append( " \"start\" : \"" );
    sb.append( startNode.toString() );
    sb.append( "\", " );

    
    sb.append( " \"end\" : \"" );
    sb.append( endNode.toString() );
    sb.append( "\", " );

    sb.append( "\"type\" : \"" );
    sb.append( relationshipType );
    sb.append( "\"" );
  /*  if ( jsonAttributes == null || jsonAttributes.length < 1 )
    {
        sb.append( "\"" );
    }
    else
    {
        sb.append( "\", \"data\" : " );
        for ( int i = 0; i < jsonAttributes.length; i++ )
        {
            sb.append( jsonAttributes[i] );
            if ( i < jsonAttributes.length - 1 )
            { // Miss off the final comma
                sb.append( ", " );
            }
        }
    }*/

    sb.append( " }" );
    return sb.toString();
}
public static void main(String[] args) throws Exception
{
	startEngine();
}


public static URI addOrFindItemNode(Item item) throws Exception
{
	
	
	final String nodeEntryPointUri = SERVER_ROOT_URI + "index/node/item?uniqueness=get_or_create";
	// http://localhost:7474/db/data/node
	String test=generateJsonNodeForItem(item);
	System.out.println(test);
	WebResource resource = Client.create()
	        .resource( nodeEntryPointUri );
	// POST {} to the node entry point URI
	resource.addFilter(new HTTPBasicAuthFilter(username, password));
	ClientResponse response = resource.accept( "application/json" )
	        .type( "application/json" )
	        .entity( generateJsonNodeForItem(item) )
	        .post( ClientResponse.class );
	

	final URI location = response.getLocation();
	System.out.println(response.getClientResponseStatus());
	//System.out.println( String.format(
	  //      "POST to [%s], status code [%d], location header [%s]",
	    //    nodeEntryPointUri, response.getStatus(), location.toString() ) );
	response.close();


return location;	
	
}

public static URI addItemProperties(Item item,String url) throws Exception
{
	
	
	
	// http://localhost:7474/db/data/node
	String test=generateJsonNodeForItem(item);
	System.out.println(test);
	WebResource resource = Client.create()
	        .resource( url );
	// POST {} to the node entry point URI
	resource.addFilter(new HTTPBasicAuthFilter(username, password));
	ClientResponse response = resource.accept( "application/json" )
	        .type( "application/json" )
	        .entity( generateJsonNodeForItem(item) )
	        .put( ClientResponse.class );
	

	final URI location = response.getLocation();
	System.out.println(response.getClientResponseStatus());
	//System.out.println( String.format(
	  //      "POST to [%s], status code [%d], location header [%s]",
	    //    nodeEntryPointUri, response.getStatus(), location.toString() ) );
	response.close();


return location;	
	
}


private static String generateJsonNodeForItem( Item item)
{
    StringBuilder sb = new StringBuilder();
    
    

    
sb.append( "{ \"key\" : \"id" );
    
    sb.append( "\", " );

    
    sb.append( "\"value\" : \"" );
    sb.append( item.getId() );
    sb.append( "\", " );
    
    sb.append( "\"name\" : \"" );
    sb.append( item.getName() );
    sb.append( "\", " );
    
    sb.append( "\"fullName\" : \"" );
    sb.append( item.getFullName() );
    sb.append( "\", " );
   
    
    sb.append( "\"size\" : \"" );
    sb.append( item.getSize() );
    sb.append( "\", " );
    
    sb.append( "\"archiveURL\" : \"" );
    sb.append( item.getArchive_url());
    sb.append( "\", " );
    
    sb.append( "\"assigneesURL\" : \"" );
    sb.append( item.getAssignees_url() );
    sb.append( "\", " );
    
    sb.append( "\"description\" : \"" );
    sb.append( item.getDescription() );
    sb.append( "\", " );
    
    sb.append( "\"contentsURL\" : \"" );
    sb.append( item.getContents_url() );
    sb.append( "\", " );
    
    sb.append( "\"commentsURL\" : \"" );
    sb.append( item.getComments_url() );
    sb.append( "\", " );
    
    sb.append( "\"createdAt\" : \"" );
    sb.append( item.getCreated_at());
    sb.append( "\", " );
    
    sb.append( "\"language\" : \"" );
    sb.append( item.getLanguage());
    sb.append( "\" " );
    
    sb.append( " }" );
    
  
  /*  if ( jsonAttributes == null || jsonAttributes.length < 1 )
    {
        sb.append( "\"" );
    }
    else
    {
        sb.append( "\", \"data\" : " );
        for ( int i = 0; i < jsonAttributes.length; i++ )
        {
            sb.append( jsonAttributes[i] );
            if ( i < jsonAttributes.length - 1 )
            { // Miss off the final comma
                sb.append( ", " );
            }
        }
    }*/

    
    return sb.toString();
}


private static String generateJsonNodeForCollaborator( Collaborator collab)
{
    StringBuilder sb = new StringBuilder();
    
    

    
sb.append( "{ \"key\" : \"id" );
    
    sb.append( "\", " );

    
    sb.append( "\"value\" : \"" );
    sb.append( collab.getId() );
    sb.append( "\", " );
    
    sb.append( "\"login\" : \"" );
    sb.append( collab.getLogin());
    sb.append( "\", " );
    
    sb.append( "\"type\" : \"" );
    sb.append( collab.getType() );
    sb.append( "\", " );
   
    
    sb.append( "\"url\" : \"" );
    sb.append( collab.getUrl());
    sb.append( "\" " );
    
   
    
    sb.append( " }" );
    
  
  /*  if ( jsonAttributes == null || jsonAttributes.length < 1 )
    {
        sb.append( "\"" );
    }
    else
    {
        sb.append( "\", \"data\" : " );
        for ( int i = 0; i < jsonAttributes.length; i++ )
        {
            sb.append( jsonAttributes[i] );
            if ( i < jsonAttributes.length - 1 )
            { // Miss off the final comma
                sb.append( ", " );
            }
        }
    }*/

    
    return sb.toString();
}


public static URI addOrFindCollaboratorNode(Collaborator collab) throws Exception
{
	
	
	
	final String nodeEntryPointUri = SERVER_ROOT_URI + "index/node/collaborator?uniqueness=get_or_create";
	// http://localhost:7474/db/data/node

	WebResource resource = Client.create()
	        .resource( nodeEntryPointUri );
	// POST {} to the node entry point URI
	resource.addFilter(new HTTPBasicAuthFilter(username, password));
	
	String test=generateJsonNodeForCollaborator(collab);
	System.out.println(test);
	ClientResponse response = resource.accept( "application/json" )
	        .type( "application/json" )
	        .entity( generateJsonNodeForCollaborator(collab) )
	        .post( ClientResponse.class );
	

	final URI location = response.getLocation();
	System.out.println(response.getClientResponseStatus());
	//System.out.println( String.format(
	  //      "POST to [%s], status code [%d], location header [%s]",
	    //    nodeEntryPointUri, response.getStatus(), location.toString() ) );
	response.close();


return location;	
}
public static URI addOrFindFollowerNode(Follower follower) throws Exception
{
	String followerId=follower.getId().toString();
	
	
	final String nodeEntryPointUri = SERVER_ROOT_URI + "index/node/follower?uniqueness=get_or_create";
	// http://localhost:7474/db/data/node

	WebResource resource = Client.create()
	        .resource( nodeEntryPointUri );
	// POST {} to the node entry point URI
	resource.addFilter(new HTTPBasicAuthFilter(username, password));
	ClientResponse response = resource.accept( "application/json" )
	        .type( "application/json" )
	        .entity( "{\"key\" : \"id\",\"value\" : \""+followerId+"\"}" )
	        .post( ClientResponse.class );
	

	final URI location = response.getLocation();
	System.out.println(response.getClientResponseStatus());
	//System.out.println( String.format(
	  //      "POST to [%s], status code [%d], location header [%s]",
	    //    nodeEntryPointUri, response.getStatus(), location.toString() ) );
	response.close();


return location;	
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
