package application;
	

import java.time.LocalDate;

import controller.BankController;
import controller.IngresosController;
import controller.ShowListController;
import javafx.application.Application;
import javafx.collections.transformation.FilteredList;
import javafx.stage.Stage;
import model.System;
import model.Transaccion;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private Stage currentStage;
	
	
	private System sys;
	
	public Main() {
		sys=new System();
	}
	

	@Override
	public void start(Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Bank.fxml"));
			BorderPane root = (BorderPane)loader.load();
		
			Scene scene = new Scene(root,600,400);	
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			BankController controller = loader.getController();
			controller.setMain(this);
			stage.setScene(scene);
			stage.close();
			stage.show();
			currentStage=stage;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showRegistry() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Ingresos.fxml"));
			BorderPane registro = (BorderPane)loader.load();
			IngresosController controller = loader.getController();
			controller.setMain(this);
			
			Stage stage = currentStage;
			
			BorderPane root = (BorderPane)stage.getScene().getRoot();
			root.setCenter(registro);
			root.setBottom(null);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void historialRegistry() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowList.fxml"));
			BorderPane lista = (BorderPane)loader.load();
			ShowListController controller = loader.getController();
			controller.setMain(this);
			controller.addTable();
			
			Stage stage = currentStage;
			
			BorderPane root = (BorderPane)stage.getScene().getRoot();
			root.setCenter(lista);
			root.setBottom(null);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void close() {
		currentStage.close();
		start(currentStage);
	}
	
	public void newTransaccion(Double inputMonto, int inputTipo,String inputDescrip, LocalDate inputDate ) {
		sys.newTransaccion(inputMonto, inputTipo, inputDescrip, inputDate);
	}

	public void deleteRegist(Transaccion trans) {
		
		sys.deleteTransaccion(trans);
		
	}

	public FilteredList<Transaccion> getList() {
		return sys.getList();
	}
	

	
}
