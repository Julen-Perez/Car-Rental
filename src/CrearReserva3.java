import java.awt.BorderLayout;
import proyecto_IS2.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class CrearReserva3 extends JFrame {

	private JPanel contentPane;
	private JTextField Siguiente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					CrearReserva3 frame = new CrearReserva3(new ArrayList<Vehiculo>());
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
	public CrearReserva3(ArrayList<Vehiculo> vehiculosDisponibles) {
		setTitle("Realizar Reserva");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearReserva3.class.getResource("icons8-car-rental-40.png")));
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
		
		JLabel lblListaDeVehculos = new JLabel("Lista de Vehiculos Disponibles (Seleccione Uno):");
		lblListaDeVehculos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeVehculos.setForeground(Color.WHITE);
		lblListaDeVehculos.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 25));
		lblListaDeVehculos.setBounds(50, 113, 599, 48);
		contentPane.add(lblListaDeVehculos);
		
		JComboBox vehiculosDisp = new JComboBox();
		vehiculosDisp.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		vehiculosDisp.setBackground(new Color(70, 130, 180));
		vehiculosDisp.setForeground(new Color(255, 255, 255));
		vehiculosDisp.setFont(new Font("Open Sans", Font.PLAIN, 14));
		vehiculosDisp.setBounds(50, 168, 599, 26);
		for(int i=0;i<vehiculosDisponibles.size();i++) {
			vehiculosDisp.addItem(vehiculosDisponibles.get(i));
		}
		contentPane.add(vehiculosDisp);
		
		Siguiente = new JTextField();
		Siguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int reply=JOptionPane.showConfirmDialog(null, "      ¿Esta seguro?","Confirmacion",JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					Vehiculo vehi=(Vehiculo)vehiculosDisp.getSelectedItem();
					Sistema sys=new Sistema();
					try {
						if(!sys.crearReserva(PantallaInicio.dni, CrearReserva.fechaIni,  CrearReserva.fechaFi,  vehi.getFranquicia(),  vehi.getFranquicia(), vehi.getMatricula(), CrearReserva2.seguro, CrearReserva2.extraGPS, CrearReserva2.extraCadenas, CrearReserva2.extraAsientos, CrearReserva2.metodoPag, CrearReserva2.nTarjeta)) {
							JOptionPane.showMessageDialog(null, "       Error al realizar la reserva", "Mensaje Reserva", JOptionPane.INFORMATION_MESSAGE);
							
						}
						else {
						JOptionPane.showMessageDialog(null, "        Reserva Realizada Con exito, ID de la reserva: "+sys.id_reserva_generado, "Mensaje Reserva", JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					/* 
					 * Hacer el INSERT en RESERVA
					 */
				} 
			//TODO
				
				dispose();
				OperationsFrame of=new OperationsFrame();
				of.setVisible(true);
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
		Siguiente.setBounds(284, 443, 165, 35);
		contentPane.add(Siguiente);
		
		JLabel lblGrupo = new JLabel("Grupo 28 - IS2");
		lblGrupo.setForeground(Color.WHITE);
		lblGrupo.setFont(new Font("Open Sans", Font.BOLD, 16));
		lblGrupo.setBounds(610, 459, 118, 35);
		contentPane.add(lblGrupo);
	}
}
