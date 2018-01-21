package Blackjack;
import Blackjack.Deck;
import Blackjack.Card;
import Blackjack.Hand;

import java.util.Scanner;

/** 
* This the main class that operates the different elements of the Blackjack game
* @author Nag Alluri
*/
public class Blackjack {

	
	static Hand dealer;
	static Hand player;
	static Deck deck;
	int balance;

	public Blackjack() {
		this.dealer = new Hand();
		this.player = new Hand();
		Deck deck = new Deck();
		deck.shuffle();
		this.deck = deck;
		this.balance = 1000;
	}

	/**
	* A method that deals the initial cards (2 to the player, 1 to the dealer)
	*/
	public void deal() {
		Card c1 = this.deck.draw();
		Card c2 = this.deck.draw();
		Card c3 = this.deck.draw();

		player.hit(c1);
		dealer.hit(c2);
		player.hit(c3);
	}

	/**
	* A method that prints the dealer's cards and your cards
	*/
	public void print() {
		System.out.println("---------------------*****--------------------");
		System.out.println("Dealer's cards are: ");
		this.dealer.print();
		System.out.println("Total value: " + Integer.toString(this.dealer.value));

		System.out.println(" ");

		System.out.println("Your cards are: ");
		this.player.print();
		System.out.println("Total value: " + Integer.toString(this.player.value));
		System.out.println("---------------------*****--------------------");

	}

	/**
	* A method that checks current balance and prints it out
	*/
	public void checkbalance() {
		if (this.balance <= 0) {
			System.out.println("OUT OF MONEY!!!!");
			System.out.println("GAME OVER!!!");
		} else {
			System.out.println("Current Balance: " + Integer.toString(this.balance));
			System.out.println("Make a wager to begin (min: 10)"); 
		}	
	}


	/**
	* A helper method that checks if a string can be parsed as an int
	* @param str - the string that is being checked
	*/
	public static boolean isInteger(String str) {
	    try {
	        Integer.parseInt(str);
	        return true;
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	}

	/**
	* Main method
	*/
	public static void main(String[] args) {
		System.out.println("Welcome to Blackjack!!!");
		System.out.println("Your current balance is 1000");
		System.out.println("Make a wager to begin (min: 10)");
		Blackjack b = new Blackjack();
		int wager = 0;
		int currbalance = b.balance;
		while (true) {
			System.out.print("> ");
			Scanner scanner = new Scanner(System.in);
			String line = scanner.nextLine();
            String[] rawTokens = line.split(" ");
            String command = rawTokens[0];
            if (isInteger(command)) {
            	wager = Integer.parseInt(command);
            	System.out.println(wager);
            	if ((wager < 10) || (wager > b.balance)) {
            		command = "Error";
            	} else {
            		command = "n";
            	}
            }
            switch (command) {
                case "n":
                	System.out.println(wager);
                	b = new Blackjack();
                	System.out.println(currbalance);
                	b.balance = currbalance;                	
                	b.deal();
                	b.print();
                	if (b.player.value == 21) {
            			System.out.println("YOU WIN!!!");
          
            			currbalance += wager;
            			b.balance = currbalance;  
            			b.checkbalance();
            		} else {
            			System.out.println("Type 'h' to hit or 's' to stand");	
            		}
                    break;
                case "h":
                	try {
                		Card c = b.deck.draw();
                		b.player.hit(c);
                		b.print();
                		if (b.player.value == 21) {
                			System.out.println("YOU WIN!!!");
              
                			currbalance += wager;
                			b.balance = currbalance;  
                			b.checkbalance();
                		} else if (b.player.value > 21) {
                			System.out.println("BUSTED!!!");
              
                			currbalance -= wager;
                			b.balance = currbalance;  
                			b.checkbalance();  
                		} else {
                			System.out.println("Type 'h' to hit or 's' to stand");
                		}
                	} catch(IllegalArgumentException a) {
                      System.out.println("Invalid Range");
                    }
                    break;
                case "s":
                	try {
                		while (b.dealer.value <= 21) {
                			Card c = b.deck.draw();
	                		b.dealer.hit(c);
	                		b.print();
	                		if (((b.dealer.value > b.player.value) && (b.dealer.value <= 21)) || (b.dealer.value == 21)) {
	                			System.out.println("DEALER WINS!!!");
	              
	                			currbalance -= wager;
	                			b.balance = currbalance;  
	                			b.checkbalance(); 
                				break;
	                		} else if ((b.dealer.value == b.player.value) && (b.dealer.value >= 16)) {
	                			System.out.println("PUSH!!!");
	              
                				b.checkbalance();  
                				break; 
	                		}
                		}
						if (b.dealer.value > 21) {
							System.out.println("YOU WIN!!!");
		
                			currbalance += wager;
                			b.balance = currbalance;  
                			b.checkbalance();
                		}
                	} catch(IllegalArgumentException a) {
                      System.out.println("Invalid Range");
                    }
                    break;                

                case "Error":
                	System.out.println("Invalid wager");
                	break;
                default:
                    System.out.println("Type 'n' to start a new game!");  
                    break;
            }
		}

	}
}
		
				