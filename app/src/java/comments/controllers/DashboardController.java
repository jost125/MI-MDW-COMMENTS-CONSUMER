package comments.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class DashboardController extends BaseController {

	@RequestMapping(method = RequestMethod.GET)
	public String indexAction() {
		return "dashboard/index";
	}

}
