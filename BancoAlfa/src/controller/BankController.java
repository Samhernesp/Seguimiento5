package controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BankController {
	
	private Main main;
	
	@FXML
	public void registry() {
		main.showRegistry();
	}
	
	@FXML
	public void show() {
		main.historialRegistry();
	}
	@FXML
	public void close() {
		main.close();
	}

	@FXML
	TextField moneyWin;
	
	@FXML
	TextField moneyLose;
	
	@FXML
	TextField balance;
	
	public void setMain(Main main) {
		this.main = main;
	}
	
}
