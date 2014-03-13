package com.example.Rsf520;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Common.BitmapOper;
import com.example.Common.ShakeHandler;
import com.example.Common.ShakeHandler.OnShakeListener;
import com.example.Common.SoundOper;
import com.example.Luckykitty.R;

public class Rsf520Activity extends Activity {

	ImageView mImageViewRemote;
	ImageView mImageViewMe;
	TextView mTextView;

	boolean mPlayWithComputer = true;
	ShakeHandler mShakeListener = null;
	SoundOper mSound;

	MenuItem mMenuItemModeSingle;
	MenuItem mMenuItemModeVsMobile;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rsf520);

		mShakeListener = new ShakeHandler(this);
		mShakeListener.setOnShakeListener(new ShakeLitenerImpl());

		mSound = new SoundOper(this, R.raw.shake_sound_male);

		mImageViewRemote = (ImageView) this
				.findViewById(R.id.imageViewRsf520Remote);
		mImageViewMe = (ImageView) this.findViewById(R.id.imageViewRsf520Me);

		mTextView = (TextView) this.findViewById(R.id.textViewRsf520LuckyInfo);
	}
	
	protected void onResume() {
		mShakeListener.start();
		super.onRestart();
	}
	
	protected void onPause() {
		mShakeListener.stop();
		super.onPause();
	}

	private void changeToSingleMode() {
		Intent intent = new Intent(this, Rsf520SingleActivity.class);
		startActivity(intent);
	}

	private class ShakeLitenerImpl implements OnShakeListener {

		@Override
		public void onShakeStart() {
			mSound.play(true);
		}

		@Override
		public void onShakeStop() {
			mSound.stop();
			int id = Rsf520Maker.randomCards();
			mImageViewMe.setImageBitmap(BitmapOper.zoomBitmapFromResource(
					getResources(), id, 80, 80));

			if (mPlayWithComputer) {
				int rid = Rsf520Maker.randomCards();
				mImageViewRemote.setImageBitmap(BitmapOper
						.ScaleBitmapFromResource(getResources(), rid, 80, 80));

				switch (Rsf520Maker.checkWin(id, rid)) {
				case Rsf520Maker.WIN:
					mTextView.setText(R.string.luckyInfo_win);
					break;
				case Rsf520Maker.LOSE:
					mTextView.setText(R.string.luckyInfo_lose);
					break;
				case Rsf520Maker.TIE:
					mTextView.setText(R.string.luckyInfo_tie);
					break;
				}
			} else {
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.rsf520, menu);

		mMenuItemModeSingle = menu.findItem(R.id.action_mode_single);
		mMenuItemModeVsMobile = menu.findItem(R.id.action_mode_vsmobile);
		mMenuItemModeVsMobile.setVisible(false);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.action_pocker:
			break;
		case R.id.action_mode_single:
			changeToSingleMode();
			break;
		case R.id.action_settings:
			break;
		}
		return true;
	}

}
