import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import proyecto_IS2.*;

public class CrearReserva2 extends JFrame {

	public static String metodoPag;
	public static int seguro;
	public static String gama;
	public static String nTarjeta;
	public static int extraGPS=0;
	public static int extraCadenas=0;
	public static int extraAsientos=0;
	
	private JPanel contentPane;
	private JTextField numTarjeta;
	private JTextField Siguiente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearReserva2 frame = new CrearReserva2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CrearReserva2() {
		setTitle("Realizar Reserva");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearReserva2.class.getResource("icons8-car-rental-40.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 750, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNuevaReserva = new JLabel("Nueva Reserva");
		lblNuevaReserva.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevaReserva.setForeground(Color.WHITE);
		lblNuevaReserva.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 48));
		lblNuevaReserva.setBounds(90, 29, 536, 48);
		contentPane.add(lblNuevaReserva);
		
		JLabel lblMtodoPago = new JLabel("Metodo de pago*");
		lblMtodoPago.setHorizontalAlignment(SwingConstants.CENTER);
		lblMtodoPago.setForeground(Color.WHITE);
		lblMtodoPago.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 23));
		lblMtodoPago.setBounds(55, 126, 192, 48);
		contentPane.add(lblMtodoPago);
		
		JLabel lblNtarjeta = new JLabel("Numero Tarjeta *");
		lblNtarjeta.setHorizontalAlignment(SwingConstants.CENTER);
		lblNtarjeta.setForeground(Color.WHITE);
		lblNtarjeta.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 23));
		lblNtarjeta.setBounds(422, 126, 262, 48);
		contentPane.add(lblNtarjeta);
		
		numTarjeta = new JTextField();
		numTarjeta.setColumns(10);
		numTarjeta.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		numTarjeta.setBounds(459, 171, 171, 48);
		contentPane.add(numTarjeta);
		
		JComboBox metodoPago = new JComboBox();
		metodoPago.setOpaque(false);
		metodoPago.setModel(new DefaultComboBoxModel(new String[] {"Efectivo", "Tarjeta"}));
		metodoPago.setMaximumRowCount(5);
		metodoPago.setForeground(Color.WHITE);
		metodoPago.setFont(new Font("Open Sans", Font.PLAIN, 18));
		metodoPago.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		metodoPago.setBackground(new Color(70, 130, 180));
		metodoPago.setBounds(65, 169, 171, 48);
		contentPane.add(metodoPago);
		
		JLabel lblGamaVehculo = new JLabel("Gama Vehiculo");
		lblGamaVehculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGamaVehculo.setForeground(Color.WHITE);
		lblGamaVehculo.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 23));
		lblGamaVehculo.setBounds(60, 325, 176, 40);
		contentPane.add(lblGamaVehculo);
		
		JComboBox gamaVehiculo = new JComboBox();
		gamaVehiculo.setModel(new DefaultComboBoxModel(new String[] {"Cualquiera", "Baja", "Media", "Alta"}));
		gamaVehiculo.setMaximumRowCount(5);
		gamaVehiculo.setForeground(Color.WHITE);
		gamaVehiculo.setFont(new Font("Open Sans", Font.PLAIN, 18));
		gamaVehiculo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		gamaVehiculo.setBackground(new Color(70, 130, 180));
		gamaVehiculo.setBounds(65, 366, 171, 48);
		contentPane.add(gamaVehiculo);
		
		JLabel lblExtras = new JLabel("Extras");
		lblExtras.setHorizontalAlignment(SwingConstants.CENTER);
		lblExtras.setForeground(Color.WHITE);
		lblExtras.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 23));
		lblExtras.setBounds(454, 250, 176, 32);
		contentPane.add(lblExtras);
		
		JComboBox extrasVehiculo = new JComboBox();
		extrasVehiculo.setModel(new DefaultComboBoxModel(new String[] {"Ninguno", "Navegacion GPS", "Asientos bebe", "Cadenas de Nieve", "Cadenas + GPS", "Cadenas + Asientos ", "Asientos + GPS", "Cadenas + GPS + Asientos"}));
		extrasVehiculo.setMaximumRowCount(5);
		extrasVehiculo.setForeground(Color.WHITE);
		extrasVehiculo.setFont(new Font("Open Sans", Font.PLAIN, 12));
		extrasVehiculo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		extrasVehiculo.setBackground(new Color(70, 130, 180));
		extrasVehiculo.setBounds(459, 283, 171, 48);
		contentPane.add(extrasVehiculo);
		
		JLabel lblSeguro = new JLabel("Seguro *");
		lblSeguro.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeguro.setForeground(Color.WHITE);
		lblSeguro.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 23));
		lblSeguro.setBounds(71, 226, 176, 35);
		contentPane.add(lblSeguro);
		
		JComboBox seguroVehiculo = new JComboBox();
		seguroVehiculo.setModel(new DefaultComboBoxModel(new String[] {"Basico", "Premium"}));
		seguroVehiculo.setMaximumRowCount(5);
		seguroVehiculo.setForeground(Color.WHITE);
		seguroVehiculo.setFont(new Font("Open Sans", Font.PLAIN, 18));
		seguroVehiculo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		seguroVehiculo.setBackground(new Color(70, 130, 180));
		seguroVehiculo.setBounds(65, 261, 171, 48);
		contentPane.add(seguroVehiculo);
		
		JLabel lblGrupo = new JLabel("Grupo 28 - IS2");
		lblGrupo.setForeground(Color.WHITE);
		lblGrupo.setFont(new Font("Open Sans", Font.BOLD, 16));
		lblGrupo.setBounds(610, 459, 118, 35);
		contentPane.add(lblGrupo);
		
		JLabel lblCampo = new JLabel("* - Campo Obligatorio");
		lblCampo.setForeground(Color.WHITE);
		lblCampo.setFont(new Font("Open Sans", Font.BOLD, 13));
		lblCampo.setBounds(15, 461, 163, 35);
		contentPane.add(lblCampo);
		
		JLabel CorrectTarjeta = new JLabel("");
		CorrectTarjeta.setForeground(Color.WHITE);
		CorrectTarjeta.setFont(new Font("Open Sans", Font.PLAIN, 16));
		CorrectTarjeta.setBounds(459, 221, 248, 27);
		contentPane.add(CorrectTarjeta);
		
		Siguiente = new JTextField();
		Siguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				boolean correcto=true;
				
				if(numTarjeta.getText().equals("")) {
					correcto=false;
					CorrectTarjeta.setText("Rellene los campos indicados");
				}
				if(correcto) {
					metodoPag=metodoPago.getSelectedItem().toString();
					nTarjeta=numTarjeta.getText();
					if(seguroVehiculo.getSelectedItem().toString().equals("Basico")) {
						seguro=1;
					}
					else {
						seguro=2;
					}
					if(gamaVehiculo.getSelectedItem().toString().equals("Cualquiera")) {
						gama=null;
					}
					else {
						gama=gamaVehiculo.getSelectedItem().toString();
					}
					
					if(extrasVehiculo.getSelectedItem().toString().contains("GPS")) {
						extraGPS=1;
					}
					if(extrasVehiculo.getSelectedItem().toString().contains("Cadenas")) {
						extraCadenas=1;
					}
					if(extrasVehiculo.getSelectedItem().toString().contains("Asientos")) {
						extraAsientos=1;
					}
					
					dispose();
					Sistema sys=new Sistema();
					ArrayList<Vehiculo> disponibles=new ArrayList<Vehiculo>();
					try {
						disponibles=sys.listarVehiculosDisponiblesPorGama(CrearReserva.fechaIni, CrearReserva.fechaFi, CrearReserva.lugRecogida, gama);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					CrearReserva3 cr3=new CrearReserva3(disponibles);
					cr3.setVisible(true);
				}
				
				
			}
		});
		Siguiente.setText("Siguiente");
		Siguiente.setOpaque(false);
		Siguiente.setHorizontalAlignment(SwingConstants.CENTER);
		Siguiente.setForeground(Color.WHITE);
		Siguiente.setFont(new Font("Open Sans", Font.BOLD, 16));
		Siguiente.setEditable(false);
		Siguiente.setColumns(10);
		Siguiente.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		Siguiente.setBounds(273, 443, 165, 35);
		contentPane.add(Siguiente);
		
		
	}
}
