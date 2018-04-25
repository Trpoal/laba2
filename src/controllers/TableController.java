package controllers;

import application.Main;
import application.Record;
import application.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.control.TableColumn;

public class TableController {

	private ObservableList<User> usersData = FXCollections.observableArrayList();

    @FXML
    private TableView<User> tableUsers;

    @FXML
    private TableColumn<User, String> ex;

    @FXML
    private TableColumn<User, Integer> right;

    @FXML
    private TableColumn<User, Integer> ans;

    @FXML
    private TableColumn<User, Boolean> pr;

    @FXML
    private void initialize() {
        initData();

        
        ex.setCellValueFactory(new PropertyValueFactory<User, String>("ex"));
        right.setCellValueFactory(new PropertyValueFactory<User, Integer>("right"));
        ans.setCellValueFactory(new PropertyValueFactory<User, Integer>("ans"));
        pr.setCellValueFactory(new PropertyValueFactory<User, Boolean>("pr"));

        tableUsers.setItems(usersData);
    }

    private void initData() {
        for(Record e:Main.list)
        {
        	usersData.add(new User(e.ob1+"*"+e.ob2,e.resCo,e.resPo,e.ans));
        }
    }

}