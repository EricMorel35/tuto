package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import test.dto.ContentMovieDTO;
import test.dto.MovieDTORequest;
import test.model.Movie;

@Controller
public class HelloController {

	@Autowired
	private HelloService h;

	@RequestMapping("/test")
	@ResponseBody
	public Movie test() {
		Movie movie = new Movie();
		movie.setId(1L);
		movie.setMovieName("Iron Man");
		h.insertMovie("Iron Man");
		return movie;
	}

	@RequestMapping(value = "testPost", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ContentMovieDTO> testPost(@RequestBody MovieDTORequest request) {
		ContentMovieDTO dto = new ContentMovieDTO();
		dto.setMovieName(request.getMovieName());
		return new ResponseEntity<ContentMovieDTO>(dto, HttpStatus.CREATED);
	}

}
