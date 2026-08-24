package PokerSimulation;

import java.awt.Color;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPanel;

/**

 * A JFrame that displays a Hand of Cards

 */

public class Runner extends JFrame

{   

  public Runner( String title )

    {

        super( title );

        initComponents();

    }

    

    /**

     * Initializes the JFrame's components

     */

    private void initComponents()

    {

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().setLayout(new java.awt.GridLayout(0, 1));

        

         

       /*

* ADD CODE HERE TO CREATE AN ARRAY OF HANDS, DEAL 5 CARDS EACH FROM A SHUFFLED DECK


 * THEN, CREATE A boolean[] TO TRACK WHICH OF THE HANDS ARE UNBEATEN (DETERMINE THIS 

* ALGORITHMICALLY. NOTE THESE ARRAYS ARE CALLED ‘hands’ and ‘unbeaten’ in the for 

* loop below 

 */
//First, I created a fixed-size array of 4 hands. Then I created a new deck and shuffled it. Then I created four
//new hands. I then used a for-loop to deal 5 cards from the shuffled deck into each of the hands. Then I assigned
//each of the hands to an index in the array. I then created an array of booleans with true as the value of every
//index. I then used a nested loop to compare every hand to every other hand. If the hand represented by the outside
//loop is ever beaten (the compare() function == -1), then the boolean array at that index becomes false.
Hand[] hands = new Hand[4];
Deck newDeck = new Deck();
newDeck.shuffle();
Hand newHand1 = new Hand();
Hand newHand2 = new Hand();
Hand newHand3 = new Hand();
Hand newHand4 = new Hand();
for(int i =0; i<5; i++){
newHand1.addCard(newDeck.deal());
newHand2.addCard(newDeck.deal());
newHand3.addCard(newDeck.deal());
newHand4.addCard(newDeck.deal());
}
hands[0] = newHand1;
hands[1] = newHand2;
hands[2] = newHand3;
hands[3] = newHand4;

boolean[] unbeaten = {true, true, true, true};
System.out.println(unbeaten);
for(int i =0; i<4; i++){
  for(int j=0; j<4; j++){
    if((hands[i].compare(hands[j]))==-1){
      unbeaten[i]=false;
    }
  }
}
   

       

       // Creates a HandPanel for each hand

        for(int i = 0; i < 4; i++) {

         JPanel p = new JPanel();

         p.setLayout(new java.awt.FlowLayout(FlowLayout.LEADING));

         if(unbeaten[i]) {

          p.setBackground(Color.YELLOW);

         }

         p.add(new HandPanel(hands[i]));

         p.add(new JLabel(hands[i].getHandType()));

         add(p);

        }




        pack();

    }

    

       

    /**

     * The main method launches the JFrame

     */

    public static void main( String[] args )

    {

        

     /* Create and display the form */

     java.awt.EventQueue.invokeLater(new Runnable() {

   

   @Override

   public void run() {

    new Runner("Poker").setVisible(true);

    

   }

  });

    }

}