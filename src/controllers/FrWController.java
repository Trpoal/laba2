package controllers;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;
import java.util.Random;

import application.Main;
import application.NameRes;
import application.Record;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class FrWController {
	
	@FXML 
	private Label que;
	
	@FXML 
	private TextField box1;
	
	@FXML 
	private Button answer;
	
	@FXML 
	private Button st;
	
	@FXML 
	private Button back;
	
	@FXML 
	private Button mis;
	
	@FXML 
	private Label number;
	
	@FXML 
	private Label res;
	
	@FXML 
	private Label nameLb;
	
	@FXML 
	private Button nameBut;
	
	@FXML 
	private TextField nameBox;
	
	int num;
	Random rnd = new Random();
	int ob1;
	int ob2;
	String name;
	
	public void getName(ActionEvent event)
	{
		name = nameBox.getText();
		nameBox.setVisible(false);
		nameBut.setVisible(false);
		nameLb.setVisible(false);
		st.setVisible(true);
	}
	
	public void start(ActionEvent event)
	{
		    st.setVisible(false);
		    que.setVisible(true);
			box1.setVisible(true);
			answer.setVisible(true);
			number.setVisible(true);
		    num = 1;
			ob1 = 1 + rnd.nextInt(10);
			ob2 = 1 + rnd.nextInt(10);
			que.setText(ob1 +"*"+ob2);
			Main.list.removeAll(Main.list);
	}
		
	public void enterText(ActionEvent event)
	{
		Alert alert = new Alert(AlertType.WARNING, "Только цифры", ButtonType.OK);
		Optional<ButtonType> result;
		String text = box1.getText();
		int resPo;
		try {
			resPo = Integer.parseInt(text);
		}
		catch(NumberFormatException e)
		{
			result = alert.showAndWait();
			if(result.get()==ButtonType.OK)
				alert.close();
			box1.setText("");
			return;
		}
		
		int resCo = ob1*ob2;
		boolean ans;
		if(resPo == resCo)
			ans = true;
		else
			ans=false;
		Main.list.add(new Record(ob1,ob2,resCo,resPo,ans));
		
		ob1 = 1 + rnd.nextInt(10);
		ob2 = 1 + rnd.nextInt(10);
		que.setText(ob1 +"*"+ob2);
		box1.setText("");

		num++;
		if(num>Main.kol)
		{
			end();
		}
	}
	
	public void end()
	{
		    que.setVisible(false);
			box1.setVisible(false);
			answer.setVisible(false);
			number.setVisible(false);
			res.setVisible(true);
			back.setVisible(true);
			mis.setVisible(true);
			int prav=0;
			for(Record e:Main.list)
			{
				if(e.ans==true)
				{
					prav++;
				}
			}
			float pr = ((float)prav)/Main.kol*100;
			int re;
			if(pr>Main.pr5)
			{
				res.setText("Ваша оценка 5!");
				re=5;
			}
			else
			{
				if(pr>Main.pr4)
				{
					res.setText("Ваша оценка 4");
					re=4;
				}
				else
				{
					if(pr>Main.pr3)
					{
						res.setText("Ваша оценка 3");
						re=3;
					}
					else
					{
						res.setText("Вы не сдали(");
						re=2;
					}
				}
			}
			Main.listName.add(new NameRes(name,re));
	}

	public void mistake(ActionEvent even) throws IOException
	{
		Stage primaryStage=new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/view/Table.fxml"));
        primaryStage.setTitle("Учимся умножать");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
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
