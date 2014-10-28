package com.github.sonar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;

import com.google.gson.Gson;

public class SonarClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*Sonar sonar = Sonar.create("http://localhost:9000", "admin", "admin");
		
		ResourceQuery query=ResourceQuery.createForMetrics("my:project","coverage");
		
		ResourceQuery.create("");
		 query.setIncludeTrends(true);
		    query.setMetrics("coverage", "lines", "complexity", "commented_out_code_lines", "qi-complex-distrib");
		
		    Resource file = sonar.find(query);
		    
		    Measure measure = file.getMeasure("complexity");
		    System.out.print(measure.getValue());*/
	/*	String projectKey = "my:project";
	    String manualMetricKey = "burned_budget";

	    sonar.create(ManualMeasureCreateQuery.create(projectKey, manualMetricKey).setValue(50.0));

	    for (ManualMeasure manualMeasure : sonar.findAll(ManualMeasureQuery.create(projectKey))) {
	      System.out.println("Manual measure on project: " + manualMeasure);
	    }
*/	  
		
	getData();
	}
	private void downloadProjectFromGitHub() throws Exception
	{
		HttpClient client = null;
        GetMethod getMethod = null;
        int responseCode = -1;
        byte[] responseStream = null;

      //  String urlString = "https://api.github.com/search/repositories";
        String cookieString = null;
      String urlString = "https://api.github.com/repos/rieder91/MachineLearning/tarball/master";
        
        
        client = new HttpClient();
        
        // Proxy settings: Configures the proxy host, port & user
        // credentials and the scope of the credentials.
        client.getHostConfiguration().setProxy("proxy.sin.sap.corp",8080);
        Credentials credentials = new UsernamePasswordCredentials
            ("username", "password");
        AuthScope scope = new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT);
        client.getState().setProxyCredentials(scope, credentials);
        
        // Sets the user-agent for the client instance
        //client.getParams().setParameter("http.useragent", "<USER_AGENT>");

        // Sends the GET request and gets the response
        getMethod = new GetMethod(urlString);
        
       // getMethod.getParams().setParameter("q", "tetris");
        getMethod.setQueryString("q=machinelearning");
        responseCode = client.executeMethod(getMethod);
        InputStream is = getMethod.getResponseBodyAsStream();
        
        
        FileOutputStream outputStream = 
                new FileOutputStream(new File("c:/shashank/dumps/m2m/ml.tar.gz"));

	int read = 0;
	byte[] bytes = new byte[1024];

	while ((read = is.read(bytes)) != -1) {
		outputStream.write(bytes, 0, read);
	}
        
        
        
        System.out.println("Response Code: " + responseCode);
       // System.out.println("Response Body: \n" + new String(responseStream));
        
	}
	

		
		
	
		//System.out.println(struts.getMeasure("violations"));
		

	public static void getData() throws Exception
	{
		HttpClient client = null;
        GetMethod getMethod = null;
        int responseCode = -1;
        byte[] responseStream = null;

        //String urlString = "http://localhost:9000/api/resources?resource=my:project&depth=-1&scopes=FIL&limit=10";
        
        String urlString = "http://localhost:9000/api/issues/search?componentRoots=my:project";
        String cookieString = null;
      //String urlString = "https://api.github.com/repos/rieder91/MachineLearning/tarball/master";
       // String urlString = "https://api.github.com/repos/nathanmarz/storm/tarball/master";
        
        
        
        client = new HttpClient();
        
        // Proxy settings: Configures the proxy host, port & user
        // credentials and the scope of the credentials.
       // client.getHostConfiguration().setProxy(proxy,8080);
        Credentials credentials = new UsernamePasswordCredentials
            ("admin", "admin");
        AuthScope scope = new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT);
        client.getState().setProxyCredentials(scope, credentials);
        
        // Sets the user-agent for the client instance
        //client.getParams().setParameter("http.useragent", "<USER_AGENT>");

        // Sends the GET request and gets the response
        getMethod = new GetMethod(urlString);
        
       // getMethod.getParams().setParameter("q", "tetris");
       // getMethod.setQueryString("q=language:python");
        
        
       
        Map ruleMap=new HashMap();
        
        responseCode = client.executeMethod(getMethod);
       responseStream=getMethod.getResponseBody();
       String issueRes=new String(responseStream);
       Gson gson=new Gson();
       
       SonarIssues issues=gson.fromJson(issueRes,SonarIssues.class);
       
       
       //System.out.println(user.getLogin());
       List<Rule> rules=issues.getRules();
       
       for(Rule rule:rules)
       {
    	   ruleMap.put(rule.getKey(),rule.getName());
       }
       
       
       List<Issue> issues1=issues.getIssues();
       for(Issue issue:issues1)
       {
       //System.out.println(comp.getLongName());
    	   String ruleName=(String)ruleMap.get(issue.getRule());
    	   System.out.println("component="+issue.getComponent());
    	   System.out.println("violation at line="+issue.getLine()+" violation type="+ruleName);
    	   
    	   
    	   
       }
       //System.out.println(rule.getClass());
       //System.out.println(rule.getKey());
       //System.out.println(rule.getName());
       //System.out.println(rule.getDesc());
       
       
       //System.out.println(new String(responseStream));
		
	}
	
	
	public static void getData1() throws Exception
	{
		HttpClient client = null;
        GetMethod getMethod = null;
        int responseCode = -1;
        byte[] responseStream = null;

        //String urlString = "http://localhost:9000/api/resources?resource=my:project&depth=-1&scopes=FIL&limit=10";
        
        String urlString = "http://localhost:9000/api/issues/search?key=my:project";
        String cookieString = null;
      //String urlString = "https://api.github.com/repos/rieder91/MachineLearning/tarball/master";
       // String urlString = "https://api.github.com/repos/nathanmarz/storm/tarball/master";
        
        
        
        client = new HttpClient();
        
        // Proxy settings: Configures the proxy host, port & user
        // credentials and the scope of the credentials.
       // client.getHostConfiguration().setProxy(proxy,8080);
        Credentials credentials = new UsernamePasswordCredentials
            ("admin", "admin");
        AuthScope scope = new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT);
        client.getState().setProxyCredentials(scope, credentials);
        
        // Sets the user-agent for the client instance
        //client.getParams().setParameter("http.useragent", "<USER_AGENT>");

        // Sends the GET request and gets the response
        getMethod = new GetMethod(urlString);
        
       // getMethod.getParams().setParameter("q", "tetris");
       // getMethod.setQueryString("q=language:python");
        
        
       
        
        
        responseCode = client.executeMethod(getMethod);
       responseStream=getMethod.getResponseBody();
       String issueRes=new String(responseStream);
       
       System.out.println(issueRes);
       //System.out.println(rule.getClass());
       //System.out.println(rule.getKey());
       //System.out.println(rule.getName());
       //System.out.println(rule.getDesc());
       
       
       //System.out.println(new String(responseStream));
		
	}

}
