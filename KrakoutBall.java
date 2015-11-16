
import javafx.geometry.Point2D;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Xuanyi Zhu
 */
public class KrakoutBall {

    private double CenterX;
    private double CenterY;

    // set the ball radius
    final int RADIUS = 10;
    private DoubleProperty Center_x = new SimpleDoubleProperty(KrakoutBoard.X_DIM_SQUARES * KrakoutBoard.SQUARE_SIZE * 0.5);
    private DoubleProperty Center_y = new SimpleDoubleProperty(KrakoutBoard.Y_DIM_SQUARES * KrakoutBoard.SQUARE_SIZE * 0.9 - RADIUS);

    //private draw the ball
    private Circle ball = new Circle(KrakoutBoard.X_DIM_SQUARES * KrakoutBoard.SQUARE_SIZE * 0.5, KrakoutBoard.Y_DIM_SQUARES * KrakoutBoard.SQUARE_SIZE * 0.9 - RADIUS, RADIUS);

    private KrakoutBoard board;
    private DrawingBoard line;

    private double dx = 1, dy = 1;
    Point2D directionVector;

    public KrakoutBall(KrakoutBoard board, DrawingBoard line) {
        this.board = board;
        this.board.getChildren().add(ball);

        this.line = line;

        ball.centerXProperty().bind(Center_x);
        ball.centerYProperty().bind(Center_y);

    }

    /**
     * @return the CenterX
     */
    public double getCenterX() {
        return ball.getCenterX();
    }

    /**
     * @return the CenterY
     */
    public double getCenterY() {
        return ball.getCenterY();
    }

    /**
     * set the ball's color
     *
     * @param StrokeColor
     * @param FillColor
     */
    void setBall(Color StrokeColor, Color FillColor) {
        ball.setStroke(StrokeColor);
        ball.setFill(FillColor);
    }

//    public Point2D currentTarget(){
//        return target;
//    }
//    //the ball is on the board. so it will go straight up
//    public Point2D directionVector(){
//        System.out.println("the ball starts moving");
//        directionVector = new Point2D(0,-1).normalize();
//        return directionVector;
//    }
    public Point2D updateVector() {

        // if the ball touching the upper boundary, the direction vector will change
        if (ball.getCenterY() <= RADIUS - 3) {
            System.out.println("the ball is on top");
            System.out.println("befor direction vec X=" + directionVector.normalize().getX()+"    Y="+ directionVector.normalize().getY());
            directionVector = new Point2D(directionVector.getX(), 1+directionVector.getY());
            System.out.println("after direction vec X=" + directionVector.normalize().getX()+"    Y="+ directionVector.normalize().getY());
        }

        // if the ball touching the left or right boundary, the direction vector will change
        else if (ball.getCenterX() <= RADIUS - 3) {
            System.out.println("the ball is on left or right");
            directionVector = new Point2D(1+directionVector.getX(), directionVector.getY());

        }
        
        else if (ball.getCenterX() + RADIUS +3 > KrakoutBoard.X_DIM_SQUARES * KrakoutBoard.SQUARE_SIZE){
            System.out.println("the ball is on left or right");
            directionVector = new Point2D(directionVector.getX()-1, directionVector.getY());
        }

        else if ((line.getStartX() < ball.getCenterX() && ball.getCenterX() < line.getEndX()) && ball.getCenterY() + RADIUS == line.getLineY() || (line.getStartX() < ball.getCenterX() && ball.getCenterX() < line.getEndX()) && ball.getCenterY() + RADIUS > line.getLineY()) {
            System.out.println("the ball is on board!!!");
            directionVector = new Point2D(getCenterX() - line.getLineMidX(), getCenterY() - KrakoutBoard.Y_DIM_SQUARES * KrakoutBoard.SQUARE_SIZE);

        }
        
         

        return directionVector.normalize();

    }

    public Point2D getBallLocation() {
        return new Point2D(ball.getCenterX(), ball.getCenterY());
    }

    void moveBall(double a, double b) {
        Center_x.unbind();
        Center_y.unbind();
        Center_x.set(a);
        Center_y.set(b);

    }

}
