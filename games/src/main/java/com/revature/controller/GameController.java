package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Game;
import com.revature.data.DAO;

@RestController //infer response body
@CrossOrigin(origins="*")
public class GameController {
	@Autowired
	private DAO dao;

	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="/game", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	//@ResponseBody inferred
	public ResponseEntity<Game> create(@RequestBody Game game){
		dao.create(game);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/game/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Game> find(@PathVariable int id){
		Game body = dao.find(id);
		return new ResponseEntity<Game>(body, HttpStatus.OK);
	}
	
	@RequestMapping(value="/game/all", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Game>> findAll(){
		return new ResponseEntity<List<Game>>(dao.findAll(), HttpStatus.OK);
	}
	
}
