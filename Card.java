package blackjack;

public class Card {
	private String value;
	private String suit;

	/** 
	* A constructor for the Deck class
	*/
	public Card(String suit, String value) {
		this.value = value;
		this.suit = suit;
	}

	/**
	* A method that retrieves a card's value
	* @param - c is the card whose value is being retrieved
	*/
	public String getVal(Card c) {
		return c.value;
	}

	/**
	* A method that retrieves a card's suit
	* @param - c is the card whose suit is being retrieved
	*/
	public String getSuit(Card c) {
		return c.suit;
	}

	public static void main(String[] args) {

	}
}