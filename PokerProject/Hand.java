package PokerSimulation;
import java.util.ArrayList;

//this class represents a hand of 5 cards. It creates an empty hand, can add cards to the hand, and has a helper method that
//identifies the value of a card in the hand. Then, it identifies which type of hand the hand is (flush, pair, etc.).
//It then can compare any two hands to eachother. It both can compare different type hands and the same type hands using tiebreaker 
//logic. This uses a helper method compareHighCard that can compare each card from highest to lowest in each hand and
//return the card with the highest card (if both have the same high card it goes to second highest, then 3rd, etc.)
//I tested the robustness of this class by hard-coding input for every possible situation, to ensure the validaty of every method. 
// Whenever I did not get the expected output, I debugged the class and then confirmed no previous testing was impacted 
//by the changes. I got the most errors with the more common scenarios, like basic pairs, rather than with edge cases.
//Because of the length and complexity of this class, I took great care to make sure it had good readability.
public class Hand {
    ArrayList<Card> hand;

   //this is a contructor that initializes a blank, dynamic ArrayList of Cards.
    public Hand(){
        hand= new ArrayList<>();
    }
    //this is a helper method that returns the ArrayList hand.
    public ArrayList<Card> getHand(){
        return hand;
    }

    //this method adds a Card (give as a parameter) into the list. It uses conditionals and for-loops to ensure
//that when a card is added to the hand list, it is added in ascending order. First, it checks if the list is
//empty. If it is, then the card is just added. Then, it iterates through every card currently in the hand list.
//if that value of the given card is less than the value of the first card in the list, the new card is inserted first
// and the method ends. Then, if the value of the given card is greater than the value of the last card in the list, 
//the new card is added to the end of the list and the method ends. Finally, if the value of the new card is less then
//the card after the one at the index of the for-loop, the card is added before it and the method ends.
    public void addCard(Card c){
        int size = hand.size();
        if(size==0){
            hand.add(c);
            return;
        }
        else{
        for(int i =0; i<size; i++){
            if(c.getValue()<=((hand.get(0)).getValue())){
                hand.add(0,c);
                return;
            }
            else if(c.getValue()>((hand.get(size-1)).getValue())){
                hand.add(c);
                return;
            }
            else{
                if((size-1>i)&&(c.getValue()>=((hand.get(i)).getValue()))){
                if(c.getValue()<=((hand.get(i+1)).getValue())){
                    hand.add(i+1,c);
                    return;
                }
            }
            }
        }
        }
    }
    
    //this is a helper method that returns the value of the card in the list hand at the given index (parameter).
    public int getCardValue(int index){
        return hand.get(index).getValue();
    }
    
    //this is a to-string method that makes the testing easier. It creates a string variable that acts as a collection, 
    //then uses a for-loop to iterate through every card in the arrayList hand. It adds the toString value of this 
    //card to the variable then adds a line break, to make each card appear on its own line. When every card is added, 
    //this String is returned.
    public String toString(){
        String theReturn = "";
         for(int i = 0; i<hand.size(); i++){
             theReturn += (hand.get(i)).toString(); 
             theReturn += "\n";
         }
         return theReturn;
     }
     
     //this method determines if a hand is a flush. It creates a boolean that is set to true, then sets a string variable
     //to be the suit of the first card. It then iterates through the hand and if the card at that index does not
     //have the same suit as the string variable, the boolean becomes false. It then returns the boolean at the end.
    public boolean isFlush(){
        boolean yes=true;
        String suit=(hand.get(0).getSuit());
        for(int i =0; i<hand.size(); i++){
            if(!((hand.get(i).getSuit()).equals(suit))){
                yes=false;
            }
        }
        return yes;
    }
    
    //this method determines if a hand is a straight.It creates a boolean that is set to true, then sets a int variable
     //to be the value of the first card. It then iterates through the hand and if the value of the card at that index is not
     //one more than the variable + the index, the boolean becomes false. It then returns the boolean at the end.
    public boolean isStraight(){
        boolean yes=true;
        int value=(hand.get(0).getValue());
        for(int i =0; i<hand.size(); i++){
            if(!((hand.get(i).getValue())==(value+i))){
                yes=false;
            }
        }
        return yes;
    }
    
    ////this method determines if a hand is a royal .It creates a boolean that is set to true, then sets a int variable
     //to be the value of the first card of a royal flush (10). It then iterates through the hand and if the value of 
     //the card at that index is not one more than the variable + the index, the boolean becomes false. It then makes
     //sure the hand is a flush, using the isFlush() method. If it is not, the boolean becomes false. It then returns 
     // the boolean at the end.
    public boolean isRoyal(){
        boolean yes=true;
        int value=10;
        for(int i =0; i<hand.size(); i++){
            if(!((hand.get(i).getValue())==(value+i))){
                yes=false;
            }
            if(!isFlush()){
                yes=false;
            }
        }
        return yes;
    }
    
