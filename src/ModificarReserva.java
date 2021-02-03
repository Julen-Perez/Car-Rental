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
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;

public class ModificarReserva extends JFrame {
	public static int id;
	public static java.sql.Date fechaIni=null;
	public static java.sql.Date fechaFi=null;
	public static String lugEntrega=null;
	public static String lugRecogida=null;

	private JPanel contentPane;
	private JTextField idReserva;
	private JTextField fechaInicio;
	private JTextField fechaFin;
	private JTextField Siguiente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarReserva frame = new ModificarReserva();
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
	public ModificarReserva() {
		setTitle("Modificar Reserva");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificarReserva.class.getResource("icons8-car-rental-40.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 750, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNuevaReserva = new JLabel("Modificar Reserva");
		lblNuevaReserva.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevaReserva.setForeground(Color.WHITE);
		lblNuevaReserva.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 48));
		lblNuevaReserva.setBounds(90, 29, 536, 48);
		contentPane.add(lblNuevaReserva);

		JLabel lblRelleneLosCampos = new JLabel("Rellene los siguientes campos:");
		lblRelleneLosCampos.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelleneLosCampos.setForeground(Color.WHITE);
		lblRelleneLosCampos.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 23));
		lblRelleneLosCampos.setBounds(-74, 116, 599, 48);
		contentPane.add(lblRelleneLosCampos);

		JLabel lblIdReserva = new JLabel("ID Reserva *");
		lblIdReserva.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdReserva.setForeground(Color.WHITE);
		lblIdReserva.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 23));
		lblIdReserva.setBounds(37, 180, 146, 48);
		contentPane.add(lblIdReserva);

		idReserva = new JTextField();
		idReserva.setColumns(10);
		idReserva.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		idReserva.setBounds(25, 223, 171, 48);
		contentPane.add(idReserva);

		JLabel lblCampo = new JLabel("* - Campo Obligatorio");
		lblCampo.setForeground(Color.WHITE);
		lblCampo.setFont(new Font("Open Sans", Font.BOLD, 13));
		lblCampo.setBounds(25, 459, 163, 35);
		contentPane.add(lblCampo);

		JLabel lblFechaInicio_1 = new JLabel("Fecha Inicio #");
		lblFechaInicio_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaInicio_1.setForeground(Color.WHITE);
		lblFechaInicio_1.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 23));
		lblFechaInicio_1.setBounds(264, 180, 171, 48);
		contentPane.add(lblFechaInicio_1);

		JLabel lblFechaFin_1 = new JLabel("Fecha Fin #");
		lblFechaFin_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaFin_1.setForeground(Color.WHITE);
		lblFechaFin_1.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 23));
		lblFechaFin_1.setBounds(523, 180, 148, 48);
		contentPane.add(lblFechaFin_1);

		fechaInicio = new JTextField();
		fechaInicio.setColumns(10);
		fechaInicio.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fechaInicio.setBounds(264, 223, 171, 48);
		contentPane.add(fechaInicio);

		fechaFin = new JTextField();
		fechaFin.setColumns(10);
		fechaFin.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fechaFin.setBounds(511, 223, 171, 48);
		contentPane.add(fechaFin);

		JLabel lblLugar = new JLabel("Lugar Entrega");
		lblLugar.setHorizontalAlignment(SwingConstants.CENTER);
		lblLugar.setForeground(Color.WHITE);
		lblLugar.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 23));
		lblLugar.setBounds(127, 318, 192, 48);
		contentPane.add(lblLugar);

		JLabel lblLugarRecogida = new JLabel("Lugar Recogida");
		lblLugarRecogida.setHorizontalAlignment(SwingConstants.CENTER);
		lblLugarRecogida.setForeground(Color.WHITE);
		lblLugarRecogida.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 23));
		lblLugarRecogida.setBounds(398, 318, 192, 48);
		contentPane.add(lblLugarRecogida);

		JComboBox lugarEntrega = new JComboBox();
		lugarEntrega.setModel(new DefaultComboBoxModel(new String[] {"Sin Cambio", "Barcelona", "Madrid ", "Malaga", "Santander", "Badajoz"}));
		lugarEntrega.setMaximumRowCount(5);
		lugarEntrega.setForeground(Color.WHITE);
		lugarEntrega.setFont(new Font("Open Sans", Font.PLAIN, 18));
		lugarEntrega.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lugarEntrega.setBackground(new Color(70, 130, 180));
		lugarEntrega.setBounds(137, 362, 171, 48);
		contentPane.add(lugarEntrega);

		JComboBox lugarRecogida = new JComboBox();
		lugarRecogida.setModel(new DefaultComboBoxModel(new String[] {"Sin Cambio", "Barcelona", "Madrid ", "Malaga", "Santander", "Badajoz"}));
		lugarRecogida.setMaximumRowCount(5);
		lugarRecogida.setForeground(Color.WHITE);
		lugarRecogida.setFont(new Font("Open Sans", Font.PLAIN, 18));
		lugarRecogida.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lugarRecogida.setBackground(new Color(70, 130, 180));
		lugarRecogida.setBounds(408, 362, 171, 48);
		contentPane.add(lugarRecogida);

		JLabel CorrectID = new JLabel("");
		CorrectID.setForeground(Color.WHITE);
		CorrectID.setFont(new Font("Open Sans", Font.PLAIN, 16));
		CorrectID.setBounds(25, 272, 248, 27);
		contentPane.add(CorrectID);

		JLabel CorrectInicio = new JLabel("");
		CorrectInicio.setForeground(Color.WHITE);
		CorrectInicio.setFont(new Font("Dialog", Font.PLAIN, 12));
		CorrectInicio.setBounds(262, 272, 248, 27);
		contentPane.add(CorrectInicio);

		JLabel CorrectFin = new JLabel("");
		CorrectFin.setForeground(Color.WHITE);
		CorrectFin.setFont(new Font("Dialog", Font.PLAIN, 12));
		CorrectFin.setBounds(510, 272, 248, 27);
		contentPane.add(CorrectFin);

		Siguiente = new JTextField();
		Siguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean correcto=true;
				if(idReserva.getText().equals("")) {
					correcto=false;
					CorrectID.setText("Rellene el campo indicado");

				}
				id=Integer.parseInt(idReserva.getText());
				/*
				 * TODO: Comprobar si existe la reserva
				 */
				if(!lugarEntrega.getSelectedItem().toString().equals("Sin Cambio")) {
					lugEntrega=lugarEntrega.getSelectedItem().toString();
				}
				if(!lugarRecogida.getSelectedItem().toString().equals("Sin Cambio")) {
					lugRecogida=lugarRecogida.getSelectedItem().toString();
				}
				System.out.println(lugRecogida);
				SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
			

				java.util.Date date =new java.util.Date();
				Date fecha_sistema=new Date(date.getTime());
				/*
				 * TODO: Comprobar si la fecha Inicio introducida es < que la Final y > que la Anterior de Inicio
				 */
				if(!fechaInicio.getText().equals("") && !fechaFin.getText().equals("")) {
					try {
						formatoFecha.setLenient(false);
						fechaIni= new Date(formatoFecha.parse(fechaInicio.getText()).getTime());
						
					}catch(ParseException q) {
						correcto=false;
						CorrectInicio.setText("Formato Incorrecto");
					}
				
					try {
						formatoFecha.setLenient(false);
						fechaFi= new Date(formatoFecha.parse(fechaFin.getText()).getTime());
					} catch(ParseException q) {
						correcto=false;
						CorrectFin.setText("Formato Incorrecto");
					}

					if(correcto) {
						LocalDate fechaFiLocal= fechaFi.toLocalDate();
						LocalDate fechaIniLocal= fechaIni.toLocalDate();
						Duration diasEntreFechas = Duration.between(fechaIniLocal.atStartOfDay(), 
								fechaFiLocal.atStartOfDay());
						System.out.println(diasEntreFechas.toDays());
						Duration diasDesdeHoy = Duration.between(LocalDate.now().atStartOfDay(), 
								fechaIniLocal.atStartOfDay());
						System.out.println(diasDesdeHoy.toDays());
						if(diasEntreFechas.toDays()<=0) {
							CorrectFin.setText("La fecha de Fin es anterior a la de Inicio");	
							CorrectInicio.setText("La fecha de Fin es anterior a la de Inicio");
							correcto=false;
						}
						else if(diasDesdeHoy.toDays()<=0){
							CorrectInicio.setText("La fecha de Inicio es anterior a la actual");	
							correcto=false;
						}
					}
				}
				else if(!fechaInicio.getText().equals("") || !fechaFin.getText().equals("")) {
					correcto=false;
					CorrectFin.setText("Debe introducir ambas fechas");	
					CorrectInicio.setText("Debe introducir ambas fechas");
				}
				else{
					fechaFi=null;
					fechaIni=null;
				}
				

				

				
				if(correcto) {
					dispose();
					ModificarReserva2 mr2= new ModificarReserva2();
					mr2.setVisible(true);
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
		Siguiente.setBounds(281, 443, 165, 35);
		contentPane.add(Siguiente);

		JLabel lblGrupo = new JLabel("Grupo 28 - IS2");
		lblGrupo.setForeground(Color.WHITE);
		lblGrupo.setFont(new Font("Open Sans", Font.BOLD, 16));
		lblGrupo.setBounds(610, 459, 118, 35);
		contentPane.add(lblGrupo);

		JLabel lblSi = new JLabel("# - Si se rellena un campo, es obligatorio rellenar el otro");
		lblSi.setForeground(Color.WHITE);
		lblSi.setFont(new Font("Open Sans", Font.BOLD, 10));
		lblSi.setBounds(436, 128, 292, 35);
		contentPane.add(lblSi);
		
		JLabel lblFechaInicio_1_1 = new JLabel("Formato dd-mm-yyyy");
		lblFechaInicio_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblFechaInicio_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaInicio_1_1.setForeground(Color.WHITE);
		lblFechaInicio_1_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		lblFechaInicio_1_1.setBounds(371, 161, 185, 27);
		contentPane.add(lblFechaInicio_1_1);
	}
}
