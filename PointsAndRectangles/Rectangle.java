package PointsAndRectangles;

import java.awt.Graphics;

public class Rectangle{
    double width;
    double height;
    Point topLeft;


    //constructor - creates instances of a Rectangle object with specific top left point, width, and height attributes
    public Rectangle(Point topLeftPoint, double someWidth, double someHeight){
        width = someWidth;
        height = someHeight;
        topLeft = topLeftPoint;
    } 

    //returns top left point attribute of the Rectangle object
    public Point getTopLeft(){
        return topLeft;
    }

    //returns width attribute of the Rectangle object
    public double getWidth(){
        return width;
    }

    //returns height attribute of the Rectangle object
    public double getHeight(){
        return height;
    }

    //replaces top left point attribute of a Rectangle object with a new Point value(input)
    public void setPoint(Point newPoint){
        topLeft = newPoint;
    }

    //replaces width attribute of a Rectangle object with a new width value(input)
    public void setWidth(double newWidth){
        width = newWidth;
    }

    //replaces height attribute of a Rectangle object with a new height value(input)
    public void setHeight(double newHeight){
        height = newHeight;
    }

    //shrinks the height and width attributes of a Rectangle by a parameter percent 
    public void shrink(double percent){
        double decimal = 1 - percent/100;
        height *= decimal;
        width *= decimal;
    }

    //Determines the Rectangle’s upper right corner by using the width and height in comparison to the top left point and returns the upper right point
    public Point getTopRight(){
        Point topRight = new Point((topLeft.getX())+width, (topLeft.getY()));
        return topRight;
    }
    //Determines the Rectangle’s bottom right corner by using the width and height in comparison to the top left point and returns the bottom right point
    public Point getBottomRight(){
        Point bottomRight = new Point ((topLeft.getX())+width, (topLeft.getY())+height);
        return bottomRight;
    }
    //Determines the Rectangle’s bottom left corner by using the width and height in comparison to the top left point and returns the bottom left point
    public Point getBottomLeft(){
        Point bottomLeft = new Point ((topLeft.getX()), (topLeft.getY())+height);
        return bottomLeft;
    }

    //sets a string to be returned for Rectangle objects
    public String toString(){
        return "[Rectangle: top left point: "+topLeft+", width: "+width+", hieght: "+height+"]";
    }

    //draws lines from each corner of a Rectangle using the get____ methods 
    public void draw(Graphics g){
        g.drawLine((int)((topLeft.getX())+0.5), (int)((topLeft.getY())+0.5), (int)((getTopRight().getX())+0.5), (int)((getTopRight().getY())+0.5));
        g.drawLine((int)((getTopRight().getX())+0.5), (int)((getTopRight().getY())+0.5), (int)((getBottomRight().getX())+0.5), (int)((getBottomRight().getY())+0.5));
        g.drawLine((int)((getBottomRight().getX())+0.5), (int)((getBottomRight().getY())+0.5), (int)((getBottomLeft().getX())+0.5), (int)((getBottomLeft().getY())+0.5));
        g.drawLine((int)((getBottomLeft().getX())+0.5), (int)((getBottomLeft().getY())+0.5), (int)((topLeft.getX())+0.5), (int)((topLeft.getY())+0.5));
    }

    double angle = 45.0;
    public Point getNewTopRight(){
        double xChange = width * Math.cos(angle);
        double yChange = height * Math.sin(angle);
        return new Point( topLeft.getX() + xChange, topLeft.getY() - yChange );
        }
}

