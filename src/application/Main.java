package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;




public class Main extends Application {
	public static Stage pr;
	public static Parent root;
	
	public static int kol = 10;
	public static int pr5 = 85;
	public static int pr4 = 70;
	public static int pr3 = 50;
	
	public static ArrayList <Record> list = new ArrayList<Record>();
	public static ArrayList <NameRes> listName = new ArrayList<NameRes>();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			pr = primaryStage;
			root  = FXMLLoader.load(getClass().getResource("/view/Menu.fxml"));
 
            primaryStage.setTitle("Учимся умножать");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static Stage getStage()
	{
		return pr;
	}
	
	public static Parent getRoot() {
		return root;
	}

	public static void listName(String name, int re) {
		// TODO Auto-generated method stub
		
	}
	
}
