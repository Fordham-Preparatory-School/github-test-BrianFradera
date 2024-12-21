
package NimGame;
import java.util.Scanner;
public class Player{
    private String name;
    private int score;
   


    public Player(String name){
        this.name = name;
        
    }
    public String getName(){
        return this.name;
    }
    public int getScore(){
        return this.score;
    }
    public void IncrementScore(){
        this.score++;
    }
   

    
    public int takeTurn(){
        int take = 0;
        if (Board.getNumPieces() >=15){
        System.out.print("Please put in a number from 1 to " + Board.getNumPieces()/2 + ": ");
        while (Board.getNumPieces() >=15){
            Scanner scan = new Scanner(System.in);
                 take = scan.nextInt();
            
                if (take <= Board.getNumPieces()/2 && take>=1){
                    return take;
                }
                else if (take>Board.getNumPieces()/2 || take<1){
                    System.out.print("Not a valid number, insert a number from 1 to " + Board.getNumPieces()/2 + ": ");
                    
            }
            
        }
    }
    if (Board.getNumPieces() >=3 && Board.getNumPieces()<15){
        System.out.print("Please put in a number from 1 to 3: ");
        while (Board.getNumPieces() >=3 && Board.getNumPieces()<15){
        Scanner scan = new Scanner(System.in);
             take = scan.nextInt();
        
            if (take <= 3 && take>=1){
                return take;
            }
            else if (take>3 || take<1){
                System.out.print("Please put in a number from 1 to 3: ");
                
        }
    }
}
if (Board.getNumPieces()<3){
    System.out.print("Please put in a number from 1 to " + Board.getNumPieces() + ": ");
    while (Board.getNumPieces()<3){
        Scanner scan = new Scanner(System.in);
        take = scan.nextInt();
        if (take <= Board.getNumPieces() && take>=1){
            return take;
        }
        else if (take>Board.getNumPieces() || take<1){
            System.out.print("Please put in a number from 1 to " + Board.getNumPieces() + ": ");
            
    }
    }
}
    return take;
        
    

    }

}