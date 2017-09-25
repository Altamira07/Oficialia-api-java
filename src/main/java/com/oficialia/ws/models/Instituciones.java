package com.oficialia.ws.models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oficialia.util.Conexion;
import com.oficialia.util.Model;

public class Instituciones extends Model{
	private int idInstitucion;
	private String institucion;
	
	public Instituciones() {
		super();
	}

	public Instituciones(int idInstitucion) {
		super();
		this.idInstitucion = idInstitucion;
	}

	public Instituciones(int idInstitucion, String institucion) {
		super();
		this.idInstitucion = idInstitucion;
		this.institucion = institucion;
	}

	public int getIdInstitucion() {
		return idInstitucion;
	}

	public void setIdInstitucion(int idInstitucion) {
		this.idInstitucion = idInstitucion;
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	@Override
	public boolean ver() {
		conexion = new Conexion();
		String query = "select * from instituciones where id_institucion =" + this.idInstitucion + ";";
		try {
			ResultSet rs = conexion.getConexion().createStatement().executeQuery(query);
			conexion.getConexion().close();
			if (rs.next()) {
				this.institucion = rs.getString("institucion");
				return true;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean actualizar() {
		conexion = new Conexion();
		String query = "update instituciones set institucion = '" + institucion + "' where id_institucion = "
				+ idInstitucion;
		try {
			boolean s = conexion.getConexion().createStatement().execute(query);
			conexion.getConexion().close();
			return !s;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean eliminar() {
		conexion = new Conexion();
		String query = "delete from instituciones where id_institucion = " + idInstitucion + ";";
		try {
			boolean s = conexion.getConexion().createStatement().execute(query);
			conexion.getConexion().close();
			return !s;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

	@Override
	public List<Model> verTodos() {

		conexion = new Conexion();
		String query = "select * from instituciones;";
		List<Model> td = new ArrayList<Model>();
		try {
			ResultSet rs = conexion.getConexion().createStatement().executeQuery(query);
			conexion.getConexion().close();
			while (rs.next()) {
				td.add(new Instituciones(rs.getInt("id_institucion"), rs.getString("institucion")));
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return td;
	}

	@Override
	public boolean nuevo() {
		conexion = new Conexion();
		String query = "insert into instituciones(institucion) values ('" + institucion+ "')";
		try {
			boolean s = conexion.getConexion().createStatement().execute(query);
			conexion.getConexion().close();
			return !s;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

}
