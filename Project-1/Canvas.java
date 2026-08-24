package PointsAndRectangles;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/*
The JPanel class is used to create containers:
https://docs.oracle.com/javase/7/docs/api/javax/swing/JPanel.html
https://docs.oracle.com/javase/tutorial/uiswing/components/panel.html
*/

public class Canvas extends JPanel { 
  /*
    Overrides JPanel's paintComponent method to draw our Rectangle
  */

  public void paintComponent( Graphics g ){
    super.paintComponent( g ); 
   //This design scheme uses a for loop to iterate through 175 rectangles. For each iteration, the program creates a 
   //position Point position attribute  used as the instance variable for the Rectangle, assigns it a random color, 
   //and then calls the draw() method with the Graphics object as a parameter. By slightly increasing the y-coordinate, 
   //height, and width, along with increasing the x-value by a greater amount, each time, the rectangles form a triangular 
   //pattern across the screen.
    double recWidth = 4;
    double recHeight = 4;
    double recX=0;
    double recY=0;
    int rand1=(int)(Math.random()*(80) + 0);
    int rand2=(int)(Math.random()*(80) + 0);
    int rand3=(int)(Math.random()*(80) + 0);
    int red = rand1;
    int green = rand2;
    int blue = rand3;
    int stroke = 4;
    for(int i = 0; i<175; i ++){
        Point p = new Point( recX, recY );
        Rectangle r = new Rectangle( p, recWidth, recHeight);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(stroke));
        g.setColor(new Color(red, green, blue));
        r.draw(g);
        recHeight++;
        recWidth++;
        recX+=4;
        recY++;
        red++;
        blue++;   
        green++;  
  }

   //This design scheme uses a for loop to iterate through 175 rectangles. For each iteration, the program creates a 
   //position Point position attribute  used as the instance variable for the Rectangle, assigns it a random color, 
   //and then calls the draw() method with the Graphics object as a parameter. By slightly increasing the y-coordinate, 
   //height, and width, along with increasing the x-value by a greater amount, each time, the rectangles form a triangular 
   //pattern across the screen.
    double rec2Width = 4;
    double rec2Height = 4;
    double rec2X=700;
    double rec2Y=175;
    int rand4=(int)(Math.random()*(80) + 0);
    int rand5=(int)(Math.random()*(80) + 0);
    int rand6=(int)(Math.random()*(80) + 0);
    int red2 = rand4;
    int green2 = rand5;
    int blue2 = rand6;
    int stroke2 = 4;
    for(int i = 0; i<175; i ++){
        Point p = new Point( rec2X, rec2Y );
        Rectangle r = new Rectangle( p, rec2Width, rec2Height);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(stroke2));
        g.setColor(new Color(red2, green2, blue2));
        r.draw(g);
        rec2Height--;
        rec2Width--;
        rec2X-=4;
        rec2Y--;
        red2++; 
        blue2++;  
        green2++;  
  }

  //This design scheme uses a for loop to iterate through 175 rectangles. For each iteration, the program creates a 
   //position Point position attribute  used as the instance variable for the Rectangle, assigns it a random color, 
   //and then calls the draw() method with the Graphics object as a parameter. By slightly increasing the y-coordinate, 
   //height, and width, along with increasing the x-value by a greater amount, each time, the rectangles form a triangular 
   //pattern across the screen.
    double rec3Width = 4;
    double rec3Height = 4;
    double rec3X=0;
    double rec3Y=175;
    int rand7=(int)(Math.random()*(80) + 0);
    int rand8=(int)(Math.random()*(80) + 0);
    int rand9=(int)(Math.random()*(80) + 0);
    int red3 = rand7;
    int green3 = rand8;
    int blue3 = rand9;
    int stroke3 = 4;
    for(int i = 0; i<175; i ++){
        Point p = new Point( rec3X, rec3Y );
        Rectangle r = new Rectangle( p, rec3Width, rec3Height);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(stroke3));
        g.setColor(new Color(red3, green3, blue3));
        r.draw(g);
        rec3Height++;
        rec3Width++;
        rec3X+=4;
        rec3Y++;
        green3++;
        red3++; 
        blue3++;    
  }
   //This design scheme uses a for loop to iterate through 175 rectangles. For each iteration, the program creates a 
   //position Point position attribute  used as the instance variable for the Rectangle, assigns it a random color, 
   //and then calls the draw() method with the Graphics object as a parameter. By slightly increasing the y-coordinate, 
   //height, and width, along with increasing the x-value by a greater amount, each time, the rectangles form a triangular 
   //pattern across the screen.
  double rec4Width = 4;
  double rec4Height = 4;
  double rec4X=700;
  double rec4Y=350;
  int rand10=(int)(Math.random()*(80) + 0);
  int rand11=(int)(Math.random()*(80) + 0);
  int rand12=(int)(Math.random()*(80) + 0);
  int red4 = rand10;
  int green4 = rand11;
  int blue4 = rand12;
  int stroke4 = 4;
  for(int i = 0; i<175; i ++){
      Point p = new Point( rec4X, rec4Y );
      Rectangle r = new Rectangle( p, rec4Width, rec4Height);
      Graphics2D g2 = (Graphics2D) g;
      g2.setStroke(new BasicStroke(stroke4));
      g.setColor(new Color(red4, green4, blue4));
      r.draw(g);
      rec4Height--;
      rec4Width--;
      rec4X-=4;
      rec4Y--;
      red4++; 
      blue4++; 
      green4++;   
}
//This design scheme uses a for loop to iterate through 175 rectangles. For each iteration, the program creates a 
   //position Point position attribute  used as the instance variable for the Rectangle, assigns it a random color, 
   //and then calls the draw() method with the Graphics object as a parameter. By slightly increasing the y-coordinate, 
   //height, and width, along with increasing the x-value by a greater amount, each time, the rectangles form a triangular 
   //pattern across the screen.
