package main.exceptions;

public class JvParseException extends Exception {
	private static final long serialVersionUID = 1L;
	private String line;

	public JvParseException(String line) {
		this.line = line;
	}

	@Override
	public String getMessage() {
		return "parse exception at " + line;
	}
}
