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

	public SoundOper(Context context, int resId) {// ��ʼ�������ķ���
		mContext = context;
		soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);// ��ʼ��SoundPool
		mSoundId = soundPool.load(mContext, resId, 0);
	}

	public void play(boolean isLoop) {// ���������ķ���
		if (!mPalying) {
			AudioManager mgr = (AudioManager) mContext
					.getSystemService(Context.AUDIO_SERVICE);
			float streamVolumeCurrent = mgr
					.getStreamVolume(AudioManager.STREAM_MUSIC);
			float streamVolumeMax = mgr
					.getStreamMaxVolume(AudioManager.STREAM_MUSIC);// �����������
			float volume = streamVolumeCurrent/streamVolumeMax; //�豸������
			int loop = isLoop ? -1 : 0;
			mStreamId = soundPool.play(mSoundId, volume, volume, 1, loop, 1f);// ����

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
