/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Brian L
 */
public class BoardFXMLController implements Initializable, Startable {
    
    @FXML
    private VBox vbox; 
    
    @FXML
    private AnchorPane grid;
    
    private Stage stage;
    
    private Board gameBoard;
    
    

    @FXML
    private void handleGrid16x16(ActionEvent Event){
        
        clearAnchorPane();
        gameBoard = new Board(16,16,grid.getWidth(),grid.getHeight(),gameBoard.getLightColor(),gameBoard.getDarkColor());
        grid.getChildren().add(gameBoard.build());  
    }
    
    @FXML
    private void handleGrid10x10(ActionEvent Event){
        
        clearAnchorPane();
        gameBoard = new Board(10,10,grid.getWidth(),grid.getHeight(),gameBoard.getLightColor(),gameBoard.getDarkColor());
        grid.getChildren().add(gameBoard.build());
    }
    
    @FXML
    private void handleGrid8x8(ActionEvent Event){
        
        clearAnchorPane();
        gameBoard = new Board(8,8,grid.getWidth(),grid.getHeight(),gameBoard.getLightColor(),gameBoard.getDarkColor());
        grid.getChildren().add(gameBoard.build());    
    }
    
    @FXML
    private void handleGrid3x3(ActionEvent Event){
        
        clearAnchorPane();
        gameBoard = new Board(3,3,grid.getWidth(),grid.getHeight(),gameBoard.getLightColor(),gameBoard.getDarkColor());
        grid.getChildren().add(gameBoard.build());  
    }
    
    @FXML
    private void handleDefaultColor(ActionEvent Event){
        clearAnchorPane();
        gameBoard = new Board(gameBoard.getNumRows(),gameBoard.getNumCols(),grid.getWidth(),grid.getHeight(), Color.RED, Color.BLACK);
        grid.getChildren().add(gameBoard.build());
    }
    
    @FXML
    private void handleBlueColor(ActionEvent Event){
        clearAnchorPane();
        gameBoard = new Board(gameBoard.getNumRows(),gameBoard.getNumCols(),grid.getWidth(),grid.getHeight(), Color.SKYBLUE, Color.DARKBLUE);
        grid.getChildren().add(gameBoard.build());
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        
        gameBoard = new Board(8,8,grid.getWidth(),grid.getHeight());
        
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            refreshAnchorPane();
        };
        
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
        refreshAnchorPane();
    }
    
    private void clearAnchorPane(){
        grid.getChildren().clear();
    }
    
    private void refreshAnchorPane(){ 
        grid.getChildren().clear();
        gameBoard = new Board(gameBoard.getNumRows(),gameBoard.getNumCols(),grid.getWidth(),grid.getHeight(),gameBoard.getLightColor(),gameBoard.getDarkColor());
        grid.getChildren().add(gameBoard.build());
        
        
    }
    
}
