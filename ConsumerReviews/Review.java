package ConsumerReviews;


    import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

/**
 * Class that contains helper methods for the Review Lab
 **/
public class Review {
  
  private static HashMap<String, Double> sentiment = new HashMap<String, Double>();
  private static ArrayList<String> posAdjectives = new ArrayList<String>();
  private static ArrayList<String> negAdjectives = new ArrayList<String>();
 
  
  private static final String SPACE = " ";
  
  static{
    try {
      Scanner input = new Scanner(new File("/Users/gracebrowne/Desktop/CSA/ConsumerReviews/cleanSentiment.csv"));
      while(input.hasNextLine()){
        String[] temp = input.nextLine().split(",");
        sentiment.put(temp[0],Double.parseDouble(temp[1]));
        //System.out.println("added "+ temp[0]+", "+temp[1]);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing cleanSentiment.csv");
    }
  
  
  //read in the positive adjectives in postiveAdjectives.txt
     try {
      Scanner input = new Scanner(new File("/Users/gracebrowne/Desktop/CSA/ConsumerReviews/positiveAdjectives.txt"));
      while(input.hasNextLine()){
        String temp = input.nextLine().trim();
        // System.out.println(temp);
        posAdjectives.add(temp);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing postitiveAdjectives.txt\n" + e);
    }   
 
  //read in the negative adjectives in negativeAdjectives.txt
     try {
      Scanner input = new Scanner(new File("/Users/gracebrowne/Desktop/CSA/ConsumerReviews/negativeAdjective.txt"));
      while(input.hasNextLine()){
        negAdjectives.add(input.nextLine().trim());
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing negativeAdjectives.txt");
    }   
  }
  
  /** 
   * returns a string containing all of the text in fileName (including punctuation), 
   * with words separated by a single space 
   */
  public static String textToString( String fileName )
  {  
    String temp = "";
    try {
      Scanner input = new Scanner(new File(fileName));
      
      //add 'words' in the file to the string, separated by a single space
      while(input.hasNext()){
        temp = temp + input.next() + " ";
      }
      input.close();
      
    }
    catch(Exception e){
      System.out.println("Unable to locate " + fileName);
    }
    //make sure to remove any additional space that may have been added at the end of the string.
    return temp.trim();
  }
  
  /**
   * @returns the sentiment value of word as a number between -1 (very negative) to 1 (very positive sentiment) 
   */
  public static double sentimentVal( String word )
  {
    try
    {
      return sentiment.get(word.toLowerCase());
    }
    catch(Exception e)
    {
      return 0;
    }
  }
  
  /**
   * Returns the ending punctuation of a string, or the empty string if there is none 
   */
  public static String getPunctuation( String word )
  { 
    String punc = "";
    for(int i=word.length()-1; i >= 0; i--){
      if(!Character.isLetterOrDigit(word.charAt(i))){
        punc = punc + word.charAt(i);
      } else {
        return punc;
      }
    }
    return punc;
  }
  
    /**
   * Returns the word after removing any beginning or ending punctuation
   */
  public static String removePunctuation( String word )
  {
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(0)))
    {
      word = word.substring(1);
    }
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(word.length()-1)))
    {
      word = word.substring(0, word.length()-1);
    }
    
    return word;
  }
  
  /** 
   * Randomly picks a positive adjective from the positiveAdjectives.txt file and returns it.
   */
  public static String randomPositiveAdj()
  {
    int index = (int)(Math.random() * posAdjectives.size());
    return posAdjectives.get(index);
  }
  
  /** 
   * Randomly picks a negative adjective from the negativeAdjectives.txt file and returns it.
   */
  public static String randomNegativeAdj()
  {
    int index = (int)(Math.random() * negAdjectives.size());
    return negAdjectives.get(index);
    
  }
  
  /** 
   * Randomly picks a positive or negative adjective and returns it.
   */
  public static String randomAdjective()
  {
    boolean positive = Math.random() < .5;
    if(positive){
      return randomPositiveAdj();
    } else {
      return randomNegativeAdj();
    }
  }
// This method works using an iteration that loops through every character(no puncuation) in the String. It uses conditionals 
//to determine if the character was the first or last character in a word or in the String. It determined the placement within 
//a word by analyzing if a space came before or after the letter. Then, it stores the index of this first or last letter in a 
//variable and turnes a boolean true. When both booleans are true (both a first and last letter were located), their indexes 
//were used to create a substring and then used the sentimentVal method to store that word's sentiment value to a count. 
//Then the booleans were both set to false to begin the search for the next word. Finally, the count was returned.
  public static double totalSentiment(String fileName){
    String fileAsString = (textToString(fileName));
  
    double count = 0.0;
    int first = 0;
    int last = 0;
    boolean isFirst=false;
    boolean isLast= false;
    for(int i=1; i<=fileAsString.length(); i++){
      if(i==1||fileAsString.substring(i-1, i).equals(" ")){
    
        first= (i-1);
        isFirst=true;
      }
      if((fileAsString.length())==i||fileAsString.substring(i, i+1).equals(" ")){
        last = (i-1);
        isLast=true;
      }
      if(((fileAsString.length()-1)==i)&&fileAsString.substring(i).equals(" ")){
        last=(i);
        isLast=true;
      }
      if(isFirst&&isLast){
        count+=(1.0)*(sentimentVal(removePunctuation(fileAsString.substring(first, last+1))));
        isFirst=false;
        isLast=false;
      }
    }
    return count;
  }
  //i chose these cutoff values because I wanted the ranges to be equal(30 in between 1 star high cut off and 5 star low cutoff), and I noticed that more reviews were over 0 than under zero, so I gave 3 star to positives instead of negatives or both.
  public static int starRating(String fileName){
    double value = totalSentiment(fileName);
    int returnVal;
    if(value<=-10){
      returnVal=1;
    }
    else if(value<=0){
      returnVal=2;
    }
    else if(value<=10){
      returnVal=3;
    }
    else if(value<=20){
      returnVal=4;
    }
    else{
      returnVal=5;
    }
    return returnVal;
  }
