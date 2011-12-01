package comments.controllers;

import comments.api.CommentsRestClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
abstract public class BaseController {
	private CommentsRestClient commentsApiClient = null;

	public CommentsRestClient getCommentsApiClient() {
		if (commentsApiClient == null) {
			commentsApiClient = new CommentsRestClient(new RestTemplate());
		}
		return commentsApiClient;
	}
}
