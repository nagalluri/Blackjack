package Blackjack;

import Blackjack.Card;
import java.util.ArrayList;
import java.util.Collections;

/** 
* A class for a standard set of 52 playing cards
* @author Nag Alluri
*/
public class Deck {
	
	private ArrayList<Card> cards;	

	/** 
	* A constructor for the Deck class
	*/
	public Deck() {
		ArrayList<Card> cards = new ArrayList<Card>();
		String[] values = new String[13];
		String[] suits = {"Hearts", "Spades", "Clubs", "Diamonds"};

		for (String suit : suits) {
			for (int i = 1; i <= 13; i++) {
				String value = Integer.toString(i);
				if (i == 11) {
					value = "J";
				} else if (i == 12) {
					value = "Q";
				} else if (i == 13) {
					value = "K";
				} else if (i == 1) {
					value = "A";
				}
				Card c = new Card(suit, value);
				cards.add(c);
			}
		}
		this.cards = cards;
	}


	/**
	* A method that shuffles and returns a deck
	*/
	public Deck shuffle() {
		Collections.shuffle(this.cards);
		return this;
	}


	/**
	* A method that removes and returns the top card of the deck
	*/
	public Card draw() {
		return this.cards.remove(0);
	}

	/**
	* A method that returns the size of the deck
	*/
	public int size() {
		return this.cards.size();
	}


	/**
	* Main method
	*/
	public static void main(String[] args) {
		Deck d = new Deck();
		d.shuffle();
		System.out.println(d.size());
		Card c = d.draw();
		c.print();
		System.out.println(d.size());

	}
}
		