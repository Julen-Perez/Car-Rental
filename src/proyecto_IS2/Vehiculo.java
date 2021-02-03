package proyecto_IS2;

public class Vehiculo {

	
	/*
	 
	 Matrícula, Marca, Modelo, Gama, Tarifa, Extras, Estado, Disponibilidad 
	 */
	 private String matricula;
	 private String marca;
	 private String modelo; 
	 private String gama;
	 private double tarifa; 
	 private String franquicia;
	 
	@Override
	public String toString() {
		return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", gama=" + gama
				+ ", tarifa=" + tarifa + ", franquicia=" + franquicia + "]";
	}

	public Vehiculo(String matricula, String marca, String modelo, String gama,String franquicia,double tarifa) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.gama = gama;
		this.tarifa=tarifa;
		
		this.franquicia=franquicia;
	}
	
	public String getFranquicia() {
		return franquicia;
	}
	public void setFranquicia(String franquicia) {
		this.franquicia = franquicia;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getGama() {
		return gama;
	}
	public void setGama(String gama) {
		this.gama = gama;
	}
	public double getTarifa() {
		return tarifa;
	}
	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}
}
	
