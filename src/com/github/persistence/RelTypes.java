package com.github.persistence;

import org.neo4j.graphdb.RelationshipType;

public  enum RelTypes implements RelationshipType{
	 HAS,
	 WORKSON,
	 HASPARENT
}
