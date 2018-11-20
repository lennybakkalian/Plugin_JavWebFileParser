package test;

import java.io.File;

import javweb.plugin.JavWebPlugin;
import javweb.web.Response;
import main.Main;

public class Test {

	public static void main(String[] args) {
		JavWebPlugin jwp = new Main();
		jwp.onFileRequest(null, new Response(), null, new File("C:\\Users\\lenny\\Documents\\jv_server\\test.jv"));
	}

}
