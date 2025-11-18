package com.futurize.api;

import com.futurize.domain.Recomendacao;
import com.futurize.service.RecomendacaoService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/api/recomendacoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RecomendacaoResource {
    @Inject
    RecomendacaoService service;

    @GET
    public List<Recomendacao> findAll() {
        return service.findAll();
    }
    
    @GET
    @Path("/usuario/{usuarioId}")
    public List<Recomendacao> findByUsuarioId(@PathParam("usuarioId") Long usuarioId) {
        return service.findByUsuarioId(usuarioId);
    }

    @GET
    @Path("/{id}")
    public Recomendacao findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    public Response create(@Valid Recomendacao recomendacao, @Context UriInfo uriInfo) {
        Recomendacao created = service.create(recomendacao);
        URI uri = uriInfo.getAbsolutePathBuilder().path(created.getId().toString()).build();
        return Response.created(uri).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    public Recomendacao update(@PathParam("id") Long id, @Valid Recomendacao recomendacao) {
        return service.update(id, recomendacao);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
