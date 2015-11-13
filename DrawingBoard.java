import java.awt.Point;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.paint.Color;
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
    double LineStartX = KrakoutBoard.X_DIM_SQUARES*KrakoutBoard.SQUARE_SIZE * (1 - KrakoutBoard.BoardLength) *0.5;
    private double LineY = KrakoutBoard.Y_DIM_SQUARES*KrakoutBoard.SQUARE_SIZE * 0.9;
    private double LineEndX = (KrakoutBoard.X_DIM_SQUARES*KrakoutBoard.SQUARE_SIZE + KrakoutBoard.BoardLength) *0.5;
    private int PointX = (int) (KrakoutBoard.X_DIM_SQUARES*KrakoutBoard.SQUARE_SIZE * 0.5);
    private int PointY = KrakoutBoard.Y_DIM_SQUARES*KrakoutBoard.SQUARE_SIZE;
    
    private DoubleProperty Start_x = new SimpleDoubleProperty();
    private DoubleProperty End_x = new SimpleDoubleProperty();


    private Line line = new Line(0,LineY,0,LineY);
    private Point point = new Point((int) ((LineStartX+LineEndX)*0.5),PointY);

    private KrakoutBoard board;
    
    public DrawingBoard(KrakoutBoard board) {
        this.board = board;
        this.board.getChildren().add(line);
        
        line.startXProperty().bind(Start_x);
        line.endXProperty().bind(End_x);
        
        
        
    }

    public void moreBoard(double a,double b){
        Start_x.unbind();
        End_x.unbind();
        Start_x.set(a);
        End_x.set(b);
    }
    
    
    public double getStartX() {
        return line.getStartX();
    }
    
    public double getEndX() {
        return line.getEndX();
    }
    
    
    void setLine(Color color, double width) {
        line.setStroke(color);
        line.setStrokeWidth(width);
    }    

}
