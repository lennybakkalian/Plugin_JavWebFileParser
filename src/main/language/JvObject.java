package main.language;

public class JvObject {

	private JvObject[] args;

	public JvObject(JvObject... jvObjects) {
		args = jvObjects;
	}

	public JvObject[] getArgs() {
		return args;
	}

	public JvObject call() throws Exception {
		// access args here
		return null;
	}
}
