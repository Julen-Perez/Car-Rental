import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Toolkit;
import javax.swing.border.SoftBevelBorder;

import proyecto_IS2.Sistema;

public class PantallaInicio extends JFrame {
	public static String dni;
	private JPanel contentPane;
	private JTextField DNI;
	private JTextField txtLogin;
	private JTextField txtCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					PantallaInicio frame = new PantallaInicio();

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
	public PantallaInicio() {
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaInicio.class.getResource("icons8-car-rental-40.png")));
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 750, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAlquilerDeCoches = new JLabel("Alquiler de Coches");
		lblAlquilerDeCoches.setForeground(new Color(255, 255, 255));
		lblAlquilerDeCoches.setBounds(159, 28, 536, 48);
		lblAlquilerDeCoches.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 48));
		contentPane.add(lblAlquilerDeCoches);

		JLabel lblGrupo = new JLabel("Grupo 28 - IS2");
		lblGrupo.setForeground(new Color(255, 255, 255));
		lblGrupo.setFont(new Font("Open Sans", Font.BOLD, 16));
		lblGrupo.setBounds(611, 474, 117, 20);
		contentPane.add(lblGrupo);

		JLabel lblNombreCliente = new JLabel("DNI/CIF:");
		lblNombreCliente.setForeground(new Color(255, 255, 255));
		lblNombreCliente.setFont(new Font("Open Sans", Font.PLAIN, 17));
		lblNombreCliente.setBounds(103, 279, 86, 20);
		contentPane.add(lblNombreCliente);

		DNI = new JTextField();
		DNI.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		DNI.setColumns(10);
		DNI.setBounds(203, 269, 345, 65);
		contentPane.add(DNI);

		JLabel Login = new JLabel("LOGIN");
		Login.setForeground(new Color(255, 255, 255));
		Login.setFont(new Font("Open Sans", Font.BOLD, 20));
		Login.setBounds(319, 233, 79, 20);
		contentPane.add(Login);

		JLabel CorrectLogin = new JLabel("");
		CorrectLogin.setFont(new Font("Open Sans", Font.PLAIN, 16));
		CorrectLogin.setForeground(new Color(255, 255, 255));
		CorrectLogin.setBounds(203, 330, 345, 27);
		contentPane.add(CorrectLogin);

		txtLogin = new JTextField();
		txtLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!DNI.getText().equals("") && (DNI.getText().matches("\\d{8}[A-HJ-NP-TV-Z]") && DNI.getText().length()==9) || (DNI.getText().matches("[A-HJ-NP-TV-Z]\\d{8}")) ) {
					dni=DNI.getText();
					Sistema sys =new Sistema();
					try {
						if(!sys.dniEnBD(dni)) {
							CorrectLogin.setText("Dni no dado de alta en la Base de Datos");
						}
						else { 
							JOptionPane.showMessageDialog(null, "            Login Correcto", "Mensaje Login", JOptionPane.INFORMATION_MESSAGE);
							dispose();
							OperationsFrame of=new OperationsFrame();
							of.setVisible(true);
						}
					} catch (HeadlessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else  
				{
					CorrectLogin.setText("DNI/CIF invalido");
				}

			}
		});
		txtLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtLogin.setForeground(new Color(255, 255, 255));
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setFont(new Font("Open Sans", Font.BOLD, 16));
		txtLogin.setText("LOGIN");
		txtLogin.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		txtLogin.setOpaque(false);
		txtLogin.setEditable(false);
		txtLogin.setColumns(10);
		txtLogin.setBounds(203, 373, 165, 48);
		contentPane.add(txtLogin);

		txtCerrar = new JTextField();
		txtCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		txtCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtCerrar.setForeground(new Color(255, 255, 255));
		txtCerrar.setText("CERRAR");
		txtCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		txtCerrar.setFont(new Font("Open Sans", Font.PLAIN, 16));
		txtCerrar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		txtCerrar.setEditable(false);
		txtCerrar.setOpaque(false);
		txtCerrar.setColumns(10);
		txtCerrar.setBounds(383, 373, 165, 48);
		contentPane.add(txtCerrar);

		JLabel LogoLogin = new JLabel("");
		LogoLogin.setHorizontalAlignment(SwingConstants.CENTER);
		LogoLogin.setIcon(new ImageIcon(PantallaInicio.class.getResource("/icons8-male-user-40.png")));
		LogoLogin.setBounds(381, 222, 69, 40);
		contentPane.add(LogoLogin);

		JLabel LogoCoche = new JLabel("");
		LogoCoche.setIcon(new ImageIcon(PantallaInicio.class.getResource("icons8-car-rental-80.png")));
		LogoCoche.setBounds(333, 93, 117, 77);
		contentPane.add(LogoCoche);
	}
}
