package com.futurize.api;

import com.futurize.domain.Habilidade;
import com.futurize.service.HabilidadeService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/api/habilidades")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HabilidadeResource {
    @Inject
    HabilidadeService service;

    @GET
    public List<Habilidade> findAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    public Habilidade findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    public Response create(@Valid Habilidade habilidade, @Context UriInfo uriInfo) {
        Habilidade created = service.create(habilidade);
        URI uri = uriInfo.getAbsolutePathBuilder().path(created.getId().toString()).build();
        return Response.created(uri).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    public Habilidade update(@PathParam("id") Long id, @Valid Habilidade habilidade) {
        return service.update(id, habilidade);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
