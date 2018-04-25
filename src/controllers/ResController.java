package controllers;

import java.io.IOException;

import application.Main;
import application.NameRes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ResController {
	
	private ObservableList<NameRes> usersData = FXCollections.observableArrayList();

	    @FXML
	    private TableView<NameRes> tableName;

	    @FXML
	    private TableColumn<NameRes, String> name;

	    @FXML
	    private TableColumn<NameRes, Integer> res;
	    
	    @FXML 
	    private Button but1;
	    
	    @FXML
	    private Button butClear;

	    @FXML
	    private void initialize() {
	    	initData();
	        name.setCellValueFactory(new PropertyValueFactory<NameRes, String>("name"));
	        res.setCellValueFactory(new PropertyValueFactory<NameRes, Integer>("res"));
	        tableName.setItems(usersData);
	    }
	    
	   private void initData() {
	        for(NameRes e: Main.listName)
	        {
	        	usersData.add(new NameRes(e.name, e.res));
	        }
	        
	    }
	  
	   public void back(ActionEvent event) throws IOException
		{
			Stage primaryStage = Main.getStage();
			primaryStage.close();
			Parent root = FXMLLoader.load(getClass().getResource("/view/Menu.fxml"));
	        primaryStage.setTitle("Учимся умножать");
	        primaryStage.setScene(new Scene(root));
	        primaryStage.show();
		}
	   
	   public void clear(ActionEvent event) throws IOException
	   {
		   usersData.removeAll();
		   Main.listName.removeAll(Main.listName);
		   back(event);
	   }
}
