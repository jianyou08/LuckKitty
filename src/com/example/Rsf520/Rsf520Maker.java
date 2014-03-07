package com.example.Rsf520;
import com.example.Luckykitty.R;

public class Rsf520Maker {
	public static final int WIN = 1;
	public static final int LOSE = -1;
	public static final int TIE = 0;
	public static boolean mIsValid = false;
	public static boolean checkPokerValid() {
		mIsValid = (R.drawable.rsf5205 == (R.drawable.rsf5200 + 2));
		return mIsValid;
	} 
	
	//随机生成几个扑克
	public static int randomCards(){
		int s=(int)(Math.random() * 3);
		return (R.drawable.rsf5200 + s);
    }
	
	public static int checkWin(int me, int remote){
		if ( me == remote ) return 0;
		int sub = me - remote;
		switch(sub){
		case 0:
			return TIE;
		case 1:
		case -2:
			return LOSE;
		case -1:
		case 2:
			return WIN;
		}
		return TIE;
	}
}
