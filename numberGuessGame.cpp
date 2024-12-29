#include <iostream>
using namespace std;
int main(){

    srand(time(NULL));


    int max = (rand()%100) + 1;
    int rightNum = max-(rand()%100);
    int num;
    int tries = 0;
    bool pAgain;

    cout << "********************************************************\n";
    cout << "WELCOME TO THE NUMBER GUESS GAME \n";

    do {
    cout << "Guess a number between 1 and " << max << ": ";
    cin>> num;
    
    

    if (num>rightNum && num<=max && num>=1){
        cout << "Wrong, too high\n";
        tries++;
    }
    else if (num<rightNum && num>=1){
        cout << "Wrong, too low \n";
        tries++;
    }
    else if (num>max || num<1){
        cout << "This number is not in the guess range, try again \n";
    }
    else{
        tries++;
        cout << "Correct, you win!!!" << " It took you " << tries << " tries\n";
    }

    }while (num!=rightNum);

    cout << "********************************************************";


    return 0;
}