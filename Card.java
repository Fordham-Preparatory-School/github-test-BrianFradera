package Uno;

import java.util.Scanner;

public class Card {
    private  String color;
    private String number;
    
    final static String[] colors = {"Red", "Blue", "Green", "Yellow", "Wild"};
    final static String[] numbers = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Zero","draw2", "draw4", "Skip", "Reverse"};

    int colran = (int)((Math.random()*5) );
    int numran = (int)((Math.random()*14));

    int colstartran = (int)((Math.random()*3) + 1 );
    int numstartran =  (int)((Math.random()*9) + 1);

    public Card(){

        color=colors[colran];
        number=numbers[numran];

    }

    public Card(String c, String n){
        c= colors[colstartran];
        n= numbers[numstartran];
        
        color = c;
        number = n;
    }

    

    public String toString(){
        if(color.equals("Wild")){
            return color;
        }

        if(number.equals("draw4")){
            return number;
        }
            else{
                return  color + " " +number;
            }
            
    }


    public  String getColor(){
        return color;
    }
    
    public  String getNumber(){
        return number;
    }

    public void setColor(String s){
        color=s;
    }


     public void wild(){
        Scanner wild = new Scanner(System.in);
        System.out.print("What color do you want to set the color to(Red/Green/Blue/Yellow) ");
        String wil = wild.nextLine();

        while(!wil.equals("Red") && !wil.equals("Green") && !wil.equals("Yellow") && !wil.equals("Blue")){
            System.out.print("Put in a valid color text");
            wil = wild.nextLine();
        }

            setColor(wil);
            number = "";
    }

    public static  boolean canPut(Card card, Card card2){
        if (card.getColor().equals(card2.getColor()) || card.getNumber()==card2.getNumber() || card2.getColor().equals("Wild") || card2.getNumber().equals("draw4")){
            return true;
        }
            else{
                return false;
            }
    }
    
}
