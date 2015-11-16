/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import javafx.scene.paint.Color;


/**
 * This should be implemented to include your game control.
 * @author pipWolfe
 */
public class KrakoutGame {
    private final Krakout krakoutApp;
    private final DrawingBoard line;
    static boolean BallIsMove;
    private KrakoutBall ball;
    /**
     * Initialize the game. Remove the example code and replace with code
     * that creates a random piece.
     * @param krakoutApp
     * @param board A reference to the board on which Squares are drawn
     */
    public KrakoutGame(Krakout krakoutApp, KrakoutBoard board) {
        // Some sample code that places two squares on the board.
        // Take this out and construct your random piece here.
//        KrakoutSquare square1 = new KrakoutSquare(board);
//        square1.moveToKrakoutLocation(1, 1);
//        square1.setColor(Color.BLUEVIOLET);
//        
//        KrakoutSquare square2 = new KrakoutSquare(board);
//        square2.moveToKrakoutLocation(5, 3);
//        square2.setColor(Color.RED);
        
        DrawingBoard line = new DrawingBoard(board);
        line.setLine(Color.BLACK,5.0);
        this.line = line;
        

//        helper.setBall(Color.BLACK, Color.WHITE);
        
        KrakoutBall ball = new KrakoutBall(board, line);
        ball.setBall(Color.BLACK, Color.WHITE);
        this.ball = ball;
        
        this.krakoutApp = krakoutApp;
        // You can use this to show the score, etc.
        krakoutApp.setMessage("Game has started!");
    }

    /**
     * Animate the game, by moving the current tetris piece down.
     */
    void update() {
  
        
        System.out.println("before  ball  X=" + ball.getCenterX()+"    Y="+ ball.getCenterY());
       ball.moveBall(ball.updateVector().getX()+ball.getCenterX(),ball.updateVector().getY()+ball.getCenterY());
        System.out.println("after  ball  X=" + ball.getCenterX()+"    Y="+ ball.getCenterY());
    }
    
    /**
     * Move the current tetris piece left.
     */
    void left() {
        
        System.out.println("left key was pressed!");
        if (line.getStartX()>7){
            line.moreBoard(line.getStartX()-7,line.getEndX()-7);
        }
        
    }

    /**
     * Move the current tetris piece right.
     */
    void right() {
        System.out.println("right key was pressed!");
        if (line.getEndX()<(KrakoutBoard.X_DIM_SQUARES*KrakoutBoard.SQUARE_SIZE-7)){
            line.moreBoard(line.getStartX()+7,line.getEndX()+7);
        }
        
    }
    
    void space(){
        
        
    }
}
