package PointsAndRectangles;

public class Point {
double xCoordinate;
double yCoordinate;

//constructor - creates instances of a Point object with specific x and y value attributes
public Point(double x, double y){
    xCoordinate = x;
    yCoordinate = y;
}

//returns x value attribute of the Point object
public double getX(){
    return xCoordinate;
}

//returns y value attribute of the Point object
public double getY(){
    return yCoordinate;
}

//replaces x value attribute of the Point object with a new value (input)
public void setX(double newX){
    xCoordinate = newX;
}

//replaces y value attribute of the Point object with a new value (input)
public void setY(double newY){
    yCoordinate = newY;
}

//sets a string to be returned for Point objects
public String toString(){
    return "("+xCoordinate+", "+yCoordinate+")";
}
}


