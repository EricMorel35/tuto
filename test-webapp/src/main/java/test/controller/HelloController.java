package test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test.model.Movie;

@Controller
public class HelloController {

	@GetMapping("/test")
	@ResponseBody
	public Movie test() {
		Movie movie = new Movie();
		movie.setId(1L);
		movie.setMovieName("Iron Man");
		return movie;
	}

}
