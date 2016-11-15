/* WAR CARD GAME
 * By Eva Hayek
 * Updated 2016
 * 
 * GAME CLASS
 * This class implements the game, and is the class that invokes the game() method.
 */
import java.util.*;
import java.io.*;
import java.util.Scanner;

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
    System.out.println("Welcome to the card game War!");
    System.out.println("Today, you and I are going to battle it out for the title of Champion! But first, let me " +
                       "explain how this works.");
    System.out.println("There are 26 rounds, and in each round we draw a card. Whoever draws the card with the highest "
                         + "value wins the round and gets 1 point. If we draw equal value cards, then no one gets any " 
                         + "points.");
    System.out.println("There is one catch though. In each round, there is a TRUMPS suit. If either of us draw a " + 
                       "card from this suit, we automatically win the round. If we both draw a card from this suit, " +
                       "then whoever draws the card with the highest value wins.");
    System.out.println("At the end of the game, whoever has the most points win!");
    System.out.println("There we have it! Ready to play? Type START to start. Or, if you're too scared, "
                         + "type QUIT to quit.");
    
    Scanner scanner = new Scanner(System.in);
    String answer = scanner.next().toUpperCase();
    
    while ((!answer.equals("START")) && (!answer.equals("QUIT"))) {
      System.out.println("Error. Please type START or QUIT.");
      answer = scanner.next().toUpperCase();
    }
    
    if (answer.equals("QUIT")) {
      System.out.println("Too bad! This could have been fun. See you next time!");
      try {
        Thread.sleep(2000);
      }
      catch (InterruptedException e) {
        System.out.println("An error occurred.");
      }
      System.exit(0);
    }
    
    else {
      System.out.println("You've decided to play. Best of luck to you.");
      while (numRounds < 26) {
        round();
      }
      gameOver();
    }
    if (gameOver == true) {
      System.out.println("\nWould you like to play again? Type YES to start over, or NO to quit.");
      
      Scanner scanner2 = new Scanner(System.in);
      String answer2 = scanner2.next().toUpperCase();
      
      while (!answer2.equals("YES") && !answer2.equals("NO")) {
        System.out.println("Error. Please type YES or NO.");
        answer2 = scanner2.next().toUpperCase();
      }
      
      if (answer2.equals("YES")) {
        System.out.println("Starting over...");
        createNewGame();
      }
      else if (answer2.equals("NO")) {
        System.out.println("See you next time!");
        try {
          Thread.sleep(2000);
        }
        catch (InterruptedException e) {
          System.out.println("An error occurred.");
        }
        System.exit(0);
      }
      
    }
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
    
    try {
      Thread.sleep(3000);
    }
    catch (InterruptedException e) {
      System.out.println("An error occurred.");
    }
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
        if (whoWon().getPlayerNumber() == 1) {
          System.out.println("Congratulations! You won with " + whoWon().getNumPoints() + " points! I admit defeat.");
        }
        else if (whoWon().getPlayerNumber() == 2) {
          System.out.println("Haha! I won with " + whoWon().getNumPoints() + " points! I am the true champion!");
        }
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
  
  //Helper method - call a new game if needed
  private void createNewGame() {
    gameOver = false;
    Game newGame = new Game();
    newGame.game();
  }
  
  public static void main(String[] args) {
    Game game1 = new Game();
    game1.game();
  }
  
}

