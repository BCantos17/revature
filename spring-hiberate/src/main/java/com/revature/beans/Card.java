package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SCard")
public class Card {
	
	@Id
	@Column(name="SCard_Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	@Column(name="SCard_Suit")
	String suit;
	@Column(name="SCard_Value")
	int value;
	
	public Card(String suit, int value) {
		super();
		this.suit = suit;
		this.value = value;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