//this method works by first using an iteration to cycle through every character in the file(that is turned into a string), if 
//the character before a letter is an *, it is marked as the first letter of an adjective. If there has already been a first letter
//of an adjective found and the character after a letter is a space, it is marked as the last letter of an adjective. If there are 
//both first and last letters found, first all characters between the last adjective and the new one is added to a string, then 
//a new (either pos or neg depending on the original adjective) random adjective is added. Then the last letter in the original 
//adjective's position is marked to determine the characters to add next time an adjective is found. When the iteration is finished,
//all remaining characters are added to the string, and the string is returned.
  public static String fakeReview(String fileName){
    String fileAsString = textToString(fileName);
    String fakeString = "";
    int first = 0;
    int last = 0;
    boolean isFirst=false;
    boolean isLast= false;
    int tempFirst = 0;
    for(int i=1; i<=fileAsString.length(); i++){
     if(i!=fileAsString.length()){

      if(fileAsString.substring(i-1, i).equals("*")){
        first= (i-1);
        isFirst=true;
        
      }
      if((fileAsString.substring(i, i+1).equals(" ")&&isFirst)){
        last = (i-1);
        isLast=true;
        
      }
      if(isFirst&&isLast){
        
        if((1.0)*(sentimentVal(removePunctuation(fileAsString.substring(first, last+1))))>0 ){
          fakeString+=fileAsString.substring(tempFirst, first);
          fakeString+=randomPositiveAdj();
          tempFirst=last+1;
        }
        else if((1.0)*(sentimentVal(removePunctuation(fileAsString.substring(first, last+1))))<0 ){
          fakeString+=fileAsString.substring(tempFirst, first);
          fakeString+=randomNegativeAdj();
          tempFirst=last+1;
          }
        isFirst=false;
        isLast=false;
      }
    }
     
      }
    fakeString+=fileAsString.substring(tempFirst);
    return fakeString;
  }
  //this method works by first using an iteration to cycle through every character in the file(that is turned into a string), if 
//the character before a letter is an *, it is marked as the first letter of an adjective. If there has already been a first letter
//of an adjective found and the character after a letter is a space, it is marked as the last letter of an adjective. If there are 
//both first and last letters found and the star value of the original file is greater or equal to 3, first all characters between the 
//last adjective and the new one is added to a string, then a new random adjective, whose sentiment value is greater than the orignal 
//adjective's is added. Then the last letter in the original adjective's position is marked to determine the characters to add next 
//time an adjective is found.If there are both first and last letters found and the star value of the original file is less than 3, 
//first all characters between the last adjective and the new one is added to a string, then a new random adjective, whose sentiment 
//value is less than the orignal adjective's is added. Then the last letter in the original adjective's position is marked to 
//determine the characters to add next time an adjective is found. When the iteration is finished, all remaining characters are 
//added to the string, and the string is returned.
  public static String strongerReview(String fileName){
    String fileAsString = textToString(fileName);
    String fakeString = "";
    int first = 0;
    int last = 0;
    boolean isFirst=false;
    boolean isLast= false;
    int tempFirst = 0;
    boolean found = true;
    for(int i=1; i<=fileAsString.length(); i++){
     if(i!=fileAsString.length()){

      if(fileAsString.substring(i-1, i).equals("*")){
        first= (i-1);
        isFirst=true;
        
      }
      if((fileAsString.substring(i, i+1).equals(" ")&&isFirst)){
        last = (i-1);
        isLast=true;
        
      }
      if(isFirst&&isLast){
        String word = "";
        found=true;
        
       if(starRating(fileName)>=3){
        while(found){
        word = randomAdjective();
        if((1.0)*(sentimentVal(word))>((1.0)*(sentimentVal(removePunctuation(fileAsString.substring(first, last+1)))))){
          found = false;
        }
      }
       }
       else{
        while(found){
        word = randomAdjective();
        if((1.0)*(sentimentVal(word))<((1.0)*(sentimentVal(removePunctuation(fileAsString.substring(first, last+1)))))){
          found = false;
        }
      }
       }
        
          fakeString+=fileAsString.substring(tempFirst, first);
          fakeString+=word;
          tempFirst=last+1;
        isFirst=false;
        isLast=false;
      }
    }
     
      }
    fakeString+=fileAsString.substring(tempFirst);
    return fakeString;
  }

}
