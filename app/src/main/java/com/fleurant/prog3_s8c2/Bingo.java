package com.fleurant.prog3_s8c2;

public class Bingo {
    int no_tirage;
    int no_commun;
    char lettre;

    char getLettre(){
        if(no_commun > 0 && no_commun < 16)
        {
            return 'B';
        }
        else if(no_commun > 15 && no_commun < 31)
        {
            return 'I';
        }
        else if(no_commun > 30 && no_commun < 46)
        {
            return 'N';
        }
        else if(no_commun > 45 && no_commun < 61)
        {
            return 'G';
        }
        else if(no_commun > 60 && no_commun < 76)
        {
            return 'O';
        }
        else{
            return '?';
        }
    }
}
