package main.language.functions;

import java.util.ArrayList;

import main.language.JvObject;

public class JvFunction extends JvObject {

	private ArrayList<JvObject> objects;

	public JvFunction() {
		objects = new ArrayList<JvObject>();
	}

	public void addJvObject(JvObject obj) {
		this.objects.add(obj);
	}

	@Override
	public JvObject call() throws Exception {
		for (JvObject o : objects) {
			JvObject result = o.call();
			if (result != null)
				return result;
		}
		return null;
	}
}
