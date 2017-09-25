package com.oficialia.ws.controllers;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.oficialia.util.Controller;

import com.oficialia.ws.models.TiposDocumentos;

@Path("/tipos-documentos")
public class WSTiposDocumentos extends Controller {

	@Override
	public Response eliminar(int id) {
		TiposDocumentos td = new TiposDocumentos(id);
		if (td.eliminar())
			return Response.ok("{\"msg\":\"Eliminado\"}", MediaType.APPLICATION_JSON).build();
		return Response.ok("{\"msg\":\"no se pudo eliminar\"}", MediaType.APPLICATION_JSON).build();

	}
	
	@PUT
	public Response actualizar(TiposDocumentos td) {
		if (td.actualizar())
			return Response.ok("{\"msg\":\"actualizado\"}", MediaType.APPLICATION_JSON).build();
		return Response.ok("{\"msg\":\"no se pudo actualizar\"}", MediaType.APPLICATION_JSON).build();
	}


	@POST
	public Response crear(TiposDocumentos td) {
		if (td.nuevo())
			return Response.ok("{\"msg\":\"Guardado\"}", MediaType.APPLICATION_JSON).build();
		return Response.ok("{\"msg\":\"no se pudo guardar\"}", MediaType.APPLICATION_JSON).build();
	}

	@Override
	public Response ver(int id) {
		TiposDocumentos td = new TiposDocumentos(id);
		if (td.ver())
			return Response.ok(td, MediaType.APPLICATION_JSON).build();
		return Response.ok("{\"msg\":\"No se encontro\"}").build();
	}

	@Override
	public Response verTodos() {
		TiposDocumentos td = new TiposDocumentos();
		return Response.ok(td.verTodos(), MediaType.APPLICATION_JSON).build();
	}

}
