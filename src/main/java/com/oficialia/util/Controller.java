package com.oficialia.util;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

public class Controller {

	@GET
	@Path("/{id}")
	public Response ver(@PathParam("id") int id) {
		return null;
	}

	@GET
	public Response verTodos() {
		return null;
	}

	@Path("/{id}")
	@DELETE
	public Response eliminar(@PathParam("id") int id) {
		return null;
	}



}
