package Blackjack;

/** 
* A class that builds a basic playing card
* @author Nag Alluri
*/
public class Card {
	private String value;
	private String suit;

	/** 
	* A constructor for the Deck class
	* @param suit - the suit of the card (Ex: "Hearts")
	* @param value - the value of the card (Ex: "Ace")
	*/
	public Card(String suit, String value) {
		this.value = value;
		this.suit = suit;
	}

	/**
	* A method that retrieves a card's value
	*/
	public String getVal() {
		return this.value;
	}

	/**
	* A method that retrieves a card's suit
	*/
	public String getSuit() {
		return this.suit;
	}

	/**
	* A method that prints the suit and value of the card
	*/
	public void print() {
		System.out.println(this.value + " of " + this.suit);
	}

	public static void main(String[] args) {

	}
}