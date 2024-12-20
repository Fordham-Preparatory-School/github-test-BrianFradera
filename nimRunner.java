package NimGame;

public class nimRunner {
    public static void main(String[] args){
        System.out.println("Welcome to the Nim Game ");
        Board.populate();
        Nim gameofNim = new Nim();
        gameofNim.play();
    }
    
}
