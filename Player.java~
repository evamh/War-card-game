//Player class 

import java.util.*;
import java.io.*;

public class Player {
  
  //instance variables
  private LinkedList<Card> cards;
  private int playerNumber;
  private int numCards;
  private boolean hasWon;
  private Card currentCard;
  private int numPoints;
  
  public Player(int pn, LinkedList<Card> c) {
    playerNumber = pn;
    cards = c;
    numCards = 26;
    hasWon = false;
    currentCard = null;
    numPoints = 0;
  }
  
  //getter methods
  public int getPlayerNumber() {
    return playerNumber;
  }
  
  public LinkedList<Card> getCards() {
    return cards;
  }
  
  public int getNumCards() {
    return numCards;
  }
  
  public boolean getHasWon() {
    return hasWon;
  }
  
  public Card getCurrentCard() {
    return currentCard;
  }
  
  public int getNumPoints() {
    return numPoints;
  }
  
  //draw Card method 
  public Card drawCard() {
    currentCard = cards.removeLast();
    numCards--;
    return currentCard;
  }
  
  //setter method
  public void setHasWon(boolean value) {
    hasWon = value;
  }
  
  public void addPoint() {
    numPoints++;
  }
  
  //toString method
  public String toString() {
    String s = "";
    s += "Player: " + playerNumber + "\n";
    s += "Current card: " + currentCard; 
    s += "Has: " + numCards + "\n";
    s += "HasWon?: " + hasWon;
    s += "Cards: \n";
    s += cards.toString();
    return s;
  } 
  
}