package com.stack.parser.nlp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.util.Collections;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.namefind.NameSampleDataStream;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.Span;
import opennlp.tools.util.featuregen.AdaptiveFeatureGenerator;

public class NLPTrainer {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		/*String taggedSent =
				"<START:tech> Britney Spears <END> was reunited " +
				"with her sons <START:date> Saturday <END> ";
		
		String newText =
				"I like <START:tech> machine learning <END> as it is cool. ";
				ObjectStream<NameSample> nss = new NameSampleDataStream(
				new PlainTextByLineStream(new StringReader(newText)));
				TokenNameFinderModel model = NameFinderME.train(
				"en",
				"default" ,
				nss,
				(AdaptiveFeatureGenerator) null,
				Collections.<String,Object>emptyMap(),
				70 , 1 );
				File outFile = new File("C:/shashank/dumps/github_mining/opennlp_models/train","multi-custom.bin");
				FileOutputStream outFileStream = new FileOutputStream(outFile);
				model.serialize(outFileStream);
				NameFinderME nameFinder = new NameFinderME(model);
				String[] tokens =
				("machine learning  is cool.")
				.split("\\s+");
				Span[] names = nameFinder.find(tokens);
		
		Span nameSpans[] = nameFinder.find(tokens);
		 
		for(Span s: nameSpans)
			System.out.println(s.toString());*/
		
		
		File inFile = new File("C:/shashank/dumps/github_mining/opennlp_models/train","tech.train");
		NameSampleDataStream nss = new NameSampleDataStream(
		new PlainTextByLineStream(
		new java.io.FileReader(inFile)));
		int iterations = 100;
		int cutoff = 5;
		TokenNameFinderModel model = NameFinderME.train(
		"en", // language
		"default", // type
		nss,
		(AdaptiveFeatureGenerator) null,
		Collections.<String,Object>emptyMap(),
		iterations,
		cutoff);
		
		File outFile = new File("C:/shashank/dumps/github_mining/opennlp_models/train", "tech-custom.bin");
		FileOutputStream outFileStream = new FileOutputStream(outFile);
		model.serialize(outFileStream);
		
		NameFinderME nameFinder = new NameFinderME(model);
		String[] tokens =
				("At an altitude of 500m the temperature of boiling water")
				.split("\\s+");
		
		Span nameSpans[] = nameFinder.find(tokens);
		 
		for(Span s: nameSpans)
			System.out.println(s.toString());
		

	}

	
}
