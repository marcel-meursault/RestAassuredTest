import core.GoogleRestAPI;
import dto.GoogleLinkDto;
import dto.GoogleLinkResults;
import org.junit.jupiter.api.Test;

class GoogleSearchTest extends BaseTest {

	@Test
	void shouldSearchByMyNameTest() {
		GoogleLinkResults searchResults = GoogleRestAPI.makeRequestWith()
				.cx("23137f2b4a5264fc6") // ИД созданной поисковой системы
				.key("AIzaSyCIcNNl9MjPujLD4XbrL-ZoH5eXjkR1Qe4") // Ключ для запросов
				.query("Алекандр Наумов") // Поисковая строка
				.sendRequestAndGet(GoogleLinkResults.class); // класс в который маппим ответ

		for (GoogleLinkDto link : searchResults.getItems()) {
			System.out.println(link.getFormattedUrl());
		}
	}
}
