package com.stack.parser.nlp;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.TermEnum;
import org.apache.lucene.index.TermFreqVector;
import org.apache.lucene.store.FSDirectory;


public class TermProcessor {
	
	public Map processDocument(String indexDirName) throws CorruptIndexException, IOException
	{
		Map map=new HashMap();
		IndexReader reader = IndexReader.open(FSDirectory.open(new File(indexDirName)));
		System.out.println(reader.numDocs());
		TermEnum termEnum = reader.terms();
		ArrayList<String> termList = new ArrayList<String>();
		
		while (termEnum.next())
		{
			String term = termEnum.term().text();
			termList.add(term);
		}
		
		for (int i = 0; i < termList.size(); i++)
		{
			System.out.printf("%-20s",termList.get(i));
			String term = termList.get(i);
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < reader.numDocs(); j++)
			{
				double tfidf=getTFIDF(reader, term, "contents", j);
				if(tfidf>0)
				System.out.println(term +" tfidf="+getTFIDF(reader, term, "contents", j));
				map.put(term, tfidf);
				//System.out.println(term);
			}
			
		}
		return map;
	}
	public double getTF(IndexReader reader, String term, String field, int docID) throws IOException
	{
		TermFreqVector termVector = reader.getTermFreqVector(docID, field);
		int idx = termVector.indexOf(term);
		if (idx == -1)
		{
			return 0;
		}
		else
		{
			int[] freqs = termVector.getTermFrequencies();
			return freqs[idx];
		}
	}
	
	public double getIDF(IndexReader reader, String field, String termName) throws IOException
	{
		return Math.log(reader.numDocs()/ ((double)reader.docFreq(new Term(field, termName))));
	}
	
	public double getTFIDF(IndexReader reader, String termName, String field, int docID) throws IOException
	{
		return getTF(reader, termName, field, docID) * getIDF(reader, field, termName);
	}
}
