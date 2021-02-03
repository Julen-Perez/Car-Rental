import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proyecto_IS2.IdReservaDoesNotExist;
import proyecto_IS2.Sistema;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class CancelarReserva extends JFrame {
	
	private JPanel contentPane;
	private JTextField idReserva;
	private JTextField Siguiente;
	public static int id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancelarReserva frame = new CancelarReserva();
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
	public CancelarReserva() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CancelarReserva.class.getResource("icons8-car-rental-40.png")));
		setTitle("Cancelar Reserva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 750, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNuevaReserva = new JLabel("Cancelar Reserva");
		lblNuevaReserva.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevaReserva.setForeground(Color.WHITE);
		lblNuevaReserva.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 48));
		lblNuevaReserva.setBounds(90, 29, 536, 48);
		contentPane.add(lblNuevaReserva);
		
		JLabel lblIntroduzcaElId = new JLabel("Introduzca el ID de la reserva que desea cancelar:");
		lblIntroduzcaElId.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduzcaElId.setForeground(Color.WHITE);
		lblIntroduzcaElId.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 23));
		lblIntroduzcaElId.setBounds(27, 114, 599, 48);
		contentPane.add(lblIntroduzcaElId);
		
		JLabel lblIdReserva = new JLabel("ID Reserva *");
		lblIdReserva.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdReserva.setForeground(Color.WHITE);
		lblIdReserva.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 23));
		lblIdReserva.setBounds(292, 208, 146, 48);
		contentPane.add(lblIdReserva);
		
		idReserva = new JTextField();
		idReserva.setColumns(10);
		idReserva.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		idReserva.setBounds(273, 254, 171, 48);
		contentPane.add(idReserva);
		
		JLabel lblCampo = new JLabel("* - Campo Obligatorio");
		lblCampo.setForeground(Color.WHITE);
		lblCampo.setFont(new Font("Open Sans", Font.BOLD, 13));
		lblCampo.setBounds(15, 459, 163, 35);
		contentPane.add(lblCampo);
		
		JLabel lblGrupo = new JLabel("Grupo 28 - IS2");
		lblGrupo.setForeground(Color.WHITE);
		lblGrupo.setFont(new Font("Open Sans", Font.BOLD, 16));
		lblGrupo.setBounds(610, 459, 118, 35);
		contentPane.add(lblGrupo);
		
		JLabel CorrectID = new JLabel("");
		CorrectID.setForeground(Color.WHITE);
		CorrectID.setFont(new Font("Open Sans", Font.PLAIN, 16));
		CorrectID.setBounds(248, 303, 248, 27);
		contentPane.add(CorrectID);
		
		Siguiente = new JTextField();
		Siguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				boolean correcto=true;
				
				/*
				 * Habria que comprobar tb si el ID que mete es correcto
				 */
				
				if (!idReserva.getText().equals("")) {
					correcto=true;
					CorrectID.setText("");
				}
				
				if(idReserva.getText().equals("")) {
					correcto=false;
					CorrectID.setText("Rellene el campo indicado");
					
				}
			
				double sol=0;
				if(correcto) {
					id=Integer.parseInt(idReserva.getText());
					int reply=JOptionPane.showConfirmDialog(null, "         ¿Esta seguro? Esta operación puede suponer un recargo","Confirmacion",JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						
						Sistema sys=new Sistema();
						try {
							if(sys.comprobarPropietarioDeLaReserva(id,PantallaInicio.dni)) {
							sol=sys.cancelarReserva(Integer.parseInt(idReserva.getText()));
							JOptionPane.showMessageDialog(null, "        Reserva Cancelada Con exito con recargo: "+sol, "Mensaje Login", JOptionPane.INFORMATION_MESSAGE);
						}
							else {
								JOptionPane.showMessageDialog(null, "      Usuario identificado no es el propietario de la reserva", "Mensaje Login", JOptionPane.INFORMATION_MESSAGE);
							}
					}
						catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IdReservaDoesNotExist e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "El id de la reserva no existe");
							e.printStackTrace();
							
						} catch (SQLException e) {
						
							e.printStackTrace();
						}
						
					} 
					
					dispose();
					OperationsFrame of=new OperationsFrame();
					of.setVisible(true);
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
