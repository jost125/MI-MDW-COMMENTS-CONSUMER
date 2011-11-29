package comments.controllers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/static")
public class StaticController {

	private void sendFileToOutput(File file, HttpServletResponse response) throws FileNotFoundException, IOException {
		// Read entire file.
		if (file.canRead()) {
			BufferedInputStream bis = null;
			try {
				bis = new BufferedInputStream(new FileInputStream(file));

				byte[] bytes = new byte[(int)file.length()];
				bis.read(bytes);
				response.getWriter().print(new String(bytes));
			} finally {
				bis.close();
			}
		} else {
			response.setStatus(404);
		}
	}
	
	@RequestMapping(value = "/css/{fileName:.+}", method = RequestMethod.GET)
	public void loadCss(@PathVariable String fileName, HttpServletResponse response) throws IOException {
		response.setContentType("text/css");
		
		File file = new File("css/" + fileName);
		this.sendFileToOutput(file, response);
	}

	@RequestMapping(value = "/img/{fileName:.+}", method = RequestMethod.GET)
	public void loadImg(@PathVariable String fileName, HttpServletResponse response) throws IOException {
		File file = new File("img/" + fileName);
		this.sendFileToOutput(file, response);
	}

	@RequestMapping(value = "/js/{fileName:.+}", method = RequestMethod.GET)
	public void loadJs(@PathVariable String fileName, HttpServletResponse response) throws IOException {
		File file = new File("js/" + fileName);
		this.sendFileToOutput(file, response);
	}
}
