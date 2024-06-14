package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import jakarta.ws.rs.BadRequestException;

import java.math.BigInteger;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/labseq")
@Tag(name = "LabSeq", description = "LabSeq Operations")
public class LabSeqResource {

    @Inject
    LabSeqService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{n}")
    @Operation(summary = "Calculate LabSeq", description = "Calculates the LabSeq value for a given input n.")
    @APIResponses({
        @APIResponse(
            responseCode = "200",
            description = "Successful response",
            content = @Content(mediaType = "text/plain", schema = @Schema(implementation = BigInteger.class))
        ),
        @APIResponse(
            responseCode = "400",
            description = "Invalid input parameter"
        )
    })
    public BigInteger labseqGen(String n) {
        BigInteger res = service.labseq(n);

        if (res == null) {
            throw new BadRequestException();
        }

        return res;
    }

}
