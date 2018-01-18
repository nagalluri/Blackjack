package Blackjack;
import Blackjack.Deck;
import Blackjack.Card;

import java.util.ArrayList;


/** 
* Input file description here.
* @author Nag Alluri
*/
public class Hand {

	int value;
	int numCards;
	int numAces;
	ArrayList<Card> cards;

	public Hand() {
		this.value = 0;
		this.numCards = 0;
		this.numAces = 0;
		this.cards = new ArrayList<Card>();
	}

	/**
	* A method that takes adds a card to a Hand and calculates its total value
	*/
	public boolean hit(Card c) {
		cards.add(c);
		String val = c.getVal();
		if ((val.equals("J")) || (val.equals("Q")) || (val.equals("K"))) {
			this.value += 10;
		} else if (val.equals("A")) {
			this.value += 11;
			this.numAces += 1;
		} else {
			this.value += Integer.parseInt(val);
		}

		while ((numAces != 0) && (this.value > 21)) {
			this.value -= 10;
			numAces -= 1;
		}
		
		if (this.value > 21) {
			return false;
		} else {
			return true;
		}
	}

	/**
	* A method that prints out all of the cards in a hand
	*/
	public void print() {
		for (Card c : this.cards) {
			c.print();
		}
	}



	/**
	* Main method
	*/
	public static void main(String[] args) {
		Deck d = new Deck();
		d.shuffle();
		
		Hand h = new Hand();

		while (h.value < 21) {
			Card c = d.draw();
			h.hit(c);
			System.out.println("Your cards are: ");
			h.print();
			System.out.println("Total value: " + Integer.toString(h.value));
		}

	}
}
		