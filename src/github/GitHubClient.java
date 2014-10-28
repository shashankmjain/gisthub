package github;

import java.util.Map;
import java.util.TreeMap;

import org.kohsuke.github.GHBranch;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

public class GitHubClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//GitHub github = GitHub.connect();
		
		GitHub github = GitHub.connectUsingPassword("shashankmjain", "welcome1");
		
		GHRepository repo=github.getRepository("twitter/algebird");
		
		Map branches=repo.getBranches();
		
		
		
		System.out.println(branches);
		

	}

}
