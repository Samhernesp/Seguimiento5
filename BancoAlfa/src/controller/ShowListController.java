package controller;

import java.time.LocalDate;
import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Transaccion;

public class ShowListController {
	
	private Main main;
	
	@FXML
	private TableView<Transaccion> table;
	
	@FXML
	private TableColumn<Transaccion,LocalDate> dateColumn;
	
	@FXML
	private TableColumn<Transaccion,Double> montoColumn;
	
	@FXML
	private TableColumn<Transaccion,String> tipoColumn;
	
	@FXML
	public void initialize() {
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
		montoColumn.setCellValueFactory(new PropertyValueFactory<>("monto"));
		tipoColumn.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		
	}
	
	public void addTable() {
		table.setItems(main.getList());
	}
	
	public void setMain(Main main) {
		this.main=main;
	}
	
	
	@FXML
	public void delete() {
		Transaccion trans = table.getSelectionModel().getSelectedItem();
		main.deleteRegist(trans);

	}
	
}
