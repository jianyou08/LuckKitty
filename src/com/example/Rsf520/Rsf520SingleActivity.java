package com.example.Rsf520;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.Common.BitmapOper;
import com.example.Common.MediaOper;
import com.example.Common.ShakeHandler;
import com.example.Common.ShakeHandler.OnShakeListener;
import com.example.Luckykitty.R;

public class Rsf520SingleActivity extends Activity {
	ImageView mImageViewMe;

	ShakeHandler mShakeListener = null;
	MediaOper mSound;

	MenuItem mMenuItemModeSingle;
	MenuItem mMenuItemModeVsMobile;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rsf520_single);

		mShakeListener = new ShakeHandler(this);
		mShakeListener.setOnShakeListener(new ShakeLitenerImpl());

		mSound = new MediaOper(this, R.raw.shake_sound_male);

		mImageViewMe = (ImageView) this
				.findViewById(R.id.imageViewRsf520MeSingle);
	}
	
	protected void onResume() {
		mShakeListener.start();
		super.onResume();
	}
	
	protected void onPause() {
		mShakeListener.stop();
		super.onPause();
	}

	private void changeToVsMobileMode() {
		Intent intent = new Intent(this, Rsf520Activity.class);
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
					getResources(), id, mImageViewMe.getWidth(),
					mImageViewMe.getHeight()));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.rsf520, menu);

		mMenuItemModeSingle = menu.findItem(R.id.action_mode_single);
		mMenuItemModeVsMobile = menu.findItem(R.id.action_mode_vsmobile);
		mMenuItemModeSingle.setVisible(false);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.action_pocker:
			break;
		case R.id.action_mode_vsmobile:
			changeToVsMobileMode();
			break;
		case R.id.action_settings:
			break;
		}
		return true;
	}

}
