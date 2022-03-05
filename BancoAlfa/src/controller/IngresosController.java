package controller;

import java.time.LocalDate;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;

public class IngresosController {
	
	private Main main;
	
	public void setMain(Main main) {
		this.main = main;
	}
	@FXML
	private MenuBar menu;
		
	@FXML 
	private TextField monto;
	
	@FXML 
	private TextField descrip;
	
	@FXML 
	private DatePicker date;
		
	@FXML 
	private ComboBox<String> tipo;
	
	@FXML
	private Button save;
	
	private ObservableList<String> options = FXCollections.observableArrayList("Ingreso","Gasto");
	
	@FXML
	private void initialize() {
		tipo.setItems(options);
	}
	

	
	@FXML
	public void save() {	
		
		Double inputMonto= Double.parseDouble(monto.getText());
		String inputDescrip= descrip.getText();
		LocalDate inputDate= date.getValue();
		String inputTipo= tipo.getValue();
		
		int tip;
		if (inputTipo.equals("Ingreso")) {
			tip=1;
		}else {
			tip=0;
		}
		main.newTransaccion(inputMonto,tip,inputDescrip,inputDate);
		
		monto.setText(null);
		descrip.setText(null);
		date.setValue(null);
		tipo.valueProperty().set(null);
	}
	

}
