package com.example.Common;

import android.content.Context;
import android.media.MediaPlayer;

public class MediaOper {
	private final Integer mResId;
	private final Context mContext;
	private MediaPlayer mMedia;

	public MediaOper(Context context, int resId) {// ��ʼ�������ķ���
		mContext = context;
		mResId = resId;
	}

	public void play(boolean isLoop) {// ���������ķ���
		if ((mMedia == null) || !mMedia.isPlaying()) {
			mMedia = MediaPlayer.create(mContext, mResId);
			mMedia.setLooping(isLoop);
			mMedia.start();
		}
	}

	public void stop() {
		if (mMedia.isPlaying()) {
			mMedia.stop();
		}
	}
}
