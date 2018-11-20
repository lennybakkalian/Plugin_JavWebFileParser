package main.language.types;

import main.language.JvObject;

public class JvString extends JvObject {
	private String str;

	public JvString(String str) {
		this.str = str;
	}
	
	@Override
	public JvObject call() throws Exception {
		return this;
	}
}
