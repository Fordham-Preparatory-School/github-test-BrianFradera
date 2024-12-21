package NimGame;
import java.util.Scanner;
public class Nim {
    private Player player1;
    private Player player2;
    

    public Nim(){
        System.out.println("Please insert your names here: ");
        Scanner scan = new Scanner(System.in);
        System.out.print("Player one: ");
        String one = scan.nextLine();
        player1 = new Player(one);
        System.out.print("Player two: ");
        String two = scan.nextLine();
        player2 = new Player(two);
        

    }
    public void play(){
        System.out.println("there are " + Board.getNumPieces() + " pieces");
        Player currPlayer = player1;
        double randomFirst = (Math.random());
        if (randomFirst <0.5 ){
            currPlayer = player1;
        }
        else {
           currPlayer = player2;
        }
        
        while (Board.getNumPieces() > 0){
            System.out.println("Player: " + currPlayer.getName() + ", take your turn" );
            int piecestaken = currPlayer.takeTurn();
            Board.removePieces(piecestaken);
            System.out.println("There are " + Board.getNumPieces() + " pieces left.");
            if (currPlayer == player1){
                currPlayer = player2;
            }
            else {currPlayer = player1;}

        }
        if (Board.getNumPieces()==0){
            if (currPlayer == player1){
                currPlayer = player2;
            }
            else {currPlayer = player1;}
        }
            currPlayer.IncrementScore();
            System.out.println(currPlayer.getName() + " Wins!!!  Your score is now " + currPlayer.getScore()  );
            
            
            if (playAgain() == true){
                Board.populate();
                play();
    }

    }
    
    private boolean playAgain(){
        boolean keepPlaying = true;
        Scanner scan = new Scanner(System.in);
        while (keepPlaying = true){
        System.out.print("Do you want to play again (y/n) ");
        String x = scan.nextLine();
        if (x.equals("Y")||x.equals("y")||x.equals("Yes")||x.equals("yes")){
             return keepPlaying =true;
        }
        else if (x.equals("N")||x.equals("n")||x.equals("No")||x.equals("no")){
            System.out.println("Final Score:");
            System.out.println("Player: " +player1.getName() + ": " + player1.getScore());
            System.out.println("Player: " +player2.getName() + ": " + player2.getScore());
             return keepPlaying =false;

            
        } 
        else{
            System.out.println("Please put in a y or n");
            
        }
    }
        return keepPlaying;
    
    
    
    }
    
    
}
