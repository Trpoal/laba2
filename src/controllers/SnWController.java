package controllers;

import java.io.IOException;
import java.util.Optional;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SnWController {
	
	@FXML 
	private Button butSet;
	
	@FXML 
	private TextField box5;
	
	@FXML 
	private TextField boxAns;
	
	@FXML 
	private TextField box3;
	
	@FXML 
	private TextField box4;
	
	@FXML 
	private Button back;
	
	@FXML 
	private Label vl1;
	
	@FXML 
	private Label vl2;
	
	@FXML 
	private Label vl3;
	
	@FXML 
	private Label vl4;
	
	public void setS(ActionEvent event) throws IOException
	{
		vl1.setVisible(false);
		vl2.setVisible(false);
		vl3.setVisible(false);
		vl4.setVisible(false);
		Alert alert = new Alert(AlertType.WARNING, "Только цифры", ButtonType.OK);
		Optional<ButtonType> result;
		int pro =0;
		int pro1=0;
		String text = box5.getText();
		try {
		Main.pr5=Integer.parseInt(text);
		}
		catch(NumberFormatException e)
		{
			pro--;
			vl2.setVisible(true);
		}
		
		Alert alertPus = new Alert(AlertType.WARNING, "Только положительные значения", ButtonType.OK);
		Optional<ButtonType> resultPus;
		
		if (Main.pr5<0)
		{
			pro1--;
			vl2.setVisible(true);
		}
		
		text = box4.getText();
		try {
		Main.pr4 = Integer.parseInt(text);
		}
		catch(NumberFormatException e)
		{
			vl3.setVisible(true);
			pro--;
		}
		
		if (Main.pr4<0)
		{
			pro1--;
			vl3.setVisible(true);
		}
		
		text = box3.getText();
		try {
		Main.pr3 = Integer.parseInt(text);
		}
		catch(NumberFormatException e)
		{
			vl4.setVisible(true);
			pro--;
		}
		
		if (Main.pr3<0)
		{
			pro1--;
			vl4.setVisible(true);
		}
		
		text = boxAns.getText();
		try {
		Main.kol = Integer.parseInt(text);
		}
		catch(NumberFormatException e)
		{
			vl1.setVisible(true);
			pro--;
		}
		
		if (Main.kol<0)
		{
			pro1--;
			vl1.setVisible(true);
		}
		
		if((pro>=0)&&(pro1>=0))
		{
		back(event);
		}
		else
		{
			if(pro<0)
			{
			result = alert.showAndWait();
			if(result.get()==ButtonType.OK)
				alert.close();
			}
			else
				if(pro1<0)
				{
					resultPus=alertPus.showAndWait();
					if(resultPus.get()==ButtonType.OK)
						alert.close();
				}
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
	
	
}
