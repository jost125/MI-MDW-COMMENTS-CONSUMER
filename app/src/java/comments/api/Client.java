package comments.api;

import comments.model.entities.Thread;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;

public class Client {

	private RestOperations restTemplate;
	private JsonFactory jsonFactory;

	public Client(RestOperations restTemplate) {
		this.restTemplate = restTemplate;
		this.jsonFactory = new ObjectMapper().getJsonFactory();
	}

	public ArrayList<Thread> getThreads() throws IOException {
		ResponseEntity<String> response = get("http://fit-mdw-ws11-101-6.appspot.com/api/thread/list/{idProject}", "20006");

		// Json mapping
		TypeReference<HashMap<String, ArrayList<Thread>>> reference = new TypeReference<HashMap<String, ArrayList<Thread>>>() {};
		HashMap<String, ArrayList<Thread>> value = getParser(response.getBody()).readValueAs(reference);

		return value.get("threadList");
	}

	private ResponseEntity<String> get(String url, Object... os) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("api-key", "dac74c7334e496c95cbaa48efbc6f92cd2315678");

		HttpEntity entity = new HttpEntity(headers);

		return restTemplate.exchange(
			url,
			HttpMethod.GET,
			entity,
			String.class,
			os
		);
	}

	private JsonParser getParser(String json) throws IOException {
		JsonParser parser = jsonFactory.createJsonParser(json);

		return parser;
	}
}
