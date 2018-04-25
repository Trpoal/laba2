package controllers;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MenuController {

	@FXML 
	private Button but1;
	
	@FXML 
	private Button but2;
	
	@FXML 
	private Button but3;
	
	@FXML 
	private Button butRes;
	
	@FXML 
	private Label L1;
	
	 @FXML
	 private void initialize() {
		 if(!Main.listName.isEmpty())
		 {
			 butRes.setDisable(false);
		 }
	 }
	
	public void choose(ActionEvent event) throws IOException
	{
		String nameOfFile = new String();
		if(event.getSource()==but1)
		{
		nameOfFile="/view/FrW.fxml";
		
		}
		else
			if(event.getSource()==but2)
			{
				nameOfFile="/view/SnW.fxml";
			}
			else
				if(event.getSource()==butRes)
				{
					nameOfFile="/view/Res.fxml";
				}
				else
				{
					System.exit(0);
					}
		openWin(nameOfFile);
	}
	
	public void openWin(String name) throws IOException
	{
		Stage primaryStage = Main.getStage();
		
		Parent root = FXMLLoader.load(getClass().getResource(name));

        primaryStage.setTitle("Учимся умножать");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
	}

	
	
	
	
}
