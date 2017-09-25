package com.oficialia.ws.models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oficialia.util.Conexion;
import com.oficialia.util.Model;

public class Formatos extends Model
{
	private int idFormato;
	private String formato;
	public Formatos(int idFormato) {
		super();
		this.idFormato = idFormato;
	}

	public Formatos() {
		super();
	}

	public Formatos(int idFormato, String formato) {
		super();
		this.idFormato = idFormato;
		this.formato = formato;
	}

	public int getIdFormato() {
		return idFormato;
	}

	public void setIdFormato(int idFormato) {
		this.idFormato = idFormato;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	@Override
	public boolean ver() {
		conexion = new Conexion();
		String query = "select * from formatos where id_formato =" + this.idFormato + ";";
		try {
			ResultSet rs = conexion.getConexion().createStatement().executeQuery(query);
			conexion.getConexion().close();
			if (rs.next()) {
				this.formato = rs.getString("formato");
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
		String query = "update formatos set formato = '" + formato + "' where id_formato = "
				+ idFormato;
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
		String query = "delete from formatos where id_formato = " + idFormato + ";";
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
		String query = "select * from formatos;";
		List<Model> td = new ArrayList<Model>();
		try {
			ResultSet rs = conexion.getConexion().createStatement().executeQuery(query);
			conexion.getConexion().close();
			while (rs.next()) {
				td.add(new Formatos(rs.getInt("id_formato"), rs.getString("formato")));
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return td;
	}

	@Override
	public boolean nuevo() {
		conexion = new Conexion();
		String query = "insert into formatos(formato) values ('" + formato + "')";
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
