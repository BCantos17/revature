package com.revature.data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class GameDAO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int gameId;
	@@Column
	private String title;
	@Column
	private String genre;

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public GameDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GameDAO(int gameId, String title, String genre) {
		super();
		this.title = title;
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "GameDAO [gameId=" + gameId + ", title=" + title + ", genre=" + genre + "]";
	}

}
