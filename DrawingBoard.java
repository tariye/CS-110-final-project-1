
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Xuanyi Zhu
 */
public class DrawingBoard{
    private double LineStartX = KrakoutBoard.X_DIM_SQUARES*KrakoutBoard.SQUARE_SIZE * (1 - KrakoutBoard.BoardLength) *0.5;
    private double LineY = KrakoutBoard.Y_DIM_SQUARES*KrakoutBoard.SQUARE_SIZE * 0.9;
    private double LineEndX = KrakoutBoard.X_DIM_SQUARES*KrakoutBoard.SQUARE_SIZE * (1 + KrakoutBoard.BoardLength) *0.5;
//    private int PointX = (int) (KrakoutBoard.X_DIM_SQUARES*KrakoutBoard.SQUARE_SIZE * 0.5);
//    private int PointY = KrakoutBoard.Y_DIM_SQUARES*KrakoutBoard.SQUARE_SIZE;
    
    private DoubleProperty Start_x = new SimpleDoubleProperty(LineStartX);
    private DoubleProperty End_x = new SimpleDoubleProperty(LineEndX);
    private DoubleProperty YValue = new SimpleDoubleProperty(LineY);
    private DoubleProperty helperX = new SimpleDoubleProperty();
    private DoubleProperty helperY = new SimpleDoubleProperty(KrakoutBoard.Y_DIM_SQUARES*KrakoutBoard.SQUARE_SIZE);

    private Line line = new Line(0,0,0,0);
    Circle helper = new Circle(0,0,10);

    private KrakoutBoard board;
    
    public DrawingBoard(KrakoutBoard board) {
        this.board = board;
        this.board.getChildren().add(line);
        this.board.getChildren().add(helper);
        
        line.startXProperty().bind(Start_x);
        line.startYProperty().bind(YValue);
        line.endXProperty().bind(End_x);
        line.endYProperty().bind(YValue);
        
        helper.centerXProperty().bind((Start_x.add(End_x)).multiply(0.5));
        helper.centerYProperty().bind(helperY);
    }

    public void moreBoard(double a,double b){
        getStart_x().unbind();
        getEnd_x().unbind();
        getStart_x().set(a);
        getEnd_x().set(b);
    }
    
    
    public double getStartX() {
        return line.getStartX();
    }
    
    public double getEndX() {
        return line.getEndX();
    }
    
    // since line start y is equal to end y, so i let line y = start y
    public double getLineY() {
        return line.getStartY();
    }
    
    
    void setLine(Color color, double width) {
        line.setStroke(color);
        line.setStrokeWidth(width);
    }    

    /**
     * @return the Start_x
     */
    public DoubleProperty getStart_x() {
        return Start_x;
    }

    /**
     * @return the End_x
     */
    public DoubleProperty getEnd_x() {
        return End_x;
    }
    
    /**
     * @return the End_x
     */
    public DoubleProperty getYValue() {
        return YValue;
    }

    public double getCenterX(){
        return helper.getCenterX();
    }

    public double getCenterY(){
        return helper.getCenterY();
    }
    
    public double getLineMidX(){
        return (line.getStartX()+line.getEndX())*0.5;
    }
    
}
