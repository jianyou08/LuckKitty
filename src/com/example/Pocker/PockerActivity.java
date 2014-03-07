package com.example.Pocker;

import com.example.Common.BitmapOper;
import com.example.Common.ShakeHandler;
import com.example.Common.ShakeHandler.OnShakeListener;
import com.example.Luckykitty.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class PockerActivity extends Activity {

	// ImageView mImageView1;
	// ImageView mImageView2;
	// ImageView mImageView3;

	TextView mTextViewLuckyInfo;
	ImageView mImageViewPoker1;

	ShakeHandler mShakeListener = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pocker);

		mShakeListener = new ShakeHandler(this);
		mShakeListener.setOnShakeListener(new ShakeLitenerImpl());

		mTextViewLuckyInfo = (TextView) this
				.findViewById(R.id.textViewLuckyInfo);
		// R.drawable;

		mImageViewPoker1 = (ImageView) this.findViewById(R.id.imageViewPoker1);
		// mImageView2 = (ImageView)this.findViewById(R.id.imageView2);
		// mImageView3 = (ImageView)this.findViewById(R.id.imageView3);
		// mImageView1.setImageBitmap(PokerBitmapMaker.decodeSampledBitmapFromResource(getResources(),
		// R.drawable.h2, 192, 273));
		// mImageView1.setImageBitmap(PokerBitmapMaker.decodeSampledBitmapFromResource(getResources(),
		// R.drawable.h2, 130, 180));
		// mImageView2.setImageBitmap(PokerBitmapMaker.decodeSampledBitmapFromResource(getResources(),
		// R.drawable.h6, 130, 180));
		// mImageView3.setImageBitmap(PokerBitmapMaker.decodeSampledBitmapFromResource(getResources(),
		// R.drawable.h8, 130, 180));
	}

	private class ShakeLitenerImpl implements OnShakeListener {

		@Override
		public void onShakeStop() {
			// TODO Auto-generated method stub

			// mShakeListener.stop();

			int id = PokerMaker.randomCards(1, null)[0];

			mImageViewPoker1.setImageBitmap(BitmapOper.zoomBitmapFromResource(
					getResources(), PokerMaker.getCommonResourceId(id), 192,
					273));

			mTextViewLuckyInfo.setText("Ò¡Ò»Ò¡³É¹¦À² " + id);
		}

		@Override
		public void onShakeStart() {
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