    //this method determines if a hand is a straight flush.It creates a boolean that is set to true, then sets a int variable
     //to be the value of the first card. It then iterates through the hand and if the value of the card at that index is not
     //one more than the variable, the boolean becomes false. It then returns the boolean at the end. Then it sets a string variable
     //to be the suit of the first card. It then iterates through the hand again and if the card at that index does not
     //have the same suit as the string variable, the boolean becomes false. It then returns the boolean at the end.
    public boolean isStraightFlush(){
        boolean yes=true;
        int value=(hand.get(0).getValue());
        String suit=(hand.get(0).getSuit());
        for(int i =0; i<hand.size(); i++){
            if(!((hand.get(i).getValue())==(value+i))){
                yes=false;
            }
        }
        for(int i =0; i<hand.size(); i++){
            if(!((hand.get(i).getSuit()).equals(suit))){
                yes=false;
            }
        }
        return yes;
    }
   
    //This method determines if a hand is a four-of-a-kind. It presumes that the size of a hand is 5. It chooses the
    //value of the card at index 3 of the hand list to set to a int variable. It choose this because a four of
    //a kind would have to have the middle value be one of the 4. It then iterates through the hand and if the value
    //of the card at that interval is equal to the int variable, 1 is added to a count. At the end of the for-loop,
    //if the count==4, true is returned. If not, false is returned.
    public boolean isFour(){
        if(hand.size()==5){
        int num1=(hand.get(3).getValue());
        int count1=0;
        
        for(int i = 0; i<hand.size(); i++){
            if((hand.get(i)).getValue()==num1){
                count1++;
            }

        }
        if(count1==4){
            return true;
        }
    }
        return false;
    }
    
    //This method determines if a hand is a three-of-a-kind. It presumes that the size of a hand is 5. It chooses the
    //value of the card at index 2 of the hand list to set to a int variable. It choose this because a three of
    //a kind would have to have the middle value be one of the 3. It then iterates through the hand and if the value
    //of the card at that interval is equal to the int variable, 1 is added to a count. At the end of the for-loop,
    //if the count==3, true is returned. If not, false is returned.
    public boolean isThree(){
        if(hand.size()==5){
        int num1=(hand.get(2).getValue());
        int count1=0;
  
        
        for(int i = 0; i<hand.size(); i++){
            if(hand.get(i).getValue()==num1){
                count1++;
            }
        }
        if(count1==3){
            return true;
        }
    }
        return false;
    }
    
