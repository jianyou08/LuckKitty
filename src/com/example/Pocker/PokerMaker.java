package com.example.Pocker;
import java.util.*;

import com.example.Luckykitty.R;

//   | 1  2  3  4  5  6  7  8  9  10  J   Q   K
// 0 | 0  1  2  3  4  5  6  7  8  9  10  11  12 //ºÚÃ·
// 1 |13 14 15 16 17 18 19 20 21  22 23  24  25	//ºìÕè
// 2 |26 27 28 29 30 31 32 33 34  35 36  37  38 //ºìÐÄ
// 3 |39 40 41 42 43 44 45 46 47  48 49  50  51 //ºÚÌÒ
// Little-joker = 52, Big-joker = 53
public class PokerMaker {
	public static final int CARD_COLOR_CLUB = 0;	//ºÚÃ·
	public static final int CARD_COLOR_DIAMOND = 1;	//ºìÕè
	public static final int CARD_COLOR_HEARD = 2;   //ºìÐÄ
	public static final int CARD_COLOR_SPADE = 3;	//ºÚÌÒ
	public static final int CARD_COLOR_LITTLE_JOKER = 52;
	public static final int CARD_COLOR_BIG_JOKER = 53;
	
	public static final int CARD_ID_LITTLE_JOKER = 52;
	public static final int CARD_ID_BIG_JOKER = 53;
	
	public static final int CARD_ID_MINI_ID = 0;
	public static final int CARD_ID_MAX_ID = 53;
	
	public static boolean mIsValid = false;
	public static boolean checkPokerValid() {
		mIsValid = (R.drawable.pockercomzj53 - R.drawable.pockercomc1) == 53;
		return mIsValid;
	} 

	public static int getCardType(int id) {
		if ( id == CARD_ID_LITTLE_JOKER ){
			return CARD_COLOR_LITTLE_JOKER;
		}
		else if ( id == CARD_ID_BIG_JOKER ){
			return CARD_COLOR_BIG_JOKER;
		}
		else {
			return (id / 13);
		}
	}
	
	//Ëæ»úÉú³É¼¸¸öÆË¿Ë
	public static Integer[] randomCards(int num, Set<Integer> filter){
		Set<Integer> retCards = new HashSet<Integer>();
        for (int i = 0; i < num; i++){
			while ( true ) {
				int s=(int)(Math.random() * 54);  
				if ( (s >= 0) && (s <= 53) && (filter == null || !filter.contains(s)) && !retCards.contains(s) ) {
					retCards.add(s);
					break;
				}
			} 
        }
        Integer[] arr = new Integer[num];
 
		retCards.toArray(arr);
		return arr;
    }
	
	public static int getCommonResourceId(int num) {
		return (R.drawable.pockercomc1 + num);
	}
}
