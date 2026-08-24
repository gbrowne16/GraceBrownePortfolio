package PointsAndRectangles;
import javax.swing.JFrame;
public class Main {
    public static void main(String[] args){
        
        JFrame frame = new JFrame( "Points And Rectangles Project" );
        frame.getContentPane().add( new Canvas() );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.pack();
        frame.setSize( 500, 500 );
        frame.setVisible( true );

    }
}
