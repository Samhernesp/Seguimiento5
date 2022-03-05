package model;

import javafx.collections.transformation.FilteredList;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class System {
	
	private ObservableList<Transaccion> object = FXCollections.observableArrayList();
	
	private FilteredList<Transaccion> list=new FilteredList<>(object);

	public FilteredList<Transaccion> getList(){
		return list;
	}
	
	public void newTransaccion(double monto, int tipo, String description, LocalDate date) {
		Transaccion trans=new Transaccion(monto, tipo, description, date);
		object.add(trans);
	}
	
	public void deleteTransaccion(Transaccion trans) {
		
		object.remove(trans);
	}
}
