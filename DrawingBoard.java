import java.awt.Point;
import java.awt.geom.Arc2D;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
    private double LineEndX = (KrakoutBoard.X_DIM_SQUARES*KrakoutBoard.SQUARE_SIZE + KrakoutBoard.BoardLength) *0.5;
    private int PointX = (int) (KrakoutBoard.X_DIM_SQUARES*KrakoutBoard.SQUARE_SIZE * 0.5);
    private int PointY = KrakoutBoard.Y_DIM_SQUARES*KrakoutBoard.SQUARE_SIZE;


    private Line line = new Line(LineStartX,LineY,LineEndX,LineY);
    private Point point = new Point(PointX,PointY);

    private KrakoutBoard board;
    
    public DrawingBoard(KrakoutBoard board) {
        this.board = board;
        this.board.getChildren().add(line);
        line.startXProperty();
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

    /**
     * @param LineStartX the LineStartX to set
     */
    public void setLineStartX(double LineStartX) {
        LineStartX = this.LineStartX;
    }

    /**
     * @param LineEndX the LineEndX to set
     */
    public void setLineEndX(double LineEndX) {
        LineEndX = this.LineEndX;
    }

    /**
     * @param PointX the PointX to set
     */
    public void setPointX(int PointX) {
        this.PointX = PointX;
    }

    /**
     * @param PointY the PointY to set
     */
    public void setPointY(int PointY) {
        this.PointY = PointY;
    }

}
