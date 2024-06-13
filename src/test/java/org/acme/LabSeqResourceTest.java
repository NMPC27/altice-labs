package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@QuarkusTest
class LabSeqResourceTest {

    @ParameterizedTest
    @ValueSource(strings = { "0", "1", "2", "3", "10", "10000" })
    public void testLabseqEndpoint(String num) {
        given()
          .pathParam("n", num)
          .when().get("/labseq/{n}")
          .then()
            .statusCode(200)
            .body(is(expectedResult(num))); 
    }

    private String expectedResult(String num) {

        int n = Integer.parseInt(num);

        if (n == 0) {return "0";}
        if (n == 1) {return "1";}
        if (n == 2) {return "0";}
        if (n == 3) {return "1";}

        int n_0 = 0;
        int n_1 = 1;
        int n_2 = 0;
        int n_3 = 1;

        for (int i = 4; i <= n; i++) {
            int next = n_0 + n_1;
            n_0 = n_1;
            n_1 = n_2;
            n_2 = n_3;
            n_3 = next;
        }

        return Integer.toString(n_3);
    }

}