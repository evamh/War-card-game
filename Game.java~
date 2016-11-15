//Game class

import java.util.*;
import java.io.*;

public class Game {
  
  //instance variables
  private Player player1, player2;
  private boolean gameOver;
  private Deck deck;
  private int numRounds;
  
  public Game() {
    gameOver = false;
    deck = new Deck();
    numRounds = 0;
    
    LinkedList<Card> player1Cards = new LinkedList<Card>();
    LinkedList<Card> player2Cards = new LinkedList<Card>();
    
    for (int i=0; i<26; i++) {
      player1Cards.add(deck.drawCard());
      player2Cards.add(deck.drawCard());
    }
    
    player1 = new Player(1, player1Cards);
    player2 = new Player(2, player2Cards);
    
  }
  
  
  public void game() {
    while (numRounds < 26) {
      round();
    }
    gameOver();
  }
  
  public void round() {
    System.out.println("------------");
    System.out.println("ROUND " + (numRounds+1));
    
    String trumpsSuit = trumpsSuit();
    System.out.println("The trumps suit is: " + trumpsSuit);
    
    Card player1Card = player1.drawCard();
    System.out.println("Player 1 drew " + player1Card);
    Card player2Card = player2.drawCard();
    System.out.println("Player 2 drew " + player2Card + "\n");
    
    //compare cards    
    Card winnerCard = compareCards(player1Card, player2Card, trumpsSuit);
    
    if (winnerCard == null) {
      System.out.println("Tie! No players get any points.");  
    }
    
    else if (winnerCard.equals(player1Card)) {
      System.out.println("Player 1 won the point!");
      player1.addPoint();
    }
    else if (winnerCard.equals(player2Card)) {
      System.out.println("Player 2 won the point!");
      player2.addPoint();
    }

    System.out.println("Player 1 now has: " + player1.getNumPoints() + " points");
    System.out.println("Player 2 now has: " + player2.getNumPoints() + " points");
    
    numRounds++;
  }
  
  private String trumpsSuit() {
    Random rand = new Random();
    int number = rand.nextInt(3);
    String trumpsSuit = "";
    
    if (number == 0) {
      trumpsSuit = "Spades";
    }
    else if (number == 1) {
      trumpsSuit = "Hearts";
    }
    else if (number == 2) {
      trumpsSuit = "Diamonds";
    }
    else if (number == 3) {
      trumpsSuit = "Clubs";
    }
    return trumpsSuit;
  }
  
  //Helper method - compares cards
  private Card compareCards(Card cardp1, Card cardp2, String trumpsSuit) {
    Card winnerCard = null;
    if (cardp1.getSuit().equals(trumpsSuit) && !(cardp2.getSuit().equals(trumpsSuit))) {
      winnerCard = cardp1;
    }
    else if (cardp2.getSuit().equals(trumpsSuit) && !(cardp1.getSuit().equals(trumpsSuit))) {
      winnerCard = cardp2;
    }
    else {
      if (cardp1.getNumberValue() > cardp2.getNumberValue()) {
        winnerCard = cardp1;
      }
      else if (cardp2.getNumberValue() > cardp1.getNumberValue()) {
        winnerCard = cardp2;
      }
      else if (cardp1.getNumberValue() == cardp2.getNumberValue()) {
        System.out.println("Tie round.");
      }
    }
    return winnerCard;
  }
  
  //Helper method - checks and sets game to be over 
  private boolean gameOver() {
    if (numRounds == 26) {
      gameOver = true;
      System.out.println("\nThe game is over!");
      
      if (whoWon() == null) {
        System.out.println("Tie!");
      }
      else {
        System.out.println("Player "  + whoWon().getPlayerNumber() + " has won with " 
                             + whoWon().getNumPoints() + " points.");
      }
    }
    return gameOver;
  }
  
  //Helper method - sees who won
  private Player whoWon() {
    Player winner = null;
    if (player1.getNumPoints() > player2.getNumPoints()) {
      return player1;
    }
    else if (player2.getNumPoints() > player1.getNumPoints()) {
      return player2;
    }
    return winner;
  }
  
  public static void main(String[] args) {
    Game game1 = new Game();
    game1.game();
  }
  
}

