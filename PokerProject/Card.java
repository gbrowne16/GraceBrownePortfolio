package PokerSimulation;
//this class represents an individual card, it assigns each card object 
// a value and suit, then has helper methods to return these values, it also has a method to get the image file name
//so in Part 3 I could correctly display the cards.
//I tested this by creating cards and then using the helper methods - and making sure I was getting the correct
//returned object I wanted
public class Card {
    public int value;
    public String suit;

//this is a constuctor that creates a card object with a value and suit, it takes the parameters of a value and suit
//and initializes them
    public Card(int theValue, String theSuit){
        value = theValue;
        suit = theSuit;
    }

    //this is a helper method that returns the value of a card
public int getValue(){
    return value;
}

 //this is a helper method that returns the suit of a card
public String getSuit(){
    return suit;
}

//this method returns an image name for each Card, it is used to display the correct image for each card in runner
//if a card is a face car (value>10), it has its own conditional, as the value is not part of the image name,
//instead, they each have specific names jack, queen, king, ace). If a card is not a face card, the value is used as 
//part of the image name.
public String imageFileName(){
    if(value==11){
        return "jack_of_"+suit+".png";
        }
    else if(value==12){
        return "queen_of_"+suit+".png";
        }
    else if(value==13){
        return "king_of_"+suit+".png";
        }
    else if(value==14){
        return "ace_of_"+suit+".png";
        }
    else{
        return value + "_of_"+suit+".png";
        }
}
//this is a to-string method that makes the return more easily read, and makes testing easier, if a card is a face car 
//(value>10), it has its own conditional, as the value is not part of the card name, instead, they each have 
//specific names jack, queen, king, ace). If a card is not a face card, the value is used as part of the return name. 
public String toString(){
    if(value==11){
        return "Jack of "+suit;
        }
    else if(value==12){
        return "Queen of "+suit;
        }
    else if(value==13){
        return "King of "+suit;
        }
    else if(value==14){
        return "Ace of "+suit;
        }
    else{
        return value + " of "+suit;
        }
}
}
