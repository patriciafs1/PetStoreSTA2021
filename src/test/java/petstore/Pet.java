package petstore;


import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class Pet {
    String uri = "https://petstore.swagger.io/v2/pet";


    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    //Post incluir
    @Test // identifica o método ou função como um teste para o TestNG
    public void incluirPet() throws IOException {
        String jsonBody = lerJson("db/pet1.json");

        //Sintaxe Gherkin
        //Dado - Quando - Então
        //Given - When - Then

        given()  //Dado
                .contentType("application/json") //comum em API REST
                 .log().all()
                .body(jsonBody)
        .when() //Quando
                .post(uri)
        .then() //Então
                .log().all()
                .statusCode(200)
        ;

    }


}
