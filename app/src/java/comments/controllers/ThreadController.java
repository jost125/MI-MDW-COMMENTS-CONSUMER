package comments.controllers;

import comments.model.entities.Comment;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import comments.model.entities.Thread;
import java.util.HashMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/thread")
public class ThreadController extends BaseController {
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showThreadAction(@PathVariable Long id, Model model) {
		try {
			HashMap<String, Object> map = this.getCommentsApiClient().listThread(id);
			model.addAttribute("thread", map.get("thread"));
			model.addAttribute("comments", map.get("comments"));

			model.addAttribute("commentForm", new Comment());

			System.out.println(map.get("comments"));
		} catch (IOException ex) {
			Logger.getLogger(ThreadController.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println("");
		return "thread/showThread";
	}

	@RequestMapping(value = "/postMessage/{id}", method = RequestMethod.POST)
	public String postMessageAction(@PathVariable Long id, @ModelAttribute("commentForm") Comment comment) {
		try {
			this.getCommentsApiClient().createComment(comment, id);
		} catch (IOException ex) {
			Logger.getLogger(ThreadController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return "redirect:/thread/" + id;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String threadFormAction(Model model) {
		model.addAttribute("threadForm", new Thread());
		return "thread/createThread";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String threadFormAction(@ModelAttribute("threadForm") Thread thread) {
		try {
			this.getCommentsApiClient().createThread(thread);
		} catch (Exception ex) {
			Logger.getLogger(ThreadController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return "redirect:/";

	}
}
