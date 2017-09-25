package com.oficialia.ws.models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oficialia.util.Conexion;
import com.oficialia.util.Model;

public class TiposDocumentos extends Model {
	private int idTipoDocuemento;
	private String tipoDocumento;

	public TiposDocumentos(int idTipoDocuemento, String tipoDocumento) {
		super();
		this.idTipoDocuemento = idTipoDocuemento;
		this.tipoDocumento = tipoDocumento;
	}

	public TiposDocumentos(int idTipoDocuemento) {
		super();
		this.idTipoDocuemento = idTipoDocuemento;
	}

	public TiposDocumentos() {

	}

	public int getIdTipoDocuemento() {
		return idTipoDocuemento;
	}

	public void setIdTipoDocuemento(int idTipoDocuemento) {
		this.idTipoDocuemento = idTipoDocuemento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	@Override
	public boolean ver() {
		conexion = new Conexion();
		String query = "select * from tipos_documentos where id_tipo_documento =" + this.idTipoDocuemento + ";";
		try {
			ResultSet rs = conexion.getConexion().createStatement().executeQuery(query);
			conexion.getConexion().close();
			if (rs.next()) {
				this.tipoDocumento = rs.getString("tipo_documento");
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
		String query = "update tipos_documentos set tipo_documento = '" + tipoDocumento + "' where id_tipo_documento = "
				+ idTipoDocuemento;
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
		String query = "delete from tipos_documentos where id_tipo_documento = " + idTipoDocuemento + ";";
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
		String query = "select * from tipos_documentos;";
		List<Model> td = new ArrayList<Model>();
		try {
			ResultSet rs = conexion.getConexion().createStatement().executeQuery(query);
			conexion.getConexion().close();
			while (rs.next()) {
				td.add(new TiposDocumentos(rs.getInt("id_tipo_documento"), rs.getString("tipo_documento")));
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return td;
	}

	@Override
	public boolean nuevo() {
		conexion = new Conexion();
		String query = "insert into tipos_documentos(tipo_documento) values ('" + tipoDocumento + "')";
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
