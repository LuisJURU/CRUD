import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ingredientes {

	private int ID;
	private String Nombres;
	private float Precio;
	
	
	public int getID() {
		return ID;
	}
	public void setID(int id) {
		ID = id;
	}
	public String getNombres() {
		return Nombres;
	}
	public void setNombres(String nombres) {
		Nombres = nombres;
	}
	public float getPrecio() {
		return Precio;
	}
	public void setPrecio(float precio) {
		Precio = precio;
	}

	
	
	public void MostarIngredientes(JTable paramTablaTotalIngredientes) {
		
		ConexionBDD objetoConexion = new ConexionBDD();
		
		
		
		DefaultTableModel modelo = new DefaultTableModel();
		
		String sql = "";
		
		modelo.addColumn("ID");
		modelo.addColumn("Nombre");
		modelo.addColumn("Precio");
		
		paramTablaTotalIngredientes.setModel(modelo);
		
		String[] cabeceras = {"ID", "NOMBRE","PRECIO"};
		modelo.addRow(cabeceras);
		
		
		sql = "Select * from Ingredientes;";
		
		String [] datos = new String [3];
		Statement miStatement;
		
		try {
			
			miStatement = objetoConexion.EstablecerConexion().createStatement();
			
			
			ResultSet rs = miStatement.executeQuery(sql);
			
			while(rs.next()) {
			 
				
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				datos[2] = rs.getString(3);
				
				modelo.addRow(datos);
				
				
				
				
			}
			
			paramTablaTotalIngredientes.setModel(modelo);
			
			
			
			
		} catch (Exception e) {

			JOptionPane.showInternalMessageDialog(null, "Error: "+e.toString());
			
			
			
		
		}
		
		
		
	}
	
	
	public void insertarIngrediente(JTextField paramID,JTextField paramNombres, JTextField paramPrecio) {
		
		setID(Integer.parseInt(paramID.getText()));
		setNombres(paramNombres.getText());
		setPrecio(Float.parseFloat(paramPrecio.getText()));
		
		ConexionBDD objetoConexion = new ConexionBDD();
		String Consulta ="INSERT INTO public.ingredientes(id_ingrediente, nom_ingrediente, precio_ingrediente)VALUES (?,?, ?);";
		
		
		try {
			
			CallableStatement cs = objetoConexion.EstablecerConexion().prepareCall(Consulta);
			cs.setInt(1, getID());
			cs.setString(2, getNombres());
			cs.setFloat(3, getPrecio());
		

			cs.execute();
			 JOptionPane.showInternalMessageDialog(null, "Se inserto Correctamente");
			
		} catch (Exception e) {

			JOptionPane.showInternalMessageDialog(null, "Error: "+e.toString());
			
			
		
		}
		
		
	}
	
	
	public 	void SelecionarIngrediente(JTable paramTablaTotalIngredientes, JTextField paramID, JTextField paramNombre, JTextField paramPrecio) {
		
		try {
		
			
			int fila = paramTablaTotalIngredientes.getSelectedRow();
			
			if (fila>=0) {
				
				paramID.setText( paramTablaTotalIngredientes.getValueAt(fila, 0).toString());
				paramNombre.setText( paramTablaTotalIngredientes.getValueAt(fila, 1).toString());
				paramPrecio.setText( paramTablaTotalIngredientes.getValueAt(fila, 2).toString());
 
				
				
				
			}else {
				
				JOptionPane.showInternalMessageDialog(null, "Fila no Selecionada");

				
			}
			
			
			
		} catch (Exception e) {
			
			JOptionPane.showInternalMessageDialog(null, "Error: "+e.toString());


		
		}
		
	}
	
public void ModificarIngredientes(JTextField paramID,JTextField paramNombres, JTextField paramPrecio) {
		
		setID(Integer.parseInt(paramID.getText()));
		setNombres(paramNombres.getText());
		setPrecio(Float.parseFloat(paramPrecio.getText()));
		
		ConexionBDD objetoConexion = new ConexionBDD();
		String Consulta ="UPDATE public.ingredientes SET nom_ingrediente=?, precio_ingrediente=? WHERE id_ingrediente = ?";
		
		
		try {
			
			CallableStatement cs = objetoConexion.EstablecerConexion().prepareCall(Consulta);
			
			cs.setString(1, getNombres());
			cs.setFloat(2, getPrecio());
			cs.setInt(3, getID());


		

			cs.execute();
			 JOptionPane.showInternalMessageDialog(null, "Se inserto Correctamente");
			
		} catch (Exception e) {

			JOptionPane.showInternalMessageDialog(null, "Error: "+e.toString());
			
			
		
		}
		
		
	}

public void EliminarIngrediente(JTextField paramID) {
	
	setID(Integer.parseInt(paramID.getText()));
	
	ConexionBDD objetoConexion = new ConexionBDD();
	String Consulta ="DELETE FROM public.ingredientes WHERE id_ingrediente =?;";
	
	
	try {
		
		CallableStatement cs = objetoConexion.EstablecerConexion().prepareCall(Consulta);
		cs.setInt(1, getID());


	

		cs.execute();
		 JOptionPane.showInternalMessageDialog(null, "Se Elimino Correctamente");
		
	} catch (Exception e) {

		JOptionPane.showInternalMessageDialog(null, "Error: "+e.toString());
		
		
	
	}
	
	
}
	
	
	
	
	
}//Final
