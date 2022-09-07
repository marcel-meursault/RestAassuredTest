package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleLinkResults {

	private List<GoogleLinkDto> items;

	public List<GoogleLinkDto> getItems() {
		return items;
	}

	public void setItems(List<GoogleLinkDto> items) {
		this.items = items;
	}
}
