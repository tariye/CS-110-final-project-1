
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

    private double CenterX = 0.0;
    private double CenterY = 0.0;
    final int RADIUS = 10;
    private DoubleProperty Center_x = new SimpleDoubleProperty();
    private DoubleProperty Center_y = new SimpleDoubleProperty();
    private final DrawingBoard line;
    private Circle ball = new Circle(getCenterX(), getCenterY(), RADIUS);

    private KrakoutBoard board;
    Point2D target;
    Point2D directionVectoer;
    

    public KrakoutBall(KrakoutBoard board, DrawingBoard line) {
        this.board = board;
        this.board.getChildren().add(ball);
        this.line = line;
        ball.centerXProperty().bind(Center_x);
        ball.centerYProperty().bind(Center_y);

    }

 

    
    public void setBall() {
        Center_x.unbind();
        Center_y.unbind();
        Center_x.set(KrakoutBoard.X_DIM_SQUARES*KrakoutBoard.SQUARE_SIZE * 0.5);
        Center_y.set(KrakoutBoard.Y_DIM_SQUARES*KrakoutBoard.SQUARE_SIZE * 0.9 - RADIUS);
    }

    /**
     * @return the CenterX
     */
    public double getCenterX() {
        return CenterX;
    }

    /**
     * @return the CenterY
     */
    public double getCenterY() {
        return CenterY;
    }
    
    void setBall(Color StrokeColor, Color FillColor){
        ball.setStroke(StrokeColor);
        ball.setFill(FillColor);
    }

    public Point2D currentTarget(){
        return target;
    }
    
    public Point2D getTarget(){
        if (KrakoutGame.BallIsMove == false){
            return new Point2D(KrakoutBoard.X_DIM_SQUARES*KrakoutBoard.SQUARE_SIZE * 0.5,0);
        }
        
        else if (ball.getCenterY() - RADIUS == 0 || (line.getStartX() < ball.getCenterX() && ball.getCenterX() < line.getEndX())){
            directionVectoer = new Point2D(-directionVectoer().getX(),directionVectoer().getY());
            return directionVectoer;
        }
        
        else if (ball.getCenterX() - RADIUS == 0 || ball.getCenterX() + RADIUS == KrakoutBoard.X_DIM_SQUARES*KrakoutBoard.SQUARE_SIZE){
            directionVectoer = new Point2D(directionVectoer().getX(),-directionVectoer().getY());
            return directionVectoer;
        }
        
        else {
            return null;
        }
    }
    
    public Point2D directionVectoer(){
        return getTarget().subtract(getBallLocation()).normalize();
    }

    public Point2D getBallLocation(){
        return new Point2D(ball.getCenterX(),ball.getCenterY());
    }
    void moveBall(double a, double b) {
        Center_x.unbind();
        Center_y.unbind();
        Center_x.set(a);
        Center_y.set(b);
    
    }
    
}
