package Uno;

import java.util.Scanner;

public class Game {
    private static int currPlayer = 0;
    private static Card currCard = new Card("Start", "The game");
    private static Player[] players;
    private static boolean reversed = false;
    private static boolean win = false;

    public Game(int playerCount){
        Scanner name = new Scanner(System.in);
        players = new Player[playerCount];

        for(int i = 0; i<playerCount; i++){
            System.out.println("Player "+ (i+1) + ": What is your name: ");
            players[i] = new Player(name.nextLine());
        }
        
        
    }


    

    public  void passRound(){
        if(players[currPlayer].getList().size()==1){
            System.out.print("!!!!!!!!!!!UNO!!!!!!!!!!!");
        }

        if(reversed){
            if(currPlayer==0){
                currPlayer=players.length-1;
            }
                else{
                    currPlayer--;
                }
        }
            else{
                if(currPlayer==players.length-1){
                    currPlayer=0;
                }
                    else{
                        currPlayer++;
                    }
            }
    }

    public void removeCard(Player p1, int c){
        currCard = p1.getList().get(c-1);
        p1.getList().remove(c-1);
    }


    public void Round(Player p1){

        System.out.println("\n" + p1.getName() + " Has "+ p1.getList().size() + " card(s) remaining");
        System.out.println("Player: " + p1.getName() + ", pick Your Card to Put down. The Current Card is: " + currCard.toString());
        p1.listCards();
        System.out.println("Option " +  (p1.getList().size()+1) + " Draw a Card");



        Scanner cardSelect = new Scanner(System.in);
        int cardsel = cardSelect.nextInt();

        if(cardsel==p1.getList().size()+1){
            p1.drawCard();
            passRound();
            return;
        }

        Card card = p1.getList().get(cardsel-1);

        while(Card.canPut(currCard,card)==false){
            System.out.println("Please Put down a valid card or draw");
            cardsel = cardSelect.nextInt();
            card = p1.getList().get(cardsel-1);
            Card.canPut(currCard,card);

        }

        if(Card.canPut(currCard,card)){
            
            if(card.getNumber().equals("Reverse")){
            reversed= !reversed;
        }

        if(card.getColor().equals("Wild")){
            removeCard(p1,cardsel);
            card.wild();
            passRound();
            return;

        }

        if(card.getNumber().equals("draw4")){
            removeCard(p1,cardsel);
            card.wild();
            passRound();
            players[currPlayer].draw4();
            return;
            
        }

        if(card.getNumber().equals("Skip")){
            removeCard(p1,cardsel);
            passRound();
            passRound();
            return;
        }

        if(card.getNumber().equals("draw2")){
            removeCard(p1,cardsel);
            passRound();
            players[currPlayer].draw2();
            return;
            
        }

            removeCard(p1,cardsel);


        if(p1.getList().size()==0){
            win = true;
            return;
        }
        }
            else{
                p1.drawCard();
            }

            passRound();

        
    }



    public void PlayPlayers(){
        while(win==false){
        Round(players[currPlayer]);
        
       }

       System.out.println("The Winner is: " + players[currPlayer].getName());
       
        
    }
    
    
}
