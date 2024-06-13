package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import jakarta.ws.rs.BadRequestException;

import java.math.BigInteger;


@Path("/labseq")
public class LabSeqResource {

    @Inject
    LabSeqService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{n}")
    public BigInteger  greeting(String n) {
        BigInteger res = service.labseq(n);

        if (res == null) {
            throw new BadRequestException();
        }

        return res;
    }

}
