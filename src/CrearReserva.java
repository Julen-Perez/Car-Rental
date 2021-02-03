import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class CrearReserva extends JFrame {

	public static java.sql.Date fechaIni;
	public static java.sql.Date fechaFi;
	public static String lugRecogida;
	public static String lugEntrega;
	private JPanel contentPane;
	private JTextField fechaInicio;
	private JTextField fechaFin;
	private JTextField txtSiguiente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearReserva frame = new CrearReserva();
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
	public CrearReserva() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearReserva.class.getResource("icons8-car-rental-40.png")));
		setTitle("Realizar Reserva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 750, 550);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Open Sans", Font.PLAIN, 23));
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNuevaReserva = new JLabel("Nueva Reserva");
		lblNuevaReserva.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevaReserva.setForeground(Color.WHITE);
		lblNuevaReserva.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 48));
		lblNuevaReserva.setBounds(90, 29, 536, 48);
		contentPane.add(lblNuevaReserva);

		JLabel lblModelo = new JLabel("Rellene los siguientes campos:");
		lblModelo.setHorizontalAlignment(SwingConstants.CENTER);
		lblModelo.setForeground(Color.WHITE);
		lblModelo.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 25));
		lblModelo.setBounds(25, 120, 388, 48);
		contentPane.add(lblModelo);

		JLabel lblFechaInicio = new JLabel("Fecha Inicio *");
		lblFechaInicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaInicio.setForeground(Color.WHITE);
		lblFechaInicio.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 23));
		lblFechaInicio.setBounds(101, 184, 171, 48);
		contentPane.add(lblFechaInicio);

		JLabel lblFechaFin = new JLabel("Fecha Fin *");
		lblFechaFin.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaFin.setForeground(Color.WHITE);
		lblFechaFin.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 23));
		lblFechaFin.setBounds(451, 184, 148, 48);
		contentPane.add(lblFechaFin);

		JLabel lblLugarRecogida = new JLabel("Lugar Recogida");
		lblLugarRecogida.setHorizontalAlignment(SwingConstants.CENTER);
		lblLugarRecogida.setForeground(Color.WHITE);
		lblLugarRecogida.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 23));
		lblLugarRecogida.setBounds(434, 306, 192, 48);
		contentPane.add(lblLugarRecogida);

		JLabel lblLugar = new JLabel("Lugar Entrega");
		lblLugar.setHorizontalAlignment(SwingConstants.CENTER);
		lblLugar.setForeground(Color.WHITE);
		lblLugar.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 23));
		lblLugar.setBounds(96, 306, 192, 48);
		contentPane.add(lblLugar);

		JLabel lblGrupo = new JLabel("Grupo 28 - IS2");
		lblGrupo.setForeground(Color.WHITE);
		lblGrupo.setFont(new Font("Open Sans", Font.BOLD, 16));
		lblGrupo.setBounds(610, 459, 118, 35);
		contentPane.add(lblGrupo);

		fechaInicio = new JTextField();
		fechaInicio.setColumns(10);
		fechaInicio.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fechaInicio.setBounds(101, 227, 171, 48);
		contentPane.add(fechaInicio);

		fechaFin = new JTextField();
		fechaFin.setColumns(10);
		fechaFin.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fechaFin.setBounds(438, 227, 171, 48);
		contentPane.add(fechaFin);

		JComboBox lugarEntrega = new JComboBox();
		lugarEntrega.setBackground(new Color(70, 130, 180));
		lugarEntrega.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lugarEntrega.setForeground(Color.WHITE);
		lugarEntrega.setFont(new Font("Open Sans", Font.PLAIN, 18));
		lugarEntrega.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lugarEntrega.setModel(new DefaultComboBoxModel(new String[] {"Cualquiera", "Barcelona", "Madrid ", "Malaga", "Santander", "Badajoz"}));
		lugarEntrega.setMaximumRowCount(5);
		lugarEntrega.setBounds(101, 352, 171, 48);
		contentPane.add(lugarEntrega);

		JComboBox lugarRecogida = new JComboBox();
		lugarRecogida.setModel(new DefaultComboBoxModel(new String[] {"Cualquiera", "Barcelona", "Madrid", "Malaga", "Santander", "Badajoz"}));
		lugarRecogida.setMaximumRowCount(5);
		lugarRecogida.setForeground(Color.WHITE);
		lugarRecogida.setFont(new Font("Open Sans", Font.PLAIN, 18));
		lugarRecogida.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lugarRecogida.setBackground(new Color(70, 130, 180));
		lugarRecogida.setBounds(444, 352, 171, 48);
		contentPane.add(lugarRecogida);

		JLabel lblCampo = new JLabel("* - Campo Obligatorio");
		lblCampo.setForeground(Color.WHITE);
		lblCampo.setFont(new Font("Open Sans", Font.BOLD, 13));
		lblCampo.setBounds(15, 461, 163, 35);
		contentPane.add(lblCampo);

		JLabel CorrectInicio = new JLabel("");
		CorrectInicio.setForeground(Color.WHITE);
		CorrectInicio.setFont(new Font("Open Sans", Font.PLAIN, 11));
		CorrectInicio.setBounds(55, 277, 290, 27);
		contentPane.add(CorrectInicio);

		JLabel CorrectFin = new JLabel("");
		CorrectFin.setForeground(Color.WHITE);
		CorrectFin.setFont(new Font("Open Sans", Font.PLAIN, 11));
		CorrectFin.setBounds(434, 277, 279, 27);
		contentPane.add(CorrectFin);

		txtSiguiente = new JTextField();
		txtSiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				boolean correcto=true;
				SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
				Date dateInicio=null;
				
				java.util.Date date =new java.util.Date();
				Date fecha_sistema=new Date(date.getTime());
				
				try {
					formatoFecha.setLenient(false);
					dateInicio= new Date(formatoFecha.parse(fechaInicio.getText()).getTime());
				} catch(ParseException e) {
					correcto=false;
					CorrectInicio.setText("Formato Incorrecto");
				}
				if(fechaInicio.getText().equals("")) {
					correcto=false;
					CorrectInicio.setText("Rellene el campo indicado");

				}
				Date dateFin=null;
				try {
					formatoFecha.setLenient(false);
					dateFin= new Date(formatoFecha.parse(fechaFin.getText()).getTime());
				} catch(ParseException e) {
					correcto=false;
					CorrectFin.setText("Formato Incorrecto");
				}
				if(fechaFin.getText().equals("")) {
					correcto=false;
					CorrectFin.setText("Rellene el campo indicado");
				}
				if(correcto) {
					if(dateFin.getTime() <= dateInicio.getTime()) {
						CorrectFin.setText("La fecha de Fin es anterior que la de Inicio");	
						CorrectInicio.setText("La fecha de Fin es anterior que la de Inicio");	
					}
					else if(fecha_sistema.getTime()>dateInicio.getTime()){
						CorrectInicio.setText("La fecha de Inicio es anterior a la actual");	
					}
					else {
						fechaIni=dateInicio;
						fechaFi=dateFin;
						if(lugarRecogida.getSelectedItem().toString().equals("Cualquiera")) {
							lugRecogida=null;
						}
						else {
							lugRecogida=lugarRecogida.getSelectedItem().toString();
						}
						
						if(lugarEntrega.getSelectedItem().toString().equals("Cualquiera")) {
							lugEntrega=null;
						}
						else {
							lugEntrega=lugarEntrega.getSelectedItem().toString();
						}

						dispose();
						CrearReserva2 cr2= new CrearReserva2();
						cr2.setVisible(true);
					}
				}
			}
		});
		txtSiguiente.setText("Siguiente");
		txtSiguiente.setOpaque(false);
		txtSiguiente.setHorizontalAlignment(SwingConstants.CENTER);
		txtSiguiente.setForeground(Color.WHITE);
		txtSiguiente.setFont(new Font("Open Sans", Font.BOLD, 16));
		txtSiguiente.setEditable(false);
		txtSiguiente.setColumns(10);
		txtSiguiente.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		txtSiguiente.setBounds(280, 443, 165, 35);
		contentPane.add(txtSiguiente);
		
		JLabel lblFechaInicio_1 = new JLabel("Formato fecha dd-mm-yyyy");
		lblFechaInicio_1.setVerticalAlignment(SwingConstants.TOP);
		lblFechaInicio_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaInicio_1.setForeground(Color.WHITE);
		lblFechaInicio_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		lblFechaInicio_1.setBounds(261, 181, 184, 48);
		contentPane.add(lblFechaInicio_1);


	}
}
