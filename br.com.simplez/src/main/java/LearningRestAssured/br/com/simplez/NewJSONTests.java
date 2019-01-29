package LearningRestAssured.br.com.simplez;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItems;

public class NewJSONTests {
    final static String ROOT_URI = "http://5c49e41294e8a70014b33317.mockapi.io/testapi";

    @Test
    public void simple_get_test() {
        Response response = get(ROOT_URI + "/user");
        System.out.println(response.asString());

        response.then().body("id", hasItems("1", "2", "3", "4", "5", "6", "7", "8"));
        response.then().body("name", hasItems("Miss Florencio Hahn", "Dameon Daniel", "Elaina Vandervort", "Willy Jacobson", "Dr. Jessy Cole", "Carlie Marvin", "Autumn Bergstrom", "Adriano Chaves"));
    }

    @Test
    public void put_test() {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{\"name\": \"Adriano Chaves\",\"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/ninjad3m0/128.jpg\"}")
                .when()
                .put(ROOT_URI + "/user/1");
        System.out.println("PUT Response\n" + response.asString());
        // tests
        response.then().body("id", Matchers.is("8"));
        response.then().body("name", Matchers.is("Adriano Chaves"));
        response.then().body("avatar", Matchers.is("https://s3.amazonaws.com/uifaces/faces/twitter/ninjad3m0/128.jpg"));
    }

    @Test
    public void post_test(){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{\"name\": \"Adriano Chaves\",\"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/ninjad3m0/128.jpg\"}")
                .when()
                .post(ROOT_URI + "/user");
        System.out.print("Response is -->\n" + response.asString());

        response.then().body("name", Matchers.is("Adriano Chaves"));
    }

    @Test
    public void delete_test() {
        Response response = delete(ROOT_URI + "/user/8");
        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
        // check if id=8 is deleted
        response = get(ROOT_URI + "/user");
        System.out.println(response.asString());
        response.then().body("id", Matchers.not(8));
    }
}

