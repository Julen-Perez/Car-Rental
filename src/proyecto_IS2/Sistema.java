package proyecto_IS2;


import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Sistema {

	public int id_reserva_generado;
	private String drv="com.mysql.cj.jdbc.Driver";
	
	//private String drv="org.h2.Driver";
	
	private String serverAddress ="localhost:3306";
	private String db = "is2";
	private String user ="root";
	private String pass="root";
	private Connection conn;

	
	
	
	

	//Función para conectarse a la Base de Datos
	public boolean conectar() throws SQLException {
		try{
			Class.forName(drv);
		}catch(ClassNotFoundException el) {
			el.printStackTrace();
			return false;
		}
		String url="jdbc:mysql://"+serverAddress + "/"+db+"?allowMultiQueries=true";
		try {
			conn=DriverManager.getConnection(url,user,pass);
		}catch(SQLException e) {
			throw new SQLException("Error al concectarse a la Base de Datos.");

		}
		return true;
	}
	//Función para desconectarse de la Base de Datos
	public boolean desconectar() throws SQLException {
		try {
			conn.close();
		}catch(SQLException e){
			throw new SQLException("Fallo al intentar cerrar la cesion");
		}
		return true;
	}
	
	//Funcion que comprueba si el dni o cif es el propietario de la reserva. 
	public boolean comprobarPropietarioDeLaReserva(int id_reserva,String dni_cif) throws SQLException {
		if(!conectar()) {
			System.out.println("Fallo al establecer la conexión con la Base de Datos");
			return false;
		}

		String sql = "SELECT * FROM reserva WHERE id_reserva=?;";
		PreparedStatement ps;
		try {
		
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id_reserva);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
			
				if(rs.getString("dni_cif").equals(dni_cif)) {
					
				
				rs.close();
				ps.close();
				if(!desconectar()) {
					throw new SQLException("Error al desconectar");
				}
				return true;
			}else {
				rs.close();
				ps.close();
				if(!desconectar()) {
					throw new SQLException("Error al desconectar");
				}
				return false;
			}
			}
			else {
				rs.close();
				ps.close();
				if(!desconectar()) {
					throw new SQLException("Error al desconectar");
				}
				return false;
			}
		} catch (SQLException e) {

			throw new SQLException("Creating user failed, no ID obtained.");
		}

	}

	//Lista los vehículos disponibles con una gama en concreto
	public ArrayList<Vehiculo> listarVehiculosDisponiblesPorGama(Date fecha_ini, Date fecha_fin, String recogida, String gama) throws SQLException {
		ArrayList<Vehiculo> listaVehiculos=new ArrayList<Vehiculo>();
		if(!conectar()) {
			System.out.println("Fallo al establecer la conexion");
			return listaVehiculos;
		}
		try {


			String sql;
			PreparedStatement ps;
			if(recogida==null && gama==null) {
				sql = "SELECT * FROM vehiculo WHERE gama=ANY(SELECT gama FROM vehiculo) AND franquicia=ANY(SELECT franquicia FROM vehiculo) AND (matricula NOT IN (SELECT matricula FROM reserva) OR  matricula NOT IN (SELECT matricula FROM reserva WHERE (fecha_inicio<=? AND fecha_fin>=?)));";
				ps = conn.prepareStatement(sql);
				ps.setDate(2,fecha_ini);
				ps.setDate(1,fecha_fin);
			}
			else if(recogida==null && gama!=null) {
				sql = "SELECT * FROM vehiculo WHERE gama=? AND franquicia=ANY(SELECT franquicia FROM vehiculo) AND (matricula NOT IN (SELECT matricula FROM reserva) OR  matricula NOT IN (SELECT matricula FROM reserva WHERE (fecha_inicio<=? AND fecha_fin>=?)));";
				ps = conn.prepareStatement(sql);
				ps.setString(1, gama);
				ps.setDate(3,fecha_ini);
				ps.setDate(2,fecha_fin);
			}
			else if(recogida!=null && gama==null) {
				sql = "SELECT * FROM vehiculo WHERE gama=ANY(SELECT gama FROM vehiculo) AND franquicia=? AND (matricula NOT IN (SELECT matricula FROM reserva) OR  matricula NOT IN (SELECT matricula FROM reserva WHERE (fecha_inicio<=? AND fecha_fin>=?)));";
				ps = conn.prepareStatement(sql);
				ps.setString(1, recogida);
				ps.setDate(3,fecha_ini);
				ps.setDate(2,fecha_fin);
			}
			else {
				sql = "SELECT * FROM vehiculo WHERE gama=? AND franquicia=? AND (matricula NOT IN (SELECT matricula FROM reserva) OR  matricula NOT IN (SELECT matricula FROM reserva WHERE (fecha_inicio<=? AND fecha_fin>=?)));";
				ps = conn.prepareStatement(sql);
				ps.setString(1, gama);
				ps.setString(2, recogida);
				ps.setDate(4,fecha_ini);
				ps.setDate(3,fecha_fin);
			}




			ResultSet rs = ps.executeQuery();


			Vehiculo coche;


			while(rs.next()){

				coche= new Vehiculo(rs.getString("matricula"),rs.getString("marca"),rs.getString("modelo"),rs.getString("gama"),rs.getString("franquicia"),Double.parseDouble(rs.getString("tarifa")));
				listaVehiculos.add(coche);

			}
			if(listaVehiculos.isEmpty()){
				System.out.println("No se puede realizar la reserva con esas caracteristicas, en esa fecha");

			}
		} catch (SQLException e) {
			throw new SQLException("Creating user failed, no ID obtained.");

		}finally {
		if(!desconectar()) {
			throw new SQLException("Creating user failed, no ID obtained.");
		}
		
		}
		return listaVehiculos;
	}

	//Lista los vehículos disponibles con una marca y modelo en concretos
	public ArrayList<Vehiculo> listarVehiculosDisponiblesPorMarca(Date fecha_ini, Date fecha_fin, String recogida, String marca,String modelo) throws SQLException {
		ArrayList<Vehiculo> listaVehiculos=new ArrayList<Vehiculo>();
		if(!conectar()) {
			System.out.println("Fallo al realizar la conexion");
			return listaVehiculos;
		}
		try {

			
			String sql = "SELECT * FROM vehiculo WHERE modelo=? AND franquicia=? AND (matricula NOT IN (SELECT matricula FROM reserva) OR  matricula NOT IN (SELECT matricula FROM reserva WHERE (fecha_inicio<=? AND fecha_fin>=?)));";
			PreparedStatement ps = conn.prepareStatement(sql);
			if(modelo==null) {
				ps.setString(1,"ANY(SELECT modelo FROM vehiculo");

			}
			
			else {
				ps.setString(1,modelo);
			}
			if(recogida==null) {

				ps.setString(2,"ANY(SELECT franquicia FROM vehiculo);");
			}
			else {
				ps.setString(2,recogida);
			}
			System.out.println(recogida);
			System.out.println(modelo);
			System.out.println(fecha_ini);
			System.out.println(fecha_fin);
			System.out.println();
			ps.setDate(4,fecha_ini);
			ps.setDate(3, fecha_fin);

			ResultSet rs = ps.executeQuery();


			Vehiculo coche;


			while(rs.next()){
				coche= new Vehiculo(rs.getString("matricula"),marca,modelo,rs.getString("gama"),rs.getString("franquicia"),Double.parseDouble(rs.getString("tarifa")));
				listaVehiculos.add(coche);

			}
			if(listaVehiculos.isEmpty()){
				System.out.println("No se puede realizar la reserva con esas caracteristicas, en esa fecha");

			}
		} catch (SQLException e) {
			throw new SQLException("Creating user failed, no ID obtained.");

		}
		if(!desconectar()) {
			throw new SQLException("Creating user failed, no ID obtained.");
		}
		return listaVehiculos;
	}

	//Función genera una reserva desde 0 
	public boolean crearReserva(String dni,Date fecha_ini, Date fecha_fin, String recogida,String entrega,String matricula, int seguro, 
			int extra_gps,int extra_cadena,int extra_asiento,String metodo_pago,String num_tarjeta) throws SQLException {
		if(!conectar()) {
			System.out.println("Fallo al realizar la conexión");
			return false;
		}
		String sql2="INSERT INTO reserva (matricula,dni_cif,fecha_inicio,fecha_fin, metodo_pago,num_tarjeta,lugar_recogida,lugar_devolucion,extra_navegador,extra_cadenas,extra_asiento,seguro)VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";

		PreparedStatement ps2;
		try {
			ps2 = conn.prepareStatement(sql2,Statement.RETURN_GENERATED_KEYS);

			ps2.setString(1,matricula);

			ps2.setString(2, dni);
			ps2.setDate(3,fecha_ini);
			ps2.setDate(4,fecha_fin);
			ps2.setString(5,metodo_pago);
			ps2.setString(6, num_tarjeta);
			ps2.setString(7, recogida);
			ps2.setString(8, entrega);
			ps2.setInt(9,extra_gps);
			ps2.setInt(10, extra_cadena);
			ps2.setInt(11, extra_asiento);
			ps2.setInt(12, seguro);
			int affectedRows = ps2.executeUpdate();	


			if (affectedRows == 0) {
				throw new SQLException("Creating user failed, no rows affected.");
			}

			try (ResultSet generatedKeys = ps2.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					id_reserva_generado=(int)generatedKeys.getLong(1);
					
				}
				else {
					throw new SQLException("Creating user failed, no ID obtained.");
				}
			}
		} catch (SQLException e) {

			throw new SQLException("Creating user failed, no ID obtained.");
		}
		if(!desconectar()) {
			throw new SQLException("Creating user failed, no ID obtained.");
		}

		return true;

	}
	
	//Función que se utiliza para modificar una reserva con un ID concreto
	public boolean crearReservaConId(int id_reserva,String matricula, Date fecha_ini, Date fecha_fin, String dni,String metodo_pago, String recogida, String entrega,String marca,
			String modelo,String tarjeta,int extra_gps,int extra_cadenas,int extra_asiento,int seguro) throws SQLException {



		if(!conectar()) {
			System.out.println("Fallo al establecer la conexión con la Base de Datos");
			return false;
		}
		try {

			String sql2="INSERT INTO reserva (id_reserva,matricula,dni_cif,fecha_inicio,fecha_fin, metodo_pago,num_tarjeta,lugar_recogida,lugar_devolucion,extra_navegador,extra_cadenas,extra_asiento,seguro)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);";

			PreparedStatement ps2 = conn.prepareStatement(sql2,Statement.RETURN_GENERATED_KEYS);

			ps2.setInt(1, id_reserva);
			ps2.setString(2,matricula);
			ps2.setString(3, dni);
			ps2.setDate(4,fecha_ini);
			ps2.setDate(5,fecha_fin);
			ps2.setString(6,metodo_pago);
			ps2.setString(7,tarjeta);
			ps2.setString(8,recogida);
			ps2.setString(9, entrega);
			ps2.setInt(10,extra_gps);
			ps2.setInt(11, extra_cadenas);
			ps2.setInt(12, extra_asiento);
			ps2.setInt(13,seguro);
			int affectedRows = ps2.executeUpdate();	


			if (affectedRows == 0) {
				throw new SQLException("Creating user failed, no rows affected.");
			}

			try (ResultSet generatedKeys = ps2.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					id_reserva_generado=(int)generatedKeys.getLong(1);
				}
				else {
					throw new SQLException("Creating user failed, no ID obtained.");
				}
			}

		} catch (SQLException e) {
			throw new SQLException("Creating user failed, no ID obtained.");

		}
		if(!desconectar()) {
			throw new SQLException("Creating user failed, no ID obtained.");
		}
		return true;

	}

	//Función que calcula los días entre la fecha pasada y la actual en el sistema.
	public int calcularDias (java.sql.Date fecha_inicio ) {

		LocalDate inicio =fecha_inicio.toLocalDate();
		LocalDate hoy = LocalDate.now();
	
		
		Duration duration = Duration.between( hoy.atStartOfDay(), 
                inicio.atStartOfDay());
		
		return (int)duration.toDays();
	}

	//Devuelve true si el DNI-CIF está dado de alta en la Base de Datos y false en caso contrario.
	public boolean dniEnBD(String dni) throws SQLException {
		if(!conectar()) {
			System.out.println("Fallo al establecer la conexión con la Base de Datos");
			return false;
		}
		String sql = "SELECT * FROM cliente WHERE dni_cif=?;";
		PreparedStatement ps;
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1,dni);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				rs.close();
				ps.close();
				if(!desconectar()) {
					throw new SQLException("Error al desconectar");
				}
				return true;
			}
			else {
				rs.close();
				ps.close();
				if(!desconectar()) {
					throw new SQLException("Error al desconectar");
				}
				return false;
			}
		} catch (SQLException e) {

			throw new SQLException("Creating user failed, no ID obtained.");
		}



	}

	//Versión basica de generar factura, tiene en cuenta la gama, numero de dias y extras de la reserva.
	public double generarFactura(int id,String metood_pago,boolean esCancelacion,String dni) throws SQLException, IdReservaDoesNotExist, UnauthorizedException {

		if(!conectar()) {
			System.out.println("Fallo al establecer la conexion");
			return 0;
		}
		
		double total=0;
		
		
		double tarifa;
		
		try {
			String sql = "SELECT * FROM reserva WHERE id_reserva = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Reserva reserva;

			if (rs.next()){
				reserva=new Reserva(rs.getInt("id_reserva"), rs.getString("dni_cif"), rs.getString("metodo_pago"), rs.getString("matricula"),  rs.getInt("seguro"),
						rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"), rs.getString("num_tarjeta"),rs.getInt("extra_cadenas"),rs.getInt("extra_asiento"),
						rs.getInt("extra_navegador"));

			}else {
				
				throw new IdReservaDoesNotExist("Id de la reserva inexistente");

			}
			if(!reserva.getDni().equals(dni)) {
			
				throw new UnauthorizedException("El cliente no es propietario de la reserva");

			}
			String matricula=reserva.getMatricula();
			sql = "SELECT tarifa FROM vehiculo WHERE matricula = ?;";
		

			ps = conn.prepareStatement(sql);
			ps.setString(1, matricula);
			rs = ps.executeQuery();
			
			if (rs.next()){
				tarifa=rs.getDouble("tarifa");
			
			}else {
				
				System.out.println("Error generando la factura");
				
				return -1;
			}

			//// ESTO ES PARA CALCULAR LA DIFERENCIA EN DIAS ENTRE LAS FECHAS
			
			
			Calendar cal1 = new GregorianCalendar();
			Calendar cal2 = new GregorianCalendar();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			java.util.Date date;
			try {
				date = sdf.parse(""+reserva.getFecha_fin());
				cal1.setTime(date);
				date =sdf.parse(""+reserva.getFecha_inicio());
				cal2.setTime(date);
				
			} catch (ParseException e) {
			
				throw new SQLException("Creating user failed, no ID obtained.");
			}

			int dias = (int)( (cal1.getTime().getTime() - cal2.getTime().getTime()) / (1000 * 60 * 60 * 24));

			////Hasta aquí llega el cálculo de dias


			int extras=reserva.getExtra_asiento()+reserva.getExtra_cadena()+reserva.getExtra_navegador();
			//descomentar linea para implementar toda la funcionalidad
			total=(dias*tarifa)+extras*15+reserva.getSeguro()*10;
			if(esCancelacion) {
				int dias_separacion=calcularDias(reserva.getFecha_inicio());

				switch(dias_separacion){
				case 0:
				case 1:
				case 2:
				case 3:
				case 4:
					total=total*30 /100;
					break;
				case 5:
				case 6: 
				case 7: 
				case 8:
				case 9:
					total=total*15/100;
					break;
				default: 
					total=0;
					break; 
				}
			}

		} catch (SQLException e) {
		
			throw new SQLException("Creating user failed, no ID obtained.");
		}


	
		return total;
	}	

	//Metodo para cancelar una reservar, devuelve la penalización en caso de que la tubiese y 0 en caso contrario. 
	public double cancelarReserva(int id_reserva)throws IdReservaDoesNotExist, SQLException, UnauthorizedException{

		if(!conectar()) {
			System.out.println("Fallo al establecer la conexión con la Base de Datos");
			return -1;
		}
		double sol=0;

		try {
			String sql = "SELECT * FROM reserva WHERE id_reserva = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id_reserva);
			ResultSet rs = ps.executeQuery();
			Reserva reserva;

			if (rs.next()){
				reserva=new Reserva(rs.getInt("id_reserva"), rs.getString("dni_cif"), rs.getString("metodo_pago"), rs.getString("matricula"),  rs.getInt("seguro"),
						rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"), rs.getString("num_tarjeta"),rs.getInt("extra_cadenas"),rs.getInt("extra_asiento"),
						rs.getInt("extra_navegador"));

			}else {
				throw new IdReservaDoesNotExist("Id de la reserva inexistente");

			}
			sol=generarFactura(reserva.getId(),"tarjeta",true,reserva.getDni());
			System.out.println(sol);
			System.out.println("SUSSSSSS");
			String sql2 = "DELETE FROM reserva WHERE id_reserva=?;";
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, id_reserva);
			System.out.println("SUSSSSSS2");
			ps2.executeUpdate();
		
			
		} catch (SQLException e) {
			throw new SQLException("Error al borrar la factura");

		}
		if(!desconectar()) {
			throw new SQLException("Creating user failed, no ID obtained.");
		}
		return sol;

	}

	//Función para modificar una reserva, llama a generar facturas en caso de que hubiese un recargo. 
	public double modificarReserva(int id_reserva, Date fecha_ini, Date fecha_fin, String dni, String metodo_pago, String recogida, String entrega,String marca,
			String modelo,int extra_gps,int extra_cadenas,int extra_asiento,int seguro) throws UnauthorizedException, IdReservaDoesNotExist, SQLException{
		double sol;
		if(!conectar()) {
			System.out.println("Fallo al establecer la conexión con la Base de Datos");
			return -1;
		}

		try {
			String sql = "SELECT * FROM reserva WHERE id_reserva = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id_reserva);

			ResultSet rs = ps.executeQuery();
			Reserva reserva;
			
			if (rs.next()){
				reserva=new Reserva(rs.getInt("id_reserva"), rs.getString("dni_cif"), rs.getString("metodo_pago"), rs.getString("matricula"), rs.getString("lugar_recogida"),
						rs.getString("lugar_devolucion"), rs.getInt("seguro"),rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"), rs.getString("num_tarjeta"),
						rs.getInt("extra_cadenas"),rs.getInt("extra_asiento"),rs.getInt("extra_navegador"));
			}else {
				throw new IdReservaDoesNotExist("Id de la reserva inexistente");

			}
			if(!reserva.getDni().equals(dni)) {
				throw new UnauthorizedException("El cliente no es propietario de la reserva");

			}
			sol=generarFactura(reserva.getId(), "tarjeta",true,reserva.getDni());
			String sql2 = "DELETE  FROM reserva WHERE id_reserva=?;";
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, id_reserva);
			ps2.executeUpdate();
			// meter marca y modelo en el constructor

			if(metodo_pago==null) {
				metodo_pago=(reserva.getMetodo_pago());
			}

			if(entrega==null) {
				entrega=(reserva.getDejada());
			}
			if(seguro==-1) {
				seguro=(reserva.getSeguro());
			}


			if(extra_gps==-1) {
				extra_gps=(reserva.getExtra_navegador());
			}
			if(extra_cadenas==-1) {
				extra_cadenas=(reserva.getExtra_cadena());
			}
			if(extra_asiento==-1) {
				extra_asiento=(reserva.getExtra_asiento());
			}
			if(fecha_ini==null) {
				fecha_ini=reserva.getFecha_inicio();
			}
			if(fecha_fin==null) {
				fecha_fin=reserva.getFecha_fin();
			}
			if(recogida==null) {
				recogida=reserva.getRecogida();
			}


			String sql3 = "SELECT * FROM vehiculo WHERE matricula = ?;";
			PreparedStatement ps3 = conn.prepareStatement(sql3);
			ps3.setString(1, reserva.getMatricula());

			ResultSet rs2 = ps3.executeQuery();
			rs2.next();
			if(marca==null) {
				marca=rs2.getString("marca");
			}
			if(modelo==null) {
				modelo=rs2.getString("modelo");
			}
			
			ArrayList <Vehiculo> vehiculosDisponibles =listarVehiculosDisponiblesPorMarca(fecha_ini,fecha_fin,recogida, marca, modelo);

	
			if(vehiculosDisponibles.isEmpty()) {

				crearReservaConId(id_reserva,reserva.getMatricula(),reserva.getFecha_inicio(),reserva.getFecha_fin(),reserva.getDni(),reserva.getMetodo_pago(),reserva.getRecogida(),reserva.getDejada(),rs2.getString("marca"),rs2.getString("modelo"),reserva.getTarjeta(),reserva.getExtra_navegador(),reserva.getExtra_cadena(),reserva.getExtra_asiento(),reserva.getSeguro());
				if(!desconectar()) {
					throw new SQLException("Creating user failed, no ID obtained.");
				}
				return -1;
			}else {	
				crearReservaConId(id_reserva,vehiculosDisponibles.get(0).getMatricula(), fecha_ini,fecha_fin,dni,metodo_pago,recogida,entrega,marca,modelo,reserva.getTarjeta(),extra_gps,extra_cadenas,extra_asiento,seguro);
				if(!desconectar()) {
					throw new SQLException("Creating user failed, no ID obtained.");
				}
				return sol;
			}
		} catch (SQLException e) {
			throw new SQLException("Creating user failed, no ID obtained.");
		}
	}
	
	
	public boolean crearUsuario(String nombre, String apellidos,String dni) throws SQLException {
		if(!conectar()) {
			System.out.println("Fallo al realizar la conexión");
			return false;
		}
		String sql2="INSERT INTO cliente (dni_cif,nombre,apellidos)VALUES(?,?,?);";

		PreparedStatement ps2;
		try {
			ps2 = conn.prepareStatement(sql2,Statement.RETURN_GENERATED_KEYS);

			ps2.setString(1,dni);
			ps2.setString(2,nombre);
			ps2.setString(3,apellidos);

			
			int affectedRows = ps2.executeUpdate();	


			if (affectedRows == 0) {
				throw new SQLException("Creating user failed, no rows affected.");
			}

			try (ResultSet generatedKeys = ps2.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					id_reserva_generado=(int)generatedKeys.getLong(1);
					
				}
				else {
					throw new SQLException("Creating user failed, no ID obtained.");
				}
			}
		} catch (SQLException e) {

			throw new SQLException("Creating user failed, no ID obtained.");
		}
		if(!desconectar()) {
			throw new SQLException("Creating user failed, no ID obtained.");
		}

		return true;

		
	}
	public static void main(String [] args) throws Exception {
	     
	}

}


