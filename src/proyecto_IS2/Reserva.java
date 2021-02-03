package proyecto_IS2;

import java.util.ArrayList;
import java.sql.Date;

public class Reserva {

	private int id;
	private String dni;
	private String metodo_pago;
	private String matricula;
	private String recogida; 
	private String dejada;
	private int seguro;
	private Date fecha_inicio;
	private Date fecha_fin;
	private String tarjeta;
	private int extra_cadena;
	private int extra_asiento;
	private int extra_navegador;
	
	public Reserva(int id, String dni, String metodo_pago, String matricula, int seguro,
			Date fecha_inicio, Date fecha_fin, String tarjeta, int extra_cadena, int extra_asiento,
			int extra_navegador) {
		this.id = id;
		this.dni = dni;
		this.metodo_pago = metodo_pago;
		this.matricula = matricula;
		this.seguro = seguro;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.tarjeta = tarjeta;
		this.extra_cadena = extra_cadena;
		this.extra_asiento = extra_asiento;
		this.extra_navegador = extra_navegador;
	}
	public Reserva(int id, String dni, String metodo_pago, String matricula, String recogida, String dejada, int seguro,
			Date fecha_inicio, Date fecha_fin, String tarjeta, int extra_cadena, int extra_asiento,
			int extra_navegador) {
		this.id = id;
		this.dni = dni;
		this.metodo_pago = metodo_pago;
		this.matricula = matricula;
		this.recogida = recogida;
		this.dejada = dejada;
		this.seguro = seguro;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.tarjeta = tarjeta;
		this.extra_cadena = extra_cadena;
		this.extra_asiento = extra_asiento;
		this.extra_navegador = extra_navegador;
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
	public String getMetodo_pago() {
		return metodo_pago;
	}
	public void setMetodo_pago(String metodo_pago) {
		this.metodo_pago = metodo_pago;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getSeguro() {
		return seguro;
	}
	public void setSeguro(int seguro) {
		this.seguro = seguro;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public Date getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public String getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}
	public int getExtra_cadena() {
		return extra_cadena;
	}
	public void setExtra_cadena(int extra_cadena) {
		this.extra_cadena = extra_cadena;
	}
	public int getExtra_asiento() {
		return extra_asiento;
	}
	public void setExtra_asiento(int extra_asiento) {
		this.extra_asiento = extra_asiento;
	}
	public int getExtra_navegador() {
		return extra_navegador;
	}
	public void setExtra_navegador(int extra_navegador) {
		this.extra_navegador = extra_navegador;
	}

	public String getRecogida() {
		return recogida;
	}
	public void setRecogida(String recogida) {
		this.recogida = recogida;
	}
	public String getDejada() {
		return dejada;
	}
	public void setDejada(String dejada) {
		this.dejada = dejada;
	}
}
