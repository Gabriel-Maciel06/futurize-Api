package com.futurize.api;

import com.futurize.domain.Curso;
import com.futurize.service.CursoService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/api/cursos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CursoResource {
    @Inject
    CursoService service;

    @GET
    public List<Curso> findAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    public Curso findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    public Response create(@Valid Curso curso, @Context UriInfo uriInfo) {
        Curso created = service.create(curso);
        URI uri = uriInfo.getAbsolutePathBuilder().path(created.getId().toString()).build();
        return Response.created(uri).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    public Curso update(@PathParam("id") Long id, @Valid Curso curso) {
        return service.update(id, curso);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
