import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

	@BeforeAll
	public static void endpointSetUp() {
		RestAssured.baseURI = "https://www.googleapis.com/customsearch/v1";
	}
}
