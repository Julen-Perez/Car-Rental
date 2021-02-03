import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proyecto_IS2.IdReservaDoesNotExist;
import proyecto_IS2.Sistema;
import proyecto_IS2.UnauthorizedException;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class ModificarReserva2 extends JFrame {

	public static String metodoPag=null;
	public static int seguro=-1;
	public static String marca=null;
	public static String modelo=null;
	public static int extraGPS=-1;
	public static int extraCadenas=-1;
	public static int extraAsientos=-1;
	private JPanel contentPane;
	private JTextField Siguiente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarReserva2 frame = new ModificarReserva2();
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
	public ModificarReserva2() {
		setTitle("Modificar Reserva");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificarReserva2.class.getResource("icons8-car-rental-40.png")));
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
		
		JLabel lblMtodoPago_1 = new JLabel("Metodo Pago ");
		lblMtodoPago_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMtodoPago_1.setForeground(Color.WHITE);
		lblMtodoPago_1.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 23));
		lblMtodoPago_1.setBounds(42, 131, 192, 48);
		contentPane.add(lblMtodoPago_1);
		
		JComboBox metodoPago = new JComboBox();
		metodoPago.setModel(new DefaultComboBoxModel(new String[] {"Sin Cambio", "Efectivo", "Tarjeta"}));
		metodoPago.setOpaque(false);
		metodoPago.setMaximumRowCount(5);
		metodoPago.setForeground(Color.WHITE);
		metodoPago.setFont(new Font("Open Sans", Font.PLAIN, 16));
		metodoPago.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		metodoPago.setBackground(new Color(70, 130, 180));
		metodoPago.setBounds(52, 174, 171, 48);
		contentPane.add(metodoPago);
		
		JLabel lblSeguro_1 = new JLabel("Seguro ");
		lblSeguro_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeguro_1.setForeground(Color.WHITE);
		lblSeguro_1.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 23));
		lblSeguro_1.setBounds(47, 239, 176, 35);
		contentPane.add(lblSeguro_1);
		
		JComboBox seguroVehiculo = new JComboBox();
		seguroVehiculo.setModel(new DefaultComboBoxModel(new String[] {"Sin Cambio", "Basico", "Premium"}));
		seguroVehiculo.setMaximumRowCount(5);
		seguroVehiculo.setForeground(Color.WHITE);
		seguroVehiculo.setFont(new Font("Open Sans", Font.PLAIN, 16));
		seguroVehiculo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		seguroVehiculo.setBackground(new Color(70, 130, 180));
		seguroVehiculo.setBounds(52, 274, 171, 48);
		contentPane.add(seguroVehiculo);
		
		JLabel lblMarcaYModelo = new JLabel("Marca y Modelo");
		lblMarcaYModelo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarcaYModelo.setForeground(Color.WHITE);
		lblMarcaYModelo.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 23));
		lblMarcaYModelo.setBounds(442, 236, 209, 40);
		contentPane.add(lblMarcaYModelo);
		
		JComboBox marcaModelo = new JComboBox();
		marcaModelo.setModel(new DefaultComboBoxModel(new String[] {"Sin Cambio", "Toyota Yaris", "Seat Ibiza", "Renault Clio", "Volskwagen Polo", "Toyota Corolla", "Seat Leon", "Renault Megane", "Volkswagen Golf", "Toyota Rav-4", "Seat Tarraco", "Renault Espace", "Volkswagen Tuareg"}));
		marcaModelo.setMaximumRowCount(5);
		marcaModelo.setForeground(Color.WHITE);
		marcaModelo.setFont(new Font("Open Sans", Font.PLAIN, 16));
		marcaModelo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		marcaModelo.setBackground(new Color(70, 130, 180));
		marcaModelo.setBounds(460, 274, 171, 48);
		contentPane.add(marcaModelo);
		
		JLabel lblGrupo = new JLabel("Grupo 28 - IS2");
		lblGrupo.setForeground(Color.WHITE);
		lblGrupo.setFont(new Font("Open Sans", Font.BOLD, 16));
		lblGrupo.setBounds(610, 459, 118, 35);
		contentPane.add(lblGrupo);
		
		JComboBox extrasVehiculo = new JComboBox();
		extrasVehiculo.setModel(new DefaultComboBoxModel(new String[] {"Sin Cambio", "Ninguno", "Navegacion GPS", "Asientos de Bebe", "Cadenas de Nieve", "Cadenas + GPS", "Cadenas + Asientos ", "Asientos + GPS", "Cadenas + GPS + Asientos"}));
		extrasVehiculo.setMaximumRowCount(5);
		extrasVehiculo.setForeground(Color.WHITE);
		extrasVehiculo.setFont(new Font("Open Sans", Font.PLAIN, 12));
		extrasVehiculo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		extrasVehiculo.setBackground(new Color(70, 130, 180));
		extrasVehiculo.setBounds(460, 174, 171, 48);
		contentPane.add(extrasVehiculo);
		
		Siguiente = new JTextField();
		Siguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!metodoPago.getSelectedItem().toString().equals("Sin Cambio")) {
					metodoPag=metodoPago.getSelectedItem().toString();
				}
				if(!seguroVehiculo.getSelectedItem().toString().equals("Sin Cambio")) {
					if(seguroVehiculo.getSelectedItem().toString().equals("Basico")) {
						seguro=1;
					}
					else {
						seguro=2;
					}
						
				}
				if(!marcaModelo.getSelectedItem().toString().equals("Sin Cambio")) {
					switch(marcaModelo.getSelectedItem().toString()) {
						case "Toyota Yaris": marca="Toyota"; modelo="Yaris";
						break;
						case "Seat Ibiza": marca="Seat"; modelo="Ibiza";
						break;
						case "Volkswagen Polo": marca="Volkswagen"; modelo="Polo";
						break;
						case "Renault Clio": marca="Renault"; modelo="Clio";
						break;
						case "Toyota Corolla": marca="Toyota"; modelo="Corolla";
						break;
						case "Seat Leon": marca="Seat"; modelo="Leon";
						break;
						case "Volkswagen Golf": marca="Volkswagen"; modelo="Golf";
						break;
						case "Renault Megane": marca="Renault"; modelo="Megane";
						break;
						case "Toyota Rav-4": marca="Toyota"; modelo="Rav-4";
						break;
						case "Seat Tarraco": marca="Seat"; modelo="Tarraco";
						break;
						case "Volkswagen Tuareg": marca="Volkswagen"; modelo="Tuareg";
						break;
						case "Renault Espace": marca="Renault"; modelo="Espace";
						break;
						}
				}
				if(!extrasVehiculo.getSelectedItem().toString().equals("Sin Cambio")) {
					if(extrasVehiculo.getSelectedItem().toString().equals("Ninguno")) {
						extraGPS=0; extraCadenas=0; extraAsientos=0;
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
				}
				int reply=JOptionPane.showConfirmDialog(null, "         Es posible que la operacion suponga gastos extra:   ¿Desea continuar?","Confirmacion",JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					Sistema sys= new Sistema();
					try {
						if(sys.comprobarPropietarioDeLaReserva(ModificarReserva.id,PantallaInicio.dni)) {
						double modificada=sys.modificarReserva(ModificarReserva.id, ModificarReserva.fechaIni, ModificarReserva.fechaFi, PantallaInicio.dni, metodoPag, ModificarReserva.lugRecogida, ModificarReserva.lugEntrega, marca, modelo, extraGPS, extraCadenas, extraAsientos,seguro);
						if(modificada!=-1) {
							JOptionPane.showMessageDialog(null, "       Reserva Modificada Con exito, coste de la operación: "+modificada, "Mensaje Mofificar Reserva", JOptionPane.INFORMATION_MESSAGE);
								}
						else  {
							int reply1=JOptionPane.showConfirmDialog(null, "            La reserva no se pudo modificar con las nuevas especificaciones, ¿Desea cancelar la antigua reserva? (Es posible que conlleve penalicacion)","Cancelacion", JOptionPane.YES_NO_OPTION);
							
							if (reply1== JOptionPane.YES_OPTION){
								int reply2=JOptionPane.showConfirmDialog(null, "          ¿Esta seguro?","Confirmacion",JOptionPane.YES_NO_OPTION);
								if (reply2== JOptionPane.YES_OPTION) {
									double cancelacion = sys.cancelarReserva(ModificarReserva.id);
									if(cancelacion !=-1) {
										JOptionPane.showMessageDialog(null, "       Reserva cancelada con exito, coste de la operación: "+cancelacion, "Mensaje Mofificar Reserva", JOptionPane.INFORMATION_MESSAGE);
									}
									
								}
							}
							
						}
						}else {
							JOptionPane.showMessageDialog(null, "      Usuario identificado no es el propietario de la reserva", "Mensaje Mofificar Reserva", JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (UnauthorizedException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "El usuario dado de alta no es el propietario de la reserva");
						e1.printStackTrace();
					} catch (IdReservaDoesNotExist e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "El id de la reserva no existe");
						
						e1.printStackTrace();
					}
					/* 
					 * Hacer el UPDATE en RESERVA
					 * 
					 * Indicar mensaje de Error si hubiese algun problema
					 */ catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				} 
				
				
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
		Siguiente.setBounds(263, 443, 165, 35);
		contentPane.add(Siguiente);
		
		JLabel lblEliminarExtras = new JLabel("Extras");
		lblEliminarExtras.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarExtras.setForeground(Color.WHITE);
		lblEliminarExtras.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 23));
		lblEliminarExtras.setBounds(455, 139, 176, 32);
		contentPane.add(lblEliminarExtras);	
		
	}
}
