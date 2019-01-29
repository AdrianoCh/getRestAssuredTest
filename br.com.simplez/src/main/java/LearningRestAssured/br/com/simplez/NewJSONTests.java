package LearningRestAssured.br.com.simplez;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.get;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

public class NewJSONTests {
    final static String ROOT_URI = "http://5c49e41294e8a70014b33317.mockapi.io/testapi";

    @Test
    public void simple_get_test() {
        Response response = get(ROOT_URI + "/user");
        System.out.println(response.asString());

        response.then().body("id", hasItems("1", "2", "3", "4", "5", "6", "7", "8"));
        response.then().body("name", hasItems("Miss Florencio Hahn", "Dameon Daniel", "Elaina Vandervort", "Willy Jacobson", "Dr. Jessy Cole", "Carlie Marvin", "Autumn Bergstrom", "Dr. Buford Stanton"));
    }

    @Test
    public void post_test(){
        Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body("{\"name\": \"Adriano Chaves\",\"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/ninjad3m0/128.jpg\"}").when().post(ROOT_URI + "/user");
        System.out.print("Response is -->\n" + response.asString());

        response.then().body("name", Matchers.is("Adriano Chaves"));
    }
}

