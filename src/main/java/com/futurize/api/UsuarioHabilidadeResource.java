package com.futurize.api;

import com.futurize.domain.UsuarioHabilidade;
import com.futurize.service.UsuarioHabilidadeService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/api/usuario-habilidades")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioHabilidadeResource {
    @Inject
    UsuarioHabilidadeService service;

    @GET
    public List<UsuarioHabilidade> findAll() {
        return service.findAll();
    }
    
    @GET
    @Path("/usuario/{usuarioId}")
    public List<UsuarioHabilidade> findByUsuarioId(@PathParam("usuarioId") Long usuarioId) {
        return service.findByUsuarioId(usuarioId);
    }

    @GET
    @Path("/{id}")
    public UsuarioHabilidade findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    public Response create(@Valid UsuarioHabilidade usuarioHabilidade, @Context UriInfo uriInfo) {
        UsuarioHabilidade created = service.create(usuarioHabilidade);
        URI uri = uriInfo.getAbsolutePathBuilder().path(created.getId().toString()).build();
        return Response.created(uri).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    public UsuarioHabilidade update(@PathParam("id") Long id, @Valid UsuarioHabilidade usuarioHabilidade) {
        return service.update(id, usuarioHabilidade);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
