package main.parser;

import main.exceptions.JvParseException;
import main.language.functions.JvFunction;

public class JvParser {

	/* PARSER SETTINGS */
	public static String TAG_JV_START = "{jv";
	public static String TAG_JV_END = "jv}";
	public static String TAG_ARG_START = "(";
	public static String TAG_ARG_END = ")";
	public static String TAG_END = ";";
	public static String TAG_STRING = "\"";

	public static enum Context {
		HTML, JV
	}

	private StringBuilder response;
	private Context currentContext = Context.HTML;

	// jv stuff
	private enum ParseMode {
		FUNCTION, ARG, STRING
	}

	private StringBuilder currentFunctionName;
	private JvFunction currentFunction;
	private ParseMode currentMode = ParseMode.FUNCTION;

	public JvParser(String content) throws JvParseException {

		String restContent = content;
		response = new StringBuilder();
		while (restContent.length() > 0) {
			if (currentContext == Context.HTML) {
				// check if jv start tag is there
				if (restContent.toLowerCase().startsWith(TAG_JV_START.toLowerCase())) {
					// jv context
					currentContext = Context.JV;
					restContent = restContent.substring(TAG_JV_START.length(), restContent.length());
				} else {
					response.append(restContent.substring(0, 1));
					restContent = restContent.substring(1, restContent.length());
				}
			} else {
				// check if jv end tag is there
				if (restContent.toLowerCase().startsWith(TAG_JV_END.toLowerCase())) {
					// html context
					currentContext = Context.HTML;
					restContent = restContent.substring(TAG_JV_END.length(), restContent.length());
				} else {
					// parse jv code
					String currentChar = restContent.substring(0, 1);
					restContent = restContent.substring(1, restContent.length());

					if (currentMode == ParseMode.FUNCTION) {
						if (currentFunctionName == null) {
							currentFunctionName = new StringBuilder(currentChar);
						} else {
							// append if not tag_arg_start
							if (currentChar.toLowerCase().equals(TAG_ARG_START.toLowerCase())) {
								// set to arg mode
								currentMode = ParseMode.ARG;
								// search for function
								
								continue;
							}
							currentFunctionName.append(currentChar);
						}
						System.out.println(currentFunctionName);
					} else {
						// ARG MODE
					}

				}
			}
		}
	}

	public String getResponse() {
		return response.toString();
	}
}
