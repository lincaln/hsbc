package com.test;

import org.junit.jupiter.api.Test;

public class DoTest {

	@Test
	public void test() {
		StringFormat sf=StringFormat.getInstance();
		//Stage 1
		sf.setDictionary(new String[]{ "i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream","man go"});
		String word="ilikesamsung";
		sf.takeWord(word);
		
		//Stage 2
		word="ilikeicecreamandmango";
		sf.takeWord(word,new String[]{"i", "like", "sam", "sung", "mobile", "icecream", "man go", "mango"});
		
		//Stage 3
		word="ilikeicecreamandmangoOK";
		sf.takeUnitWord(word,new String[]{"OK"});
	}
}
