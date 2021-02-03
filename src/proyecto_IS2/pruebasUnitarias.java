package proyecto_IS2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


class pruebasUnitarias {
	private Sistema sistema1;
	
	@BeforeEach
	public void testInicializacion () {
		sistema1=new Sistema();
	}

	@Test
	void testlistarVehiculosDisponiblesPorGama1() throws ParseException, SQLException {
		SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
		Date fecha_ini=new Date(formato.parse("2020-11-14").getTime());
		Date fecha_fin=new Date(formato.parse("2020-11-17").getTime());
		assertFalse(sistema1.listarVehiculosDisponiblesPorGama(fecha_ini, fecha_fin, "Madrid", "media").isEmpty());
	}
	
	@Test
	void testlistarVehiculosDisponiblesPorGama2() throws ParseException, SQLException {
		
		assertFalse(sistema1.listarVehiculosDisponiblesPorGama(null, null, "Madrid", "media").isEmpty());
	}
	@Test
	void testlistarVehiculosDisponiblesPorGama3() throws ParseException, SQLException {
		SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
		Date fecha_ini=new Date(formato.parse("2020-11-17").getTime());
		Date fecha_fin=new Date(formato.parse("2020-11-14").getTime());
		assertFalse(sistema1.listarVehiculosDisponiblesPorGama(fecha_ini, fecha_fin, "Madrid", "media").isEmpty());
	}
	
	@Test
	void testlistarVehiculosDisponiblesPorMarca1() throws ParseException, SQLException {
		SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
		Date fecha_ini=new Date(formato.parse("2020-11-14").getTime());
		Date fecha_fin=new Date(formato.parse("2020-11-17").getTime());
		assertFalse(sistema1.listarVehiculosDisponiblesPorMarca(fecha_ini, fecha_fin, "Madrid", "Seat","Ibiza").isEmpty());
	}
	
	
	@Test
	void testlistarVehiculosDisponiblesPorMarca2() throws ParseException, SQLException {


		assertFalse(sistema1.listarVehiculosDisponiblesPorMarca(null, null, "Madrid", "Seat","Ibiza").isEmpty());
	}
	@Test
	void testcrearReserva1() throws ParseException, SQLException {
		
		SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
		Date fecha_ini=new Date(formato.parse("2020-11-24").getTime());
		Date fecha_fin=new Date(formato.parse("2020-11-27").getTime());
		assertTrue(sistema1.crearReserva("72548742A",fecha_ini, fecha_fin, "Madrid","Madrid","212AAD",1,1,0,1,"tarjeta","123456789"));
	}
	
	@Test
	void testcrearReserva2() throws ParseException, SQLException {
		
		SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
		Date fecha_ini=new Date(formato.parse("2020-11-14").getTime());
		Date fecha_fin=new Date(formato.parse("2020-11-17").getTime());
		assertThrows(SQLException.class, () -> {
			sistema1.crearReserva("DNI_MAL",fecha_ini, fecha_fin, "Madrid","Madrid","212AAD",1,1,0,1,"tarjeta","123456789");
		});
		
	}
	
	@Test
	void testcrearReservaConId1() throws ParseException, SQLException {
		
		SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
		Date fecha_ini=new Date(formato.parse("2021-03-14").getTime());
		Date fecha_fin=new Date(formato.parse("2021-03-17").getTime());
		
	
		assertTrue(sistema1.crearReservaConId(2,"212AAF",fecha_ini, fecha_fin,"72548742A","tarjeta","Madrid","Madrid","Seat","Ibiza","123456789",1,1,0,1));
	}
	
	@Test
	void testcrearReservaConId2() throws ParseException, SQLException {
		
		SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
		Date fecha_ini=new Date(formato.parse("2021-03-14").getTime());
		Date fecha_fin=new Date(formato.parse("2021-03-17").getTime());
		
		assertThrows(SQLException.class, () -> {
			sistema1.crearReservaConId(12345,"MATRICULA_INEXISTENTE",fecha_ini, fecha_fin,"72548742A","tarjeta","Madrid","Madrid","Seat","Ibiza","123456789",1,1,0,1);
		});
		
	}
	
	
	@Test
	void testcalculaDias1() throws ParseException {
		
		SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
		Date fecha_ini=new Date(formato.parse("2020-11-22").getTime());
	
		
		assertTrue(sistema1.calcularDias(fecha_ini)==5);
		
	}
	
	@Test
	void testdniEnBD1() throws SQLException  {
	
		assertTrue(sistema1.dniEnBD("72548742A"));
	}
	@Test
	void testdniEnBD2() throws SQLException  {
	
		assertFalse(sistema1.dniEnBD("DNI_NO_INTRODUCIDO"));
	}
	
	
	
	

	@Test
	void testcancelarReserva() throws SQLException, IdReservaDoesNotExist, UnauthorizedException  {
	
		assertTrue(sistema1.cancelarReserva(2)==0);
	}
	
	
	@Test
	void testCancelarReserva2() throws SQLException  {
		assertThrows(IdReservaDoesNotExist.class, () -> {
			sistema1.cancelarReserva(20360);
		});
	
	}
		
	@Test
	void testComprobarPropietarioReserva() throws SQLException  {
		assertTrue(sistema1.comprobarPropietarioDeLaReserva(1, "72548742A"));
	
	}
	@Test
	void testComprobarPropietarioReserva2() throws SQLException  {
		assertFalse(sistema1.comprobarPropietarioDeLaReserva(1, "05447659V"));
	
	}
}
