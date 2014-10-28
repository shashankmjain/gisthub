package github;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;

import com.github.model.Follower;
import com.github.model.GistsURL;
import com.github.model.IssueEvent;
import com.github.model.StarredURL;
import com.github.model.Subscription;
import com.github.persistence.GraphRestUtil;
import com.github.persistence.GraphUtil;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class SampleGitHub {
	static String proxy="proxy.blr.sap.corp";
	public static void main(String[] args) throws Exception {
		
		/*System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
		System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
		System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire", "debug");
		System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient", "debug");*/
		GraphUtil.startEngine();
		SampleGitHub gb=new SampleGitHub();
		gb.load();
		
		
	}
	
	
	public void load() throws Exception
	{
		int ctr=0;
		HttpClient client = null;
        GetMethod getMethod = null;
        int responseCode = -1;
        byte[] responseStream = null;

        String urlString = "https://api.github.com/search/repositories";
        String cookieString = null;
      //String urlString = "https://api.github.com/repos/rieder91/MachineLearning/tarball/master";
       // String urlString = "https://api.github.com/repos/nathanmarz/storm/tarball/master";
        
        
        
        client = new HttpClient();
        
        // Proxy settings: Configures the proxy host, port & user
        // credentials and the scope of the credentials.
       // client.getHostConfiguration().setProxy(proxy,8080);
        Credentials credentials = new UsernamePasswordCredentials
            ("shashankmjain", "");
        AuthScope scope = new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT);
        client.getState().setProxyCredentials(scope, credentials);
        
        // Sets the user-agent for the client instance
        //client.getParams().setParameter("http.useragent", "<USER_AGENT>");

        // Sends the GET request and gets the response
        getMethod = new GetMethod(urlString);
        
       // getMethod.getParams().setParameter("q", "tetris");
        getMethod.setQueryString("q=language:java");
        
        
       
        
        
        responseCode = client.executeMethod(getMethod);
       responseStream=getMethod.getResponseBody();
       
       Gson gson=new Gson(); 
       String json=new String(responseStream);
       
       
       
       
     
       GitHubData gitHubData=  gson.fromJson(json, GitHubData.class);
      // System.out.println("total count="+gitHubData.getTotal_count());
       List<Item> items=gitHubData.getItems();
       for(Item item:items)
       {
       ctr++;
       GraphUtil.addOrFindItemNode(item);
       
       String name=item.getName();
       
      
       
       String owner=item.getOwner().getLogin();
       
       System.out.println("item ="+item.getArchive_url());
       
      parserCollaborator(item);
      if(ctr==20) break;
       }
       //System.out.println("map="+map);
      // parseIssueEvents(item.getIssue_events_url());
       
       
     /* InputStream is = getMethod.getResponseBodyAsStream();
        
        
        FileOutputStream outputStream = 
                new FileOutputStream(new File("c:/shashank/dumps/m2m/storm.tar.gz"));

	int read = 0;
	byte[] bytes = new byte[1024];

	while ((read = is.read(bytes)) != -1) {
		outputStream.write(bytes, 0, read);
	}
        */
        
        
      //  System.out.println("Response Code: " + responseCode);
       // System.out.println(new String(responseStream));
        
	}
	private void parseFollowers(String url)
	{
		
		
	}
	private void parserCollaborator(Item item) throws Exception
	{
		String url1=item.getCollaborators_url();
		String[] urls=url1.split("\\{");
		String url=urls[0];
		System.out.println("collab url="+url);
		HttpClient client = null;
        GetMethod getMethod = null;
        int responseCode = -1;
        byte[] responseStream = null;

        
        String cookieString = null;
      //String urlString = "https://api.github.com/repos/rieder91/MachineLearning/tarball/master";
       // String urlString = "https://api.github.com/repos/nathanmarz/storm/tarball/master";
        
        
        
        client = new HttpClient();
        
        // Proxy settings: Configures the proxy host, port & user
        // credentials and the scope of the credentials.
        //client.getHostConfiguration().setProxy(proxy,8080);
        Credentials credentials = new UsernamePasswordCredentials
            ("shashankmjain", "");
        AuthScope scope = new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT);
        client.getState().setProxyCredentials(scope, credentials);
        
        // Sets the user-agent for the client instance
        //client.getParams().setParameter("http.useragent", "<USER_AGENT>");

        // Sends the GET request and gets the response
        getMethod = new GetMethod(url);
        
        
        responseCode = client.executeMethod(getMethod);
        responseStream=getMethod.getResponseBody();
        
        Gson gson=new Gson(); 
        String json=new String(responseStream);
        System.out.println(json);
      
        JsonParser parser = new JsonParser();
        JsonArray jArray = parser.parse(json).getAsJsonArray();
        
        ArrayList<Collaborator> lcs = new ArrayList<Collaborator>();
        
        for(JsonElement obj : jArray )
        {
        	Collaborator cse = gson.fromJson( obj , Collaborator.class);
            lcs.add(cse);
        }
        getProjectTar(lcs.get(0).getLogin(),item);
        
        
       
        /*for(Collaborator collab:lcs)
        {
      
        URI collabNode=GraphRestUtil.addOrFindCollaboratorNode(collab);
        URI itemNode=GraphRestUtil.addOrFindItemNode(item);
        System.out.println("item uri="+itemNode.toString());
        
        GraphRestUtil.addItemProperties(item,parsePropsURI(itemNode).toString());
        
        GraphRestUtil.addRelationship(parseURI(itemNode), parseURI(collabNode), "HAS",null,item.getId()+collab.getId());
       // parseFollower(collab);
        }*/
       // parseGists (collab.getGists_url());
       // parseStarred(collab.getStarred_url());
       // parseSubscriptions(collab.getSubscriptions_url());
       // Collaborators gitHubData=  gson.fromJson(json, Collaborators.class);
       
	}
	
	private URI parseURI(URI uri) throws Exception
	{
		StringBuffer sb=new StringBuffer(uri.toString());
		String newUrl=sb.reverse().toString();
		String[] str=newUrl.split("/");
		String id=str[0];
		StringBuffer sb1=new StringBuffer(id);
		String id1=sb1.reverse().toString();
		String url="http://gitty.sb02.stations.graphenedb.com:24789/db/data/node/"+id1;
		System.out.println("new url="+url);
		return new URI(url);
		}
	
	
	private URI parsePropsURI(URI uri) throws Exception
	{
		StringBuffer sb=new StringBuffer(uri.toString());
		String newUrl=sb.reverse().toString();
		String[] str=newUrl.split("/");
		String id=str[0];
		StringBuffer sb1=new StringBuffer(id);
		String id1=sb1.reverse().toString();
		String url="http://gitty.sb02.stations.graphenedb.com:24789/db/data/node/"+id1+"/properties";
		System.out.println("new url="+url);
		return new URI(url);
		}
	
	
	private void parseFollower(Collaborator collaborator) throws Exception
	{
		String[] urls=collaborator.getFollowers_url().split("\\{");
		String url=urls[0];
		System.out.println(url);
		HttpClient client = null;
        GetMethod getMethod = null;
        int responseCode = -1;
        byte[] responseStream = null;

        
        String cookieString = null;
      //String urlString = "https://api.github.com/repos/rieder91/MachineLearning/tarball/master";
       // String urlString = "https://api.github.com/repos/nathanmarz/storm/tarball/master";
        
        
        
        client = new HttpClient();
        
        // Proxy settings: Configures the proxy host, port & user
        // credentials and the scope of the credentials.
       // client.getHostConfiguration().setProxy(proxy,8080);
        Credentials credentials = new UsernamePasswordCredentials
            ("shashankmjain", "");
        AuthScope scope = new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT);
        client.getState().setProxyCredentials(scope, credentials);
        
        // Sets the user-agent for the client instance
        //client.getParams().setParameter("http.useragent", "<USER_AGENT>");

        // Sends the GET request and gets the response
        getMethod = new GetMethod(url);
        
        
        responseCode = client.executeMethod(getMethod);
        responseStream=getMethod.getResponseBody();
        
        Gson gson=new Gson(); 
        String json=new String(responseStream);
        System.out.println(json);
      
        JsonParser parser = new JsonParser();
        JsonArray jArray = parser.parse(json).getAsJsonArray();
        
        ArrayList<Follower> lcs = new ArrayList<Follower>();

        for(JsonElement obj : jArray )
        {
        	Follower cse = gson.fromJson( obj , Follower.class);
            lcs.add(cse);
        }
        
        
        for(Follower follower:lcs)
        {
        	
        	
        	URI followerNode=GraphRestUtil.addOrFindFollowerNode(follower);
            URI collabNode=GraphRestUtil.addOrFindCollaboratorNode(collaborator);
            //System.out.println("item uri="+itemNode.toString());
            
            
            
            GraphRestUtil.addRelationship(parseURI(followerNode), parseURI(collabNode), "HAS",null,collaborator.getId()+follower.getId());
             	
        	
      
        /*Node followerNode=GraphUtil.addOrFindFollowerNode(follower);
        Node collabNode=GraphUtil.addOrFindCollaboratorNode(collaborator);
        
        
        GraphUtil.addRelationship(collabNode, followerNode, RelTypes.HAS);*/
       // parseFollower(collab.getFollowers_url());
        }
        
       
        
	}
	
	private void parseIssueEvents(String url1) throws Exception
	{
		String[] urls=url1.split("\\{");
		String url=urls[0];
		System.out.println(url);
		HttpClient client = null;
        GetMethod getMethod = null;
        int responseCode = -1;
        byte[] responseStream = null;

        
        String cookieString = null;
      //String urlString = "https://api.github.com/repos/rieder91/MachineLearning/tarball/master";
       // String urlString = "https://api.github.com/repos/nathanmarz/storm/tarball/master";
        
        
        
        client = new HttpClient();
        
        // Proxy settings: Configures the proxy host, port & user
        // credentials and the scope of the credentials.
        client.getHostConfiguration().setProxy(proxy,8080);
        Credentials credentials = new UsernamePasswordCredentials
            ("shashankmjain", "");
        AuthScope scope = new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT);
        client.getState().setProxyCredentials(scope, credentials);
        
        // Sets the user-agent for the client instance
        //client.getParams().setParameter("http.useragent", "<USER_AGENT>");

        // Sends the GET request and gets the response
        getMethod = new GetMethod(url);
        
        
        responseCode = client.executeMethod(getMethod);
        responseStream=getMethod.getResponseBody();
        
        Gson gson=new Gson(); 
        String json=new String(responseStream);
        System.out.println(json);
      
        JsonParser parser = new JsonParser();
        JsonArray jArray = parser.parse(json).getAsJsonArray();
        
        ArrayList<IssueEvent> lcs = new ArrayList<IssueEvent>();

        for(JsonElement obj : jArray )
        {
        	IssueEvent cse = gson.fromJson( obj , IssueEvent.class);
            lcs.add(cse);
        }
        IssueEvent issueEvent=lcs.get(2);
        System.out.println("issueEvent actor="+issueEvent.getActor().getLogin());
       // Collaborators gitHubData=  gson.fromJson(json, Collaborators.class);
        
	}
	
	private void parseGists(String url1) throws Exception
	{
		String[] urls=url1.split("\\{");
		String url=urls[0];
		System.out.println(url);
		HttpClient client = null;
        GetMethod getMethod = null;
        int responseCode = -1;
        byte[] responseStream = null;

        
        String cookieString = null;
      //String urlString = "https://api.github.com/repos/rieder91/MachineLearning/tarball/master";
       // String urlString = "https://api.github.com/repos/nathanmarz/storm/tarball/master";
        
        
        
        client = new HttpClient();
        
        // Proxy settings: Configures the proxy host, port & user
        // credentials and the scope of the credentials.
        client.getHostConfiguration().setProxy(proxy,8080);
        Credentials credentials = new UsernamePasswordCredentials
            ("shashankmjain", "");
        AuthScope scope = new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT);
        client.getState().setProxyCredentials(scope, credentials);
        
        // Sets the user-agent for the client instance
        //client.getParams().setParameter("http.useragent", "<USER_AGENT>");

        // Sends the GET request and gets the response
        getMethod = new GetMethod(url);
        
        
        responseCode = client.executeMethod(getMethod);
        responseStream=getMethod.getResponseBody();
        
        Gson gson=new Gson(); 
        String json=new String(responseStream);
        System.out.println(json);
      
        JsonParser parser = new JsonParser();
        JsonArray jArray = parser.parse(json).getAsJsonArray();
        
        ArrayList<GistsURL> lcs = new ArrayList<GistsURL>();

        for(JsonElement obj : jArray )
        {
        	GistsURL cse = gson.fromJson( obj , GistsURL.class);
            lcs.add(cse);
        }
        GistsURL gist=lcs.get(1);
        System.out.println("gist created="+gist.getCreatedAt());
       // Collaborators gitHubData=  gson.fromJson(json, Collaborators.class);
        
	}
	
	
	private void parseStarred(String url1) throws Exception
	{
		String[] urls=url1.split("\\{");
		String url=urls[0];
		System.out.println(url);
		HttpClient client = null;
        GetMethod getMethod = null;
        int responseCode = -1;
        byte[] responseStream = null;

        
        String cookieString = null;
      //String urlString = "https://api.github.com/repos/rieder91/MachineLearning/tarball/master";
       // String urlString = "https://api.github.com/repos/nathanmarz/storm/tarball/master";
        
        
        
        client = new HttpClient();
        
        // Proxy settings: Configures the proxy host, port & user
        // credentials and the scope of the credentials.
        client.getHostConfiguration().setProxy(proxy,8080);
        Credentials credentials = new UsernamePasswordCredentials
            ("shashankmjain", "");
        AuthScope scope = new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT);
        client.getState().setProxyCredentials(scope, credentials);
        
        // Sets the user-agent for the client instance
        //client.getParams().setParameter("http.useragent", "<USER_AGENT>");

        // Sends the GET request and gets the response
        
        System.out.println("starred url="+url);
        getMethod = new GetMethod(url);
        
        
        responseCode = client.executeMethod(getMethod);
        responseStream=getMethod.getResponseBody();
        
        Gson gson=new Gson(); 
        String json=new String(responseStream);
        System.out.println(json);
      
        JsonParser parser = new JsonParser();
        JsonArray jArray = parser.parse(json).getAsJsonArray();
        
        ArrayList<StarredURL> lcs = new ArrayList<StarredURL>();

        for(JsonElement obj : jArray )
        {
        	StarredURL cse = gson.fromJson( obj , StarredURL.class);
            lcs.add(cse);
        }
        StarredURL starred=lcs.get(0);
        System.out.println("starred name="+starred.getDescription());
       // Collaborators gitHubData=  gson.fromJson(json, Collaborators.class);
        
	}
	
	private void parseSubscriptions(String url) throws Exception
	{
		
		HttpClient client = null;
        GetMethod getMethod = null;
        int responseCode = -1;
        byte[] responseStream = null;

        
        String cookieString = null;
      //String urlString = "https://api.github.com/repos/rieder91/MachineLearning/tarball/master";
       // String urlString = "https://api.github.com/repos/nathanmarz/storm/tarball/master";
        
        
        
        client = new HttpClient();
        
        // Proxy settings: Configures the proxy host, port & user
        // credentials and the scope of the credentials.
        client.getHostConfiguration().setProxy(proxy,8080);
        Credentials credentials = new UsernamePasswordCredentials
            ("shashankmjain", "");
        AuthScope scope = new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT);
        client.getState().setProxyCredentials(scope, credentials);
        
        // Sets the user-agent for the client instance
        //client.getParams().setParameter("http.useragent", "<USER_AGENT>");

        // Sends the GET request and gets the response
        
        System.out.println("starred url="+url);
        getMethod = new GetMethod(url);
        
        
        responseCode = client.executeMethod(getMethod);
        responseStream=getMethod.getResponseBody();
        
        Gson gson=new Gson(); 
        String json=new String(responseStream);
        System.out.println(json);
      
        JsonParser parser = new JsonParser();
        JsonArray jArray = parser.parse(json).getAsJsonArray();
        
        ArrayList<Subscription> lcs = new ArrayList<Subscription>();

        for(JsonElement obj : jArray )
        {
        	Subscription cse = gson.fromJson( obj , Subscription.class);
            lcs.add(cse);
        }
        Subscription subscription=lcs.get(0);
        System.out.println("subscription desc="+subscription.getDescription());
       // Collaborators gitHubData=  gson.fromJson(json, Collaborators.class);
        
	}
	private void getProjectTar(String login,Item item) throws Exception
	{
		HttpClient client = null;
        GetMethod getMethod = null;
        int responseCode = -1;
        byte[] responseStream = null;

      //  String urlString = "https://api.github.com/search/repositories";
        String cookieString = null;
      String urlString = "https://api.github.com/repos/"+login+"/"+item.getName()+"/tarball/master";
        System.out.println("download url="+urlString);
        
        client = new HttpClient();
        
        // Proxy settings: Configures the proxy host, port & user
        // credentials and the scope of the credentials.
        //client.getHostConfiguration().setProxy("proxy.sin.sap.corp",8080);
        Credentials credentials = new UsernamePasswordCredentials
            ("shashankmjain", "");
        AuthScope scope = new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT);
        client.getState().setProxyCredentials(scope, credentials);
        
        // Sets the user-agent for the client instance
        //client.getParams().setParameter("http.useragent", "<USER_AGENT>");

        // Sends the GET request and gets the response
        getMethod = new GetMethod(urlString);
        
       // getMethod.getParams().setParameter("q", "tetris");
        //getMethod.setQueryString("q=machinelearning");
        responseCode = client.executeMethod(getMethod);
        InputStream is = getMethod.getResponseBodyAsStream();
        
        
        FileOutputStream outputStream = 
                new FileOutputStream(new File("c:/shashank/dumps/github_mining/projects/"+item.getId()+".tar.gz"));

	int read = 0;
	byte[] bytes = new byte[1024];

	while ((read = is.read(bytes)) != -1) {
		outputStream.write(bytes, 0, read);
	}
        
        
        
        System.out.println("Response Code: " + responseCode);
       // System.out.println("Response Body: \n" + new String(responseStream));
        
	}
	
}
