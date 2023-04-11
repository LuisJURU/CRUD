import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Vista_Ingredientes extends JFrame {

	private JPanel contentPane;
	private JTable Tabla;
	private JTextField txtID;
	private JTextField txtNom;
	private JTextField txtPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista_Ingredientes frame = new Vista_Ingredientes();
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
	public Vista_Ingredientes() {
		setBackground(new Color(0, 0, 64));
		setTitle("Vanilla Sweet");
		
		

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 466);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 254, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 232, 243));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos Ingredientes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 212, 405);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 50, 74, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre:\r\n");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(10, 75, 66, 14);
		panel.add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Precio:\r\n\t\t");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecio.setBounds(10, 100, 74, 14);
		panel.add(lblPrecio);
		
		txtID = new JTextField();
		txtID.setBackground(new Color(255, 185, 220));
		txtID.setBounds(100, 49, 102, 20);
		panel.add(txtID);
		txtID.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setBackground(new Color(255, 185, 220));
		txtNom.setColumns(10);
		txtNom.setBounds(100, 74, 102, 20);
		panel.add(txtNom);
		
		txtPrecio = new JTextField();
		txtPrecio.setBackground(new Color(255, 185, 220));
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(100, 99, 102, 20);
		panel.add(txtPrecio);
		
		JButton btnGuardar = new JButton("GUARDAR\r\n");
		btnGuardar.setBackground(new Color(255, 147, 255));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ingredientes objetIngredientes = new Ingredientes();
				objetIngredientes.insertarIngrediente(txtID, txtNom,txtPrecio);
				objetIngredientes.MostarIngredientes(Tabla);
				
			}
		});
		btnGuardar.setBounds(10, 264, 192, 23);
		panel.add(btnGuardar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBackground(new Color(255, 147, 255));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Ingredientes objetIngredientes = new Ingredientes();
				objetIngredientes.EliminarIngrediente(txtID);
				objetIngredientes.MostarIngredientes(Tabla);
				
			}
			
		});
		
		btnEliminar.setBounds(10, 306, 192, 23);
		panel.add(btnEliminar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBackground(new Color(255, 147, 255));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Ingredientes objetIngredientes = new Ingredientes();
				objetIngredientes.ModificarIngredientes	(txtID, txtNom,txtPrecio);
				objetIngredientes.MostarIngredientes(Tabla);
				
			}
		});
		btnModificar.setBounds(10, 352, 192, 23);
		panel.add(btnModificar);
		
		JButton btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setBackground(new Color(255, 153, 204));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtID.setText(null);
				txtNom.setText(null);
				txtPrecio.setText(null);
				
			}
		});
		btnLimpiar.setBounds(10, 219, 192, 23);
		panel.add(btnLimpiar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(129, 214, 254));
		panel_1.setBorder(new TitledBorder(null, "Listade Ingredientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(232, 11, 402, 405);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
	
		
		Tabla = new JTable();
		Tabla.setBackground(new Color(210, 255, 255));
		Tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Ingredientes objetIngredientes = new Ingredientes();
				objetIngredientes.SelecionarIngrediente(Tabla, txtID, txtNom, txtPrecio);
			}
		});
		Tabla.setBounds(10, 47, 382, 347);
		panel_1.add(Tabla);
		
		
		this.setLocationRelativeTo(null);
		
		Ingredientes objetoIngredientes = new Ingredientes();
		objetoIngredientes.MostarIngredientes(Tabla);
	}
}
