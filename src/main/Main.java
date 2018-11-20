package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javweb.client.Client;
import javweb.plugin.JavWebPlugin;
import javweb.server.Server;
import javweb.web.Request;
import javweb.web.Response;
import main.parser.JvParser;

public class Main extends JavWebPlugin {

	public Main() {
		super("TestPlugin", "1.0", "Lenny");
	}

	@Override
	public boolean onStart(Server server) {
		return super.onStart(server);
	}

	@Override
	public boolean onFileRequest(Request request, Response response, Client client, File requestedFile) {
		// check if jv file

		if (requestedFile.getAbsoluteFile().getName().endsWith(".jv")) {
			try {
				// parse jv file
				BufferedReader br = new BufferedReader(new FileReader(requestedFile));
				StringBuilder sb = new StringBuilder();
				String ln;
				while ((ln = br.readLine()) != null)
					sb.append(ln);
				br.close();
				JvParser parser = new JvParser(sb.toString());
				System.out.println("\r\rRESPONSE\n" + parser.getResponse());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return true;
	}

}
