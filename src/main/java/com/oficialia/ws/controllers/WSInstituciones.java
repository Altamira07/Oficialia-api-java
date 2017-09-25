package com.oficialia.ws.controllers;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.oficialia.util.Controller;
import com.oficialia.ws.models.Instituciones;
@Path("/instituciones")
public class WSInstituciones extends Controller{
	@Override
	public Response eliminar(int id) {
		Instituciones i = new Instituciones(id);
		if (i.eliminar())
			return Response.ok("{\"msg\":\"Eliminado\"}", MediaType.APPLICATION_JSON).build();
		return Response.ok("{\"msg\":\"no se pudo eliminar\"}", MediaType.APPLICATION_JSON).build();

	}
	
	@PUT
	public Response actualizar(Instituciones i) {
		if (i.actualizar())
			return Response.ok("{\"msg\":\"actualizado\"}", MediaType.APPLICATION_JSON).build();
		return Response.ok("{\"msg\":\"no se pudo actualizar\"}", MediaType.APPLICATION_JSON).build();
	}


	@POST
	public Response crear(Instituciones i) {
		if (i.nuevo())
			return Response.ok("{\"msg\":\"Guardado\"}", MediaType.APPLICATION_JSON).build();
		return Response.ok("{\"msg\":\"no se pudo guardar\"}", MediaType.APPLICATION_JSON).build();
	}

	@Override
	public Response ver(int id) {
		Instituciones i = new Instituciones(id);
		if (i.ver())
			return Response.ok(i, MediaType.APPLICATION_JSON).build();
		return Response.ok("{\"msg\":\"No se encontro\"}").build();
	}

	@Override
	public Response verTodos() {
		Instituciones i = new Instituciones();
		return Response.ok(i.verTodos(), MediaType.APPLICATION_JSON).build();
	}

}
