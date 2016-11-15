/* WAR CARD GAME
 * By Eva Hayek
 * Updated 2016
 * 
 * DECK CLASS
 * This class implements a deck object.
 */ 


import java.util.*;
import java.io.*;


public class Deck {
  
  //instance variables
  private LinkedList <Card> deck;
  private int deckSize;
  
  //constructor
  public Deck() {
    
    deck = new LinkedList<Card>();
    
    for (int i=2; i<15; i++) {
      Card card = new Card(i, "Clubs");
      deck.add(card);
      deckSize++;
    }
    
    for (int i=2; i<15; i++) {
      Card card = new Card(i, "Spades");
      deck.add(card);
      deckSize++;
    }
    
    for (int i=2; i<15; i++) {
      Card card = new Card(i, "Hearts");
      deck.add(card);
      deckSize++;
    }
    
    for (int i=2; i<15; i++) {
      Card card = new Card(i, "Diamonds");
      deck.add(card);
      deckSize++;
    }
    
    shuffle();
  }
  
  //shuffle method
  public void shuffle() {
    LinkedList newDeck = new LinkedList<Card>();
    Random rand = new Random();
    while (deck.size() > 0){
      int r = rand.nextInt(deck.size());
      Card c = deck.get(r);
      newDeck.add(c);
      deck.remove(r);
    }
    deck = newDeck;
  }
  
  //might be unnecessary 
  public Card drawCard() {
    Card card = deck.removeLast();
    return card;
  }
  
  public int getCount() {
    //System.out.println(deck.size() + " = " + deckSize);
    return deckSize;
  }
  
  public String toString() {
    String s = "";
    for (int i =0; i<deck.size(); i++) {
      s += deck.get(i) + "\n";
    }
    return s;
  }
  
  public static void main(String args[]) {
    Deck deck = new Deck();
    System.out.println(deck.getCount());
    
    System.out.println(deck);
  }
  
}