double rec5Width = 4;
    double rec5Height = 4;
    double rec5X=0;
    double rec5Y=350;
    int rand13=(int)(Math.random()*(80) + 0);
    int rand14=(int)(Math.random()*(80) + 0);
    int rand15=(int)(Math.random()*(80) + 0);
    int red5 = rand13;
    int green5 = rand14;
    int blue5 = rand15;
    int stroke5 = 20;
    for(int i = 0; i<175; i ++){
        Point p = new Point( rec5X, rec5Y );
        Rectangle r = new Rectangle( p, rec5Width, rec5Height);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(stroke5));
        g.setColor(new Color(red5, green5, blue5));
        r.draw(g);
        rec5Height++;
        rec5Width++;
        rec5X+=4;
        rec5Y++;
        green5++;
        red5++;   
        blue++;  
  }
//This design scheme uses a for loop to iterate through 175 rectangles. For each iteration, the program creates a 
   //position Point position attribute  used as the instance variable for the Rectangle, assigns it a random color, 
   //and then calls the draw() method with the Graphics object as a parameter. By slightly increasing the y-coordinate, 
   //height, and width, along with increasing the x-value by a greater amount, each time, the rectangles form a triangular 
   //pattern across the screen.
  double rec6Width = 4;
  double rec6Height = 4;
  double rec6X=700;
  double rec6Y=525;
  int rand16=(int)(Math.random()*(80) + 0);
  int rand17=(int)(Math.random()*(80) + 0);
  int rand18=(int)(Math.random()*(80) + 0);
  int red6 = rand16;
  int green6 = rand17;
  int blue6 = rand18;
  int stroke6 = 4;
  for(int i = 0; i<175; i ++){
      Point p = new Point( rec6X, rec6Y );
      Rectangle r = new Rectangle( p, rec6Width, rec6Height);
      Graphics2D g2 = (Graphics2D) g;
      g2.setStroke(new BasicStroke(stroke6));
      g.setColor(new Color(red6, green6, blue6));
      r.draw(g);
      rec6Height--;
      rec6Width--;
      rec6X-=4;
      rec6Y--;
      red6++;
      blue6++; 
      green6++;   
}
//This design scheme uses a for loop to iterate through 50 rectangles. For each iteration, the program creates a 
   //position Point position attribute used as the instance variable for the Rectangle, makes it white, 
   //and then calls the draw() method with the Graphics object as a parameter. By increasing the height, and width 
   //each time, the rectangles form a window-like pattern across the screen.
double rec7Width = 50;
  double rec7Height = 50;
  double rec7X=0;
  double rec7Y=470;
  int red7 = 225;
  int green7 = 255;
  int blue7 = 255;
  int stroke7 = 4;
  for(int i = 0; i<50; i ++){
      Point p = new Point( rec7X, rec7Y );
      Rectangle r = new Rectangle( p, rec7Width, rec7Height);
      Graphics2D g2 = (Graphics2D) g;
      g2.setStroke(new BasicStroke(stroke7));
      g.setColor(new Color(red7, green7, blue7));
      r.draw(g);
      rec7Height+=50;
      rec7Width+=50;
    
}

// //This design scheme uses a for loop to iterate through 125 rectangles. For each iteration, the program creates a 
//    //position Point position attribute  used as the instance variable for the Rectangle, assigns it a color that gradiates 
//    //with each rectangle due to slight changes in the red a blue attributes, and then calls the draw() method with the Graphics 
//    //object as a parameter. By increasing the x-coordinate, and applying a exponential function to the y-coordinate, each time, 
//    //the rectangles form a parabolic pattern across the screen.
// int blue2 = 2;
// int red2=1;
// double x2 = -4;
// double y2 = 0;

// for(int i = 0; i<125; i++){
//   double rand1=(int)(Math.random()*(50)+1);
//   double rand2=(int)(Math.random()*(50)+1);
//   x2+=4;
//   y2=(Math.pow((x2), 2)*0.002)+18; 
//   Point p = new Point( (500-x2)-rand1, y2);
//         Rectangle r = new Rectangle( p, rand1, rand2);
//         Graphics2D g2 = (Graphics2D) g;
//         g2.setStroke(new BasicStroke(4));
//         g.setColor(new Color(red2, 0, blue2));
//         r.draw(g);
//         blue2+=2;
//         red2+=1;
// }
// //This design scheme uses a for loop to iterate through 125 rectangles. For each iteration, the program creates a 
//    //position Point position attribute  used as the instance variable for the Rectangle, assigns it a color that gradiates 
//    //with each rectangle due to slight changes in the red a blue attributes, and then calls the draw() method with the Graphics 
//    //object as a parameter. By increasing the x-coordinate, and applying a exponential function to the y-coordinate, each time, 
//    //the rectangles form a parabolic pattern across the screen.
// int blue1 = 1;
// int red1=2;
// double x1 = 0;
// double y1 = 0;

// for(int i = 0; i<125; i++){
//   double rand1=(int)(Math.random()*(50)+1);
//   double rand2=(int)(Math.random()*(50)+1);
//     Point p = new Point( x1, y1 );
//         Rectangle r = new Rectangle( p, rand1, rand2);
//         Graphics2D g2 = (Graphics2D) g;
//         g2.setStroke(new BasicStroke(4));
//         g.setColor(new Color(red1, 0, blue1));
//         r.draw(g);
//         x1+=4;
//         y1=Math.pow((x1), 2)*0.002;
//         blue1+=1;
//         red1+=2;
// }


// //This design scheme uses a for loop to iterate through 270 rectangles. For each iteration, the program creates a 
//    //position Point position attribute  used as the instance variable for the Rectangle, assigns it a color and then calls 
//    //the draw() method with the Graphics object as a parameter. By slihgtly increasing the x-coordinate, decreasing the 
//    //y-coordinate, and reducing the width  each time, the rectangles form a triangle pattern from the bottom of the screen.
// double x3= 125;
// double y3 = 500;
// double height = 1;
// double width = 270; 

// for(int i = 0; i<270; i++){

//   Point p = new Point( x3, y3);
//         Rectangle r = new Rectangle( p, width, height);
//         Graphics2D g2 = (Graphics2D) g;
//         g2.setStroke(new BasicStroke(4));
//         g.setColor(new Color(100, 0, 100));
//         r.draw(g);
//         y3-=1.35; 
//         x3+=0.5;
//         width-=1;
        
// }
  }
}
