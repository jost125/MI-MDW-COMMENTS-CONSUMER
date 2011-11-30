package comments.controllers;

import java.io.IOException;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class DashboardController extends BaseController {

	@RequestMapping(method = RequestMethod.GET)
	public String indexAction(Model model) throws IOException {
		model.addAttribute("threads", this.getCommentsApiClient().getThreads());
		return "dashboard/index";
	}

}
