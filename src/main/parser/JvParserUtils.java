package main.parser;

import main.language.JvObject;
import main.language.functions.JvFunc_Echo;
import main.language.functions.JvFunction;

public class JvParserUtils {
	public static JvFunction getFunctionByName(String name, Object...args) {
		
		switch(name.toLowerCase()) {
		case "echo":
			return new JvFunc_Echo((String) args[0]);
		}
		
		return null;
	}
}
