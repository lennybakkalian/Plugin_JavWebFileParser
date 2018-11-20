package main.language.functions;

import main.language.JvObject;
import main.language.types.JvString;

public class JvFunc_Echo extends JvFunction{
	
	private String msg;
	
	public JvFunc_Echo(String msg) {
		this.msg = msg;
	}
	
	@Override
	public JvObject call() throws Exception {
		return new JvString(msg);
	}
}
