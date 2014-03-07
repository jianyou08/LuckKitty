package com.example.Common;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundOper {
	private SoundPool soundPool;
	private Integer mSoundId;
	private Integer mStreamId;
	Context mContext;
	boolean mPalying = false;

	public SoundOper(Context context, int resId) {// 初始化声音的方法
		mContext = context;
		soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);// 初始化SoundPool
		mSoundId = soundPool.load(mContext, resId, 0);
	}

	public void play(boolean isLoop) {// 播放声音的方法
		if (!mPalying) {
			AudioManager mgr = (AudioManager) mContext
					.getSystemService(Context.AUDIO_SERVICE);
			float streamVolumeCurrent = mgr
					.getStreamVolume(AudioManager.STREAM_MUSIC);
			float streamVolumeMax = mgr
					.getStreamMaxVolume(AudioManager.STREAM_MUSIC);// 设置最大音量
			float volume = streamVolumeCurrent/streamVolumeMax; //设备的音量
			int loop = isLoop ? -1 : 0;
			mStreamId = soundPool.play(mSoundId, volume, volume, 1, loop, 1f);// 播放

			mPalying = true;
		}
	}

	public void stop() {
		if (mPalying) {
			soundPool.pause(mStreamId);
			mPalying = false;
		}
	}
}
