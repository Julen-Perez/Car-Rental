package proyecto_IS2;

import java.sql.Date;

public class Factura {
	 private int id;
	 private String dni;
	 private String pago;
	 private Date fecha;
	 private String tarjeta;
	 private String banco;
	 
	public Factura(int id, String dni, String pago, Date fecha, String tarjeta, String banco) {
		this.id = id;
		this.dni = dni;
		this.pago = pago;
		this.fecha = fecha;
		this.tarjeta = tarjeta;
		this.banco = banco;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getPago() {
		return pago;
	}
	public void setPago(String pago) {
		this.pago = pago;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
}
