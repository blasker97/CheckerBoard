/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Brian L
 */
public class Board {
    
        
    private int numRows;
    private int numCols;
    private double boardHeight;
    private double boardWidth;
    private double rectWidth;
    private double rectHeight;
    private Color lightColor = Color.RED;
    private Color darkColor = Color.BLACK;
    private AnchorPane anchor = null;
    
    
    public Board(int numRows, int numCols, double boardWidth, double boardHeight){
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;
        anchor = new AnchorPane();    
    }
    
    public Board(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor){
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;
        this.lightColor = lightColor;
        this.darkColor = darkColor;   
        anchor = new AnchorPane();
    }
    
    public AnchorPane build(){    
        
        clear();
             
        rectWidth = Math.ceil(boardWidth / numCols);
        rectHeight = Math.ceil(boardHeight / numRows);
        
        anchor.setPrefWidth(boardWidth);
        anchor.setPrefHeight(boardHeight);
        
        
        
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                Rectangle space = new Rectangle(rectWidth, rectHeight);
                space.setX(i * rectWidth);
                space.setY(j * rectHeight);
                
                if((i + j) % 2 == 0){
                    space.setFill(lightColor);
                }
                else{
                    space.setFill(darkColor);
                }

                anchor.getChildren().add(space);
            }
        }
        
        return anchor;
        
    }
    
    public AnchorPane getBoard(){
        return anchor;
    }
    
    public int getNumRows(){
       return numRows; 
    }
    
    public int getNumCols(){
        return numCols;
    }
    
    public double getWidth(){
        return boardWidth;
    }
    
    public double getHeight(){
        return boardHeight;
    }
    
    public Color getLightColor(){
        return lightColor;
    }
    
    public Color getDarkColor(){
        return darkColor;
    }
    
    public double getRectangleWidth(){
        return rectWidth;
    }
    
    public double getRectangleHeight(){
        return rectHeight;
    }
    
    private void clear(){
        if(getBoard() != null)
        anchor.getChildren().clear();
    
    }
    
        
    
}