    //This method determines if a hand is a pair. It iterates through the hand (without the last index) and if the value
    //of the card at that interval is equal to the card at the next index, true is returned. 
    // If the for-loop finishes, false is returned.
public boolean isPair(){
   for(int i=0; i<(hand.size()-1); i++){
    if(hand.get(i).getValue()==hand.get(i+1).getValue()){
        return true;
    }
   }
   return false;
}

//This method determines if a hand is a two-pair. It iterates through the hand (without the last index) and if the value
    //of the card at that interval is equal to the card at the next index, then it iterates through the remaining
    //cards (without the last index) in the hand. If the value of the card at that interval is equal to the card 
    // at the next index, true is returned. If the for-loop finishes, false is returned.
public boolean isTwoPair(){
    for(int i=0; i<hand.size()-1;i++){
        if(hand.get(i).getValue()==hand.get(i+1).getValue()){
            for(int j=i+2; j<hand.size()-1; j++){
                if(hand.get(j).getValue()==hand.get(j+1).getValue()){
                    return true;
                }
            }
        }
    }
    return false;
}

//This method determines if a hand is a Full House. It presumes that the size of a hand is 5. First, it insures 
//that this hand is a triple. If it is, it sets one boolean (triple) to true. Then, it checks if the value of the 
//card at index 2 is equal to the value at index 4. If it is, this means that 2-4 must be the triple. If so,
//the values of the cards at index 0 and 1 are compared. If they are equal, a second boolean (pair) is true.
//If the value of the card at index 2 is not equal to the value at index 4, it checks if the value of the 
//card at index 2 is equal to the value at index 0. If it is, this means that 0-2 must be the triple. If so,
//the values of the cards at index 3 and 4 are compared. If they are equal, a second boolean (pair) is true.
//If the boolean expression (pair&&triple) is true, true is returned. If not, false is returned.
public boolean isFull(){
    boolean pair=false;
    boolean triple=false;
    
    if(isThree()){
        triple=true;
    if(hand.size()==5){
        if(hand.get(2).getValue()==hand.get(4).getValue()){
            if(hand.get(0).getValue()==hand.get(1).getValue()){
                pair=true;
            }
        }
        else if(hand.get(2).getValue()==hand.get(0).getValue()){
            if(hand.get(3).getValue()==hand.get(4).getValue()){
                pair=true;
            }
        }
    }
}
    if(pair&&triple){
        return true;
    }
    return false;
}

//this method determines a hands rank based on which type of hand it is. Since some hands could be 2 types of hands
//(pair and two-pair), the control structures are key. It starts at the highest rank and goes down with "else if"s. 
// It returnes a number 0-9 depending on this rank.
public int rank(){
    if(isRoyal()){
        return 9;
    }
    else if(isStraightFlush()){
        return 8;
    }
    else if(isFour()){
        return 7;
    }
    else if(isFull()){
        return 6;
    }
    else if(isFlush()){
        return 5;
    }
    else if(isStraight()){
        return 4;
    }
    else if(isThree()){
        return 3;
    }
    else if(isTwoPair()){
        return 2;
    }
    else if(isPair()){
        return 1;
    }
    else{
        return 0;
    }
    
}

//This method uses the ranking method to return a string form of the higest type of a hand that a hand is.
//It uses conditionals to return each corresponding ranks type.
public String getHandType(){
    int rank = rank();
    if(rank==0){
        return "High Card";
    }
    else if(rank==1){
        return "One Pair";
    }
    else if(rank==2){
        return "Two Pair";
    }
    else if(rank==3){
        return "Three-of-a-kind";
    }
    else if(rank==4){
        return "Straight";
    }
    else if(rank==5){
        return "Flush";
    }
    else if(rank==6){
        return "Full House";
    }
    else if(rank==7){
        return "Four-of-a-kind";
    }
    else if(rank==8){
        return "Straight Flush";
    }
    else{
        return "Royal Flush";
    }
}

//this is a helper method that only compares corresponding indexes of two hands to eachother. It starts with the
//highest index (4) then does down to index(0) if all of the higher indexes are equal. When one hands card is higher,
//1 or -1 is returned, depending on whether it is hand (1) or otherHand, the parameter Hand, (-1). If the hands are 
//entirely equal, 0 is returned. I did not need this method, as I could've simply implemented the algorithm into
//the compare() method, but I used method decomposition to make the compare() method more readable and easily coded.
public int compareHighCard(Hand otherHand){    
    if(hand.get(hand.size()-1).getValue()>otherHand.getCardValue(hand.size()-1)){
        return 1;
    }
    else if(hand.get(hand.size()-1).getValue()<otherHand.getCardValue(hand.size()-1)){
        return -1;
    }
    else{
        if(hand.get(hand.size()-2).getValue()>otherHand.getCardValue(hand.size()-2)){
            return 1;
        }
        else if(hand.get(hand.size()-2).getValue()<otherHand.getCardValue(hand.size()-2)){
            return -1;
        }
        else{
            if(hand.get(hand.size()-3).getValue()>otherHand.getCardValue(hand.size()-3)){
                return 1;
            }
            else if(hand.get(hand.size()-3).getValue()<otherHand.getCardValue(hand.size()-3)){
                return -1;
            }
            else{
                if(hand.get(hand.size()-4).getValue()>otherHand.getCardValue(hand.size()-4)){
                    return 1;
                }
                else if(hand.get(hand.size()-4).getValue()<otherHand.getCardValue(hand.size()-4)){
                    return -1;
                }
                else{
                    if(hand.get(hand.size()-5).getValue()>otherHand.getCardValue(hand.size()-5)){
                    return 1;
                    }
                    else if(hand.get(hand.size()-5).getValue()<otherHand.getCardValue(hand.size()-5)){
                    return -1;
                    }
                    else{
                        return 0;
                    }
                }
            }
        }
    }
}

//this method compares every possible situation of hands to determine a winner. First, it uses rank. If hands rank is 
//greater than otherHand's rank (the parameter Hand), 1 is returned. If otherHands rank is greater, -1 is returned.
//If the ranks are the same, the method uses tie-breakers to determine the winner. If rank==9, the hands are a true tie,
//0 is returned. if rank==8 or rank==4 (I combined these for efficiency), the hand with the highest card wins, if they have the same highest card, every card
//will be the same, as they are straights, so it is a true tie and 0 is returned. If rank==5, the method compareHighCard() is 
// used (on the condition the hand size is 5). If rank==7, the value of the card at index 3 is compared (as this will
//have to be one of the 4-of-a-kind). Whichever hand's value is greater at the index will win. Because there are only 4 of
//each value in a deck, the hands will never have the same value of the card at index 3, so this will always work.
//If rank==6 or rank==3 (I combined these for efficiency), the value of the card at index 2 is compared (as this will have to be one of the 3-of-a-kind)
//for both the full house or the 3-of-a-kind. Whichever hand's value is greater at the index will win. Because there are only 4 of
//each value in a deck, the hands will never have the same value for their 3-of-a-kind, so this will always work.
//If rank==2 the value of the card at index 3 is compared (as this will have to be one of the higher valued paired cards).
// Whichever hand's value is greater at the index will win. If these values are the same, the value of the card at index 1 
// is compared (as this will have to be one of the lower valued paired cards). Whichever hand's value is greater at the 
// index will win. If these values are the same, each hand is iterated through to determine the index of the card
//that is not a pair. Then, these values are compared. Whichever hand has the greater one wins, if these are the same,
//it is a true pair and 0 is returned. If rank==1, each hand is iterated through to determine what the paired value is.
//Whichever hand has a greater paired value wins, if these are the same, the compareHighCard() method is used. If the rank==0,
//the compareHighCard() method is used. 
public int compare(Hand otherHand){
    int rank1=rank();
    int rank2=otherHand.rank();
    if(rank1>rank2){
        return 1;
    }
    else if(rank2>rank1){
        return -1;
    }
    else{
        if(rank1==9){
            return 0;
        }
        else if((rank1==8)||rank1==4){
            if((otherHand.getCardValue(hand.size()-1))>hand.get(hand.size()-1).getValue()){
                return -1;
            }
            else if((otherHand.getCardValue(hand.size()-1))<hand.get(hand.size()-1).getValue()){
                return 1;
            }
            else{
                return 0;
            }
            }
        else if(rank1==5){
            if(hand.size()==5){
            return compareHighCard(otherHand);
        }
        return 0;
        }
        else if(rank1==7){
            if((otherHand.getCardValue(3))>hand.get(3).getValue()){
                return -1;              
            }
            else if((otherHand.getCardValue(3))<hand.get(3).getValue()){
                return 1;
            }
            else{
                return 0;
                }
                }
        else if(rank1==6||rank1==3){
            if((hand.get(2).getValue())>(otherHand.getCardValue(2))){
                return 1;
            }
            else if((hand.get(2).getValue())<(otherHand.getCardValue(2))){
                return -1;
            }
            else{
                return 0;
            }
            }
        else if(rank1==2){
            if((hand.get(3).getValue())<(otherHand.getCardValue(3))){
                return -1;
            }
            else if((hand.get(3).getValue())>(otherHand.getCardValue(3))){
                return 1;
            }
            else{
                if((hand.get(1).getValue())<(otherHand.getCardValue(1))){
                    return -1;
                }
                else if((hand.get(1).getValue())<(otherHand.getCardValue(1))){
                    return 1;
                }
                else{
                    int num1=0;
                    int num2=0;
                    for(int i=0; i<hand.size()-1; i++){
                        if(!(hand.get(i).getValue()==hand.get(i+1).getValue())){
                            if(i==0||(!(hand.get(i).getValue()==hand.get(i-1).getValue()))){
                                num1=hand.get(i).getValue();
                            }
                        }
                        if(!(otherHand.getCardValue(i)==otherHand.getCardValue(i+1))){
                            if(i==0||(!(otherHand.getCardValue(i)==otherHand.getCardValue(i-1)))){
                                num2=otherHand.getCardValue(i);
                            }
                        }
                    }
                    if(num1>num2){
                        return 1;
                    }
                    else if(num1<num2){
                        return -1;
                    }
                    else{
                        return 0;
                    }
                }
            }
            }
            else if(rank1==1){
                int pairValue1=0;
                int pairValue2=0;
                for(int i=0;i<hand.size()-1;i++){
                    if(hand.get(i).getValue()==hand.get(i+1).getValue()){
                        pairValue1=hand.get(i).getValue();
                    }
                    if(otherHand.getCardValue(i)==otherHand.getCardValue(i+1)){
                        pairValue2=otherHand.getCardValue(i);
                    }
                }
                if(pairValue1>pairValue2){
                    return 1;
                }
                else if(pairValue2>pairValue1){
                    return -1;
                }
                else{
                    return compareHighCard(otherHand);
                }
            }
            else if(rank1==0){
                return compareHighCard(otherHand);
            }
            else{
                return 0;
            }
        
        }
    }
}

