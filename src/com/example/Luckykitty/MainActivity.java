package com.example.Luckykitty;

import com.example.Common.SoundOper;
import com.example.Pocker.PockerActivity;
import com.example.Rsf520.Rsf520Activity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	SoundOper mSound;

	// MediaPlayer mediaPlayer01;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// pocker
		ImageButton mImageButtonPocker = (ImageButton) this
				.findViewById(R.id.imageButtonPocker);
		mImageButtonPocker.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_UP) {
					Intent intent = new Intent(MainActivity.this,
							PockerActivity.class);
					startActivity(intent);
				}
				return false;
			}
		});

		// rsf520
		ImageButton mImageButtonRsf520 = (ImageButton) this
				.findViewById(R.id.imageButtonRsf520);
		mImageButtonRsf520.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_UP) {
					Intent intent = new Intent(MainActivity.this,
							Rsf520Activity.class);
					startActivity(intent);
				}
				return false;
			}
		});

		mSound = new SoundOper(this, R.raw.shake_sound_male);

		Button bt1 = (Button) this.findViewById(R.id.buttonStart);
		bt1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				mSound.play(true);
			}
		});

		Button bt2 = (Button) this.findViewById(R.id.buttonStop);
		bt2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				mSound.stop();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

}
