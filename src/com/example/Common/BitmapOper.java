package com.example.Common;

import java.util.HashMap;
import java.util.Map;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

public class BitmapOper {
	private static Map<Long, Bitmap> mBitmapMap = new HashMap<Long, Bitmap>();
	
	public static Bitmap zoomBitmapFromResource(Resources res, int resId,  
	        int reqWidth, int reqHeight) { 
		long code = getHashCode(0, resId, reqWidth, reqHeight);
		Bitmap bm = mBitmapMap.get(code);
		if ( bm != null ) {
			return bm;
		}
	  
	    // First decode with inJustDecodeBounds=true to check dimensions  
	    final BitmapFactory.Options options = new BitmapFactory.Options();  
	    options.inJustDecodeBounds = true;  
	    BitmapFactory.decodeResource(res, resId, options);  
	  
	    // Calculate inSampleSize  
	    options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);  
	  
	    // Decode bitmap with inSampleSize set  
	    options.inJustDecodeBounds = false;  
	    Bitmap bm1 = BitmapFactory.decodeResource(res, resId, options);
	    mBitmapMap.put(code, bm1);
	    return bm1;
	}  
	
	public static Bitmap ScaleBitmapFromResource(Resources res, int resId,  
	        int reqWidth, int reqHeight) {
		long code = getHashCode(1, resId, reqWidth, reqHeight);
		Bitmap bm = mBitmapMap.get(code);
		if ( bm != null ) {
			return bm;
		}
	    // First decode with inJustDecodeBounds=true to check dimensions  
	    final BitmapFactory.Options options = new BitmapFactory.Options();  
	    options.inJustDecodeBounds = true;  
	    BitmapFactory.decodeResource(res, resId, options);  
	  
	    // Calculate inSampleSize  
	    options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);  
	  
	    // Decode bitmap with inSampleSize set  
	    options.inJustDecodeBounds = false;  
	    Bitmap newBitmap = BitmapFactory.decodeResource(res, resId, options);  
	      
	    Matrix matrix = new Matrix();  
	    matrix.postRotate(180);        /*·­×ª90¶È*/  
	    int width = newBitmap.getWidth();  
	    int height = newBitmap.getHeight();  
	    Bitmap bm1 = Bitmap.createBitmap(newBitmap, 0, 0, width, height, matrix, true);  
	    mBitmapMap.put(code, bm1);
	    return bm1;
	}
	
	private static long getHashCode(int type, int resId, int width, int height)
	{
		long code = 0;
		code = ((resId & 0xFF) << 16) | ((width & 0xFFFF) << 12) | ((width & 0xFFFF) << 12);
		code |= (type << 32);
		return code;
	}
	
	public static int calculateInSampleSize(  
            BitmapFactory.Options options, int reqWidth, int reqHeight) {  
	    // Raw height and width of image  
	    final int height = options.outHeight;  
	    final int width = options.outWidth;  
	    int inSampleSize = 1;  
	  
	    if (height > reqHeight || width > reqWidth) {  
	  
	        // Calculate ratios of height and width to requested height and width  
	        final int heightRatio = Math.round((float) height / (float) reqHeight);  
	        final int widthRatio = Math.round((float) width / (float) reqWidth);  
	  
	        // Choose the smallest ratio as inSampleSize value, this will guarantee  
	        // a final image with both dimensions larger than or equal to the  
	        // requested height and width.  
	        inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;  
	    }  
	  
	    return inSampleSize;  
	}  
}
