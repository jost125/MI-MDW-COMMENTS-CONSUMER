package comments.api;

import comments.model.entities.Comment;
import comments.model.entities.Thread;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class CommentsRestClient {

	private RestTemplate restTemplate;
	private JsonFactory jsonFactory;
	private ObjectMapper mapper;

	public CommentsRestClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
		this.restTemplate.setMessageConverters(getMessageConverters());

		this.mapper = new ObjectMapper();
		this.jsonFactory = mapper.getJsonFactory();
	}

	public void createThread(Thread thread) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", thread.getName());

		ResponseEntity<String> response = post("http://fit-mdw-ws11-101-6.appspot.com/api/thread/create/{idProject}", map, "20006");
	}

	public Thread getThread(long idThread) throws IOException {
		ResponseEntity<String> response = get("http://fit-mdw-ws11-101-6.appspot.com/api/thread/{idThread}", idThread);

		TypeReference<HashMap<String, Thread>> reference = new TypeReference<HashMap<String, Thread>>() {};
		HashMap<String, Thread> value = getParser(response.getBody()).readValueAs(reference);

		return value.get("thread");
	}

	public void createComment(Comment comment, long idThread) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("authorName", comment.getAuthorName());
		map.put("text", comment.getText());

		ResponseEntity<String> response = post("http://fit-mdw-ws11-101-6.appspot.com/api/comment/contribute/{idThread}", map, idThread);
	}

	public HashMap<String, Object> listThread(long idThread) throws IOException {
		ResponseEntity<String> response = get("http://fit-mdw-ws11-101-6.appspot.com/api/comment/list/{idThread}", idThread);

		TypeReference<HashMap<String, HashMap<String, Object>>> reference = new TypeReference<HashMap<String, HashMap<String, Object>>>() {};
		HashMap<String, HashMap<String, Object>> value = getParser(response.getBody()).readValueAs(reference);

		System.out.println(value.get("commentListResponse"));

		return value.get("commentListResponse");
	}

	public ArrayList<Thread> getThreads() throws IOException {
		ResponseEntity<String> response = get("http://fit-mdw-ws11-101-6.appspot.com/api/thread/list/{idProject}", "20006");

		// Json mapping
		TypeReference<HashMap<String, ArrayList<Thread>>> reference = new TypeReference<HashMap<String, ArrayList<Thread>>>() {};
		HashMap<String, ArrayList<Thread>> value = getParser(response.getBody()).readValueAs(reference);

		return value.get("threadList");
	}

	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("api-key", "dac74c7334e496c95cbaa48efbc6f92cd2315678");

		return headers;
	}

	private ResponseEntity<String> post(String url, Object body, Object... os) {
		HttpHeaders headers = getHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity entity = new HttpEntity(body, headers);

		System.out.println(restTemplate.getMessageConverters());

		return restTemplate.exchange(
			url,
			HttpMethod.POST,
			entity,
			String.class,
			os
		);
	}

	private ResponseEntity<String> get(String url, Object... os) {
		HttpEntity entity = new HttpEntity(getHeaders());

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

	private List<HttpMessageConverter<?>> getMessageConverters() {
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(new StringHttpMessageConverter());
		messageConverters.add(getFormMessageConverter());
		messageConverters.add(getJsonMessageConverter());
		messageConverters.add(getByteArrayMessageConverter());
		return messageConverters;
	}
	
	protected FormHttpMessageConverter getFormMessageConverter() {
		FormHttpMessageConverter converter = new FormHttpMessageConverter();
		converter.setCharset(Charset.forName("UTF-8"));
		return converter;
	}

	protected MappingJacksonHttpMessageConverter getJsonMessageConverter() {
		return new MappingJacksonHttpMessageConverter();
	}

	protected ByteArrayHttpMessageConverter getByteArrayMessageConverter() {
		ByteArrayHttpMessageConverter converter = new ByteArrayHttpMessageConverter();
		converter.setSupportedMediaTypes(Arrays.asList(MediaType.IMAGE_JPEG, MediaType.IMAGE_GIF, MediaType.IMAGE_PNG));
		return converter;
	}
}
