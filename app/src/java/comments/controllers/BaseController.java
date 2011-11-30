package comments.controllers;

import comments.api.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
abstract public class BaseController {
	private Client commentsApiClient = null;

	public Client getCommentsApiClient() {
		if (commentsApiClient == null) {
			commentsApiClient = new Client(new RestTemplate());
		}
		return commentsApiClient;
	}
}
