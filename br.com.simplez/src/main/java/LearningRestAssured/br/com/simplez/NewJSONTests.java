package LearningRestAssured.br.com.simplez;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.get;
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
}

