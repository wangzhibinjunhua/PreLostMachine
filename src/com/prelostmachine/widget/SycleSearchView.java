package com.prelostmachine.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class SycleSearchView extends View implements Runnable {

	private int mWidth = 200;
	private int mHeight = 200;
	private int srcId;
	private Bitmap mSrc = null;
	private Context mContext;
	private int mLeft = 0;
	private int mTop = 0;
	private int step = 4;
	private boolean positive;
	private Thread thread;
	private boolean canStart = true;
	private int imgWidth = 0;
	private int imgHeight = 0;

	public SycleSearchView(Context context) {
		super(context);
		this.mContext = context;
	}

	public SycleSearchView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.mContext = context;
	}

	public SycleSearchView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		this.mContext = context;
	}

	private void init() {
		mLeft = 0;
		mTop = mHeight / 2;
	}

	private void initXY(int x) {
		mLeft = x;
		mTop = mHeight
				/ 2
				- (int) Math.sqrt(mHeight * mHeight / 4 - (mWidth / 2 - x)
						* (mWidth / 2 - x));
		if (!positive) {
			mTop = mHeight - mTop;
		}
	}

	public void setSize(int width, int height) {
		this.mWidth = width;
		this.mHeight = height;
	}

	public void setImgSrc(int id) {
		this.srcId = id;
		mSrc = BitmapFactory.decodeResource(mContext.getResources(), srcId);
		imgWidth = mSrc.getWidth();
		imgHeight = mSrc.getHeight();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (mSrc == null) {
			return;
		}

		canvas.drawBitmap(mSrc, mLeft, mTop, null);

	}

	public void startsycle() {
		canStart = true;
		Thread localThread = new Thread(this);
		this.thread = localThread;
		this.thread.start();
	}

	public void stopsycle() {
		canStart = false;
		if (this.thread != null) {
			this.thread.interrupt();
		}
	}

	@Override
	public void run() {
		while (canStart) {
			if (positive) {
				if (mLeft + step < mWidth) {
					initXY(mLeft + step);
				} else {
					positive = !positive;
					initXY(mLeft - step);
				}
			} else {
				if (mLeft - step > 0) {
					initXY(mLeft - step);
				} else {
					positive = !positive;
					initXY(mLeft + step);
				}
			}

			postInvalidate();

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
