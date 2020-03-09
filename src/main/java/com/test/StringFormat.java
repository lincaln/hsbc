package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringFormat {

	private String[] dictionary;
	private StringFormat() {
		
	}
	
	private static StringFormat sf=new StringFormat();
	
	public static StringFormat getInstance(){
		return sf; 
	}

	public String[] getDictionary() {
		return dictionary;
	}

	public void setDictionary(String[] dictionary) {
		this.dictionary = dictionary;
	}
	
	/*public String takeWord(String word) {
		List<String> newWords = new ArrayList<String>();
		for (int i = 0; i < dictionary.length; i++) {
			if(word.indexOf(dictionary[i])!=-1) {
				newWords.add((dictionary[i]));
			}
		}
		String retrunWord=String.join(" ", newWords);
		return retrunWord;
	}*/
	/**
	 * If user provide a customized dictionary of valid English words as additional input, and the
program will find all the valid words in the both dictionaries
                      根据字符串word,和用户字典userDictionary,还有对象的字典来打印
	 * @param word
	 * @param userDictionary
	 */
	public  void takeUnitWord(String word,String[] userDictionary){
		List<String> list = new ArrayList<String>(Arrays.asList(dictionary)); 
		list.addAll(Arrays.asList(userDictionary)); 
		String[] newDictionary=list.toArray(new String[list.size()]);
		wordBreak(word,newDictionary);
	}
	
	/**
	 * If user provide a customized dictionary of valid English words as additional input, and the
program will only find in the user customized dictionary
                   根据字符串word,和用户字典userDictionary打印
	 * @param word
	 * @param userDictionary
	 */
	public void takeWord(String word,String[] userDictionary){
		wordBreak(word,userDictionary);
	}
	/**
	 * Given a valid sentence without any spaces between the words and a dictionary of valid
English words, find all possible ways to break the sentence in individual dictionary words.
	 * 根据字符串word打印
	 * @param word
	 */
	public void takeWord(String word){
		wordBreak(word,this.dictionary);
	}
	 
	private  void wordBreak(String word,String[] theDictionary){
		List<String> al = new ArrayList<String>();
		List<String> dics= new ArrayList<String>();
		for (int i = 0; i < theDictionary.length; i++) {
			String[] dicWords=theDictionary[i].split(" ");
			for (int j = 0; j < dicWords.length; j++) {
				dics.add(dicWords[j]);
			}
		}
		wordBreakRec(word, al,dics.toArray(new String[dics.size()]));
	}
	
		private  void wordBreakRec(String s, List<String> al,String[] userDictionary){
			int len = s.length();
			if(len == 0){
				System.out.println(String.join(" ", al));
				return;
			}
			
			// DFS
			for(int i=1; i<=len; i++){
				String substr = s.substring(0, i);
				if(dictionaryContains(substr,userDictionary)){
					al.add(substr);
					wordBreakRec(s.substring(i), al,userDictionary);
					al.remove(al.size()-1);
				}
			}
		}
		private  boolean dictionaryContains(String word,String[] dictionary){
			
			for(int i=0; i<dictionary.length; i++){
				String dic=dictionary[i].replace(" ",""); 
				if(dic.equals(word)){
					return true;
				}
			}
			
			if("and".equals(word)){
				return true;
			}
			return false;
		}
	
}

