package PokerSimulation;
import java.util.ArrayList;
//this class represents a full deck of cards. It creates a Deck object that contains one of every card, then has
//a shuffle method that randomizes the deck, and a deal card that removes and returns the last card in the deck.
//I tested this by printing out unsorted decks, sorted deck, and printing the deal method to make sure it was correctly 
// removing the value and making sure it was the correct value removed

public class Deck {
    ArrayList<Card> cards = new ArrayList<>();
    //this is a constructor that creates a deck with onee of each possible card, it creates cards with values from
    //2-14 for each suit, and adds them to an empty ArrayList of Cards called cards. It uses a nested for loop to
    //accomplish this, with one of the loops going through each suit, and one of the for loops going through each value
    public Deck(){
        String suit;
        for(int i = 0; i<4; i++){
            for(int j=2; j<15; j++){
                if(i==0){
                    suit="hearts";
                }
                else if(i==1){
                    suit="diamonds";
                }
                else if(i==2){
                    suit="clubs";
                }
                else{
                    suit="spades";
                }
                Card newCard = new Card(j, suit);
                cards.add(newCard);

            }
        }
    }
    //this is a method that shuffles the deck into a random order, it uses for-loop to loop each card in the deck
    //then, for each iteration of the for-loop it assigns a random temp value from 0-the deck size, then the card at the random
    //position (temp1) will be saved to the Card temp2. Then, these to cards are switched. The use of the temp
    //values is to make sure the cards are switched, and that no 1 card replaces another instead of trading positions
    //with it.
    public void shuffle(){
        for(int i = 0; i<cards.size(); i++){
            int temp1 = (int)(Math.random()*(cards.size()));
            Card temp2 = cards.get(temp1);
            cards.set(temp1, cards.get(i));
            cards.set(i, temp2);
        }
    }
    //this is a method that removes and returns the last card in a deck, it saves the Card at the last index
    //of the arrayList cards to a variable, then removes the card at the index. Finally, it return the variable.
    public Card deal(){
        Card last = cards.get(cards.size()-1);
        cards.remove(cards.size()-1);
        return last;
    }
    //this is a to-string method that makes the testing easier. It creates a string variable that acts as a collection, 
    //then uses a for-loop to iterate through every card in the arrayList cards. It adds the toString value of this card 
    //to the variable then adds a line break, to make each card appear on its own line. When every card is added, 
    //this String is returned.
    public String toString(){
       String theReturn = "";
        for(int i = 0; i<cards.size(); i++){
            theReturn += (cards.get(i)).toString(); 
            theReturn += "\n";
        }
        return theReturn;
    }
}
