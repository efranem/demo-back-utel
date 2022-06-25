package edu.utel.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.utel.app.rest.pojo.Item;
import edu.utel.app.service.DemoBackUtelService;

@RestController
@RequestMapping(path = "api")
public class DemoBackUtelController {

	@Autowired
	private DemoBackUtelService service;
	
	@GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getByInstaciaPadre(@RequestParam(name = "query", required = true) String query,
			@RequestParam(name = "soloNuevo", required = false, defaultValue = "false") boolean soloNuevos)
	{
		List<Item> results = service.search(query, soloNuevos);
		return ResponseEntity.ok(results);
	}

	
}
