package enums;

public enum SearchParameters {

	QUERY("q"),
	CX("cx"),
	KEY("key");

	private final String parameter;

	SearchParameters(String parameter) {
		this.parameter = parameter;
	}

	public String getParameter() {
		return parameter;
	}
}
