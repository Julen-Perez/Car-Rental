import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.ImageIcon;

public class OperationsFrame extends JFrame {

	private JPanel contentPane;
	private final JLabel lblGrupo = new JLabel("Grupo 28 - IS2");
	private JTextField txtRealizarUnaReserva;
	private JTextField txtCancelarUnaReserva;
	private JTextField txtModificarUnaReserva;
	private JLabel lblProximamente;
	private JLabel LogoObra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperationsFrame frame = new OperationsFrame();
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
	public OperationsFrame() {
		setFont(new Font("Open Sans", Font.BOLD, 12));
		setTitle("Operaciones");
		setIconImage(Toolkit.getDefaultToolkit().getImage(OperationsFrame.class.getResource("icons8-car-rental-40.png")));
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 750, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblGrupo.setBounds(610, 459, 118, 35);
		contentPane.add(lblGrupo);
		lblGrupo.setForeground(Color.WHITE);
		lblGrupo.setFont(new Font("Open Sans", Font.BOLD, 16));
		
		JLabel lblOperaciones = new JLabel("Operaciones");
		lblOperaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperaciones.setForeground(Color.WHITE);
		lblOperaciones.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 48));
		lblOperaciones.setBounds(98, 40, 536, 48);
		contentPane.add(lblOperaciones);
		
		txtRealizarUnaReserva = new JTextField();
		txtRealizarUnaReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				CrearReserva cr=new CrearReserva();
				cr.setVisible(true);
			}
		});
		txtRealizarUnaReserva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtRealizarUnaReserva.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		txtRealizarUnaReserva.setOpaque(false);
		txtRealizarUnaReserva.setEditable(false);
		txtRealizarUnaReserva.setText("Realizar una Reserva");
		txtRealizarUnaReserva.setForeground(new Color(255, 255, 255));
		txtRealizarUnaReserva.setFont(new Font("Open Sans", Font.BOLD, 16));
		txtRealizarUnaReserva.setHorizontalAlignment(SwingConstants.CENTER);
		txtRealizarUnaReserva.setBounds(232, 125, 275, 48);
		contentPane.add(txtRealizarUnaReserva);
		txtRealizarUnaReserva.setColumns(10);
		
		txtCancelarUnaReserva = new JTextField();
		txtCancelarUnaReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				CancelarReserva car=new CancelarReserva();
				car.setVisible(true);
				
			}
		});
		txtCancelarUnaReserva.setText("Cancelar una Reserva");
		txtCancelarUnaReserva.setOpaque(false);
		txtCancelarUnaReserva.setHorizontalAlignment(SwingConstants.CENTER);
		txtCancelarUnaReserva.setForeground(Color.WHITE);
		txtCancelarUnaReserva.setFont(new Font("Open Sans", Font.BOLD, 16));
		txtCancelarUnaReserva.setEditable(false);
		txtCancelarUnaReserva.setColumns(10);
		txtCancelarUnaReserva.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		txtCancelarUnaReserva.setBounds(232, 189, 275, 48);
		contentPane.add(txtCancelarUnaReserva);
		
		txtModificarUnaReserva = new JTextField();
		txtModificarUnaReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				ModificarReserva mr=new ModificarReserva();
				mr.setVisible(true);
			}
		});
		txtModificarUnaReserva.setText("Modificar una Reserva");
		txtModificarUnaReserva.setOpaque(false);
		txtModificarUnaReserva.setHorizontalAlignment(SwingConstants.CENTER);
		txtModificarUnaReserva.setForeground(Color.WHITE);
		txtModificarUnaReserva.setFont(new Font("Open Sans", Font.BOLD, 16));
		txtModificarUnaReserva.setEditable(false);
		txtModificarUnaReserva.setColumns(10);
		txtModificarUnaReserva.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		txtModificarUnaReserva.setBounds(232, 254, 275, 48);
		contentPane.add(txtModificarUnaReserva);
		
		lblProximamente = new JLabel("Proximamente");
		lblProximamente.setHorizontalAlignment(SwingConstants.CENTER);
		lblProximamente.setForeground(Color.WHITE);
		lblProximamente.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 23));
		lblProximamente.setBounds(64, 330, 599, 48);
		contentPane.add(lblProximamente);
		
		LogoObra = new JLabel("");
		LogoObra.setIcon(new ImageIcon(OperationsFrame.class.getResource("icons8-construction-80.png")));
		LogoObra.setBounds(323, 373, 87, 80);
		contentPane.add(LogoObra);
	}
}
