package com.stack.parser.nlp;
import java.util.List;
import java.util.Map;

import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.store.LockObtainFailedException;

import com.stack.parser.StackParser;


public class TestIndex {

	public static void main(String[] args) throws CorruptIndexException, LockObtainFailedException, Exception
	{
		Indexer indexer = new Indexer("C:/shashank/dumps/github_mining/stackoverflow/files/", "C:/shashank/dumps/github_mining/stackoverflow/indexOut");
		indexer.index();
		List<String> tags=StackParser.parseStackTags("C:/shashank/dumps/github_mining/stackoverflow/datascience/Tags.xml");
		//StackParser.parseStackTags("C:/shashank/dumps/github_mining/stackoverflow/codereview.stackexchange.com/Tags.xml");
		//parseTags("C:/shashank/dumps/github_mining/stackoverflow/android.stackexchange.com/Tags.xml");
		TermProcessor processor = new TermProcessor();
		Map terms=processor.processDocument("C:/shashank/dumps/github_mining/stackoverflow/indexOut");
		
		for(String str:tags)
		{
			if(terms.containsKey(str))
			{
				System.out.println("found term in map="+str);
			}
		}
	}
}
