package model;

import java.time.LocalDate;

public class Transaccion {
		
	private double monto;
	private String tipo;
	private String description;
	private LocalDate date;
	
	public Transaccion(double monto, int tipo, String description, LocalDate date) {
		this.monto=monto;
		if (tipo==1) {
			this.tipo="Ingreso";
		}else {
			this.tipo="Gasto";
		}
		this.description=description;
		this.date=date;
	}
	
	public double getMonto() {
		return monto;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public String geDescription() {
		return description;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public String toString() {
		return "Monto:"+monto+"\n"+
				"Tipo:"+tipo+"\n"+
				"Descripcion:"+description+"\n"+
				"Fecha"+date;
	}
	

}
