package com.example.sweetseedsapp.controllersandviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.sweetseedsapp.R;
import com.example.sweetseedsapp.models.BirdWatchingNaturalistGameBinocularsModel;

public class BirdWatchingNaturalistGameVIew extends SurfaceView implements Runnable {
    private Context mContext;
    private SurfaceHolder mSurfaceHolder;
    private Paint mPaint;

    private Path mLeftLens;
    private Path mRightLens;

    private Bitmap mBackgroundBitmap;
    private int mBackgroundBitmapY;
    private int mBackgroundBitmapX;

    private BirdWatchingNaturalistGameBinocularsModel mBirdWatchingNaturalistGameBinocularsModel;

    private Bitmap mBitmap;
    private int mBitmapX;
    private int mBitmapY;

    private int mViewWidth;
    private int mViewHeight;

    private RectF mWinnerRect;

    private boolean mRunning;
    private Thread mGameThread;

        public BirdWatchingNaturalistGameVIew(Context context) {
            super(context);

            mContext = context;

            init(context);
        }

        public BirdWatchingNaturalistGameVIew(Context context, AttributeSet attrs) {
            super(context, attrs);

            mContext = context;

            init(context);
        }

        public BirdWatchingNaturalistGameVIew(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);

            mContext = context;

            init(context);
        }

        @Override
        public void setBackground(Drawable background) {
            super.setBackground(background);
        }


        @Override
        public void run() {
            Canvas canvas;

            while (mRunning) {
                if (mSurfaceHolder.getSurface().isValid()) {
                    int mLeftLensX = mBirdWatchingNaturalistGameBinocularsModel.getX();
                    int mLeftLensY = mBirdWatchingNaturalistGameBinocularsModel.getY();

                    int mRightLensX = mBirdWatchingNaturalistGameBinocularsModel.getX()+150;

                    int radius = mBirdWatchingNaturalistGameBinocularsModel.getRadius();

                    canvas = mSurfaceHolder.lockCanvas();
                    canvas.save();

                    canvas.drawBitmap(mBackgroundBitmap,mBackgroundBitmapX,mBackgroundBitmapY,mPaint);
                    canvas.drawBitmap(mBitmap, mBitmapX, mBitmapY, mPaint);

                    mLeftLens.addCircle(mLeftLensX, mLeftLensY, radius, Path.Direction.CCW);
                    mRightLens.addCircle(mRightLensX, mLeftLensY,radius,Path.Direction.CCW);

                    canvas.clipPath(mLeftLens, Region.Op.DIFFERENCE);
                    canvas.clipPath(mRightLens, Region.Op.DIFFERENCE);

                    canvas.drawColor(Color.BLACK);

                    if (mLeftLensX > mWinnerRect.left && mLeftLensX < mWinnerRect.right
                            && mLeftLensY > mWinnerRect.top && mLeftLensY < mWinnerRect.bottom) {


                        canvas.drawBitmap(mBackgroundBitmap,mBackgroundBitmapX,mBackgroundBitmapY,mPaint);
                        canvas.drawBitmap(mBitmap, mBitmapX, mBitmapY, mPaint);
                        canvas.drawText(
                                "You Won!", mViewWidth / 3, mViewHeight / 2, mPaint);
                    }
                    mLeftLens.rewind();
                    mRightLens.rewind();
                    canvas.restore();
                    mSurfaceHolder.unlockCanvasAndPost(canvas);


                }

            }

        }

        public void resume() {
            mRunning = true;
            mGameThread = new Thread(this);
            mGameThread.start();
        }

        public void pause() {
            mRunning = false;
            try {
                mGameThread.join();
            } catch (InterruptedException e) {
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float x = event.getX();
            float y = event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    setUpBitmap();
                    updateFrame((int) x, (int) y);
                    invalidate();
                    break;
                case MotionEvent.ACTION_MOVE:
                    updateFrame((int) x, (int) y);
                    invalidate();
                    break;
                default:
            }
            return true;
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);

            mViewWidth = w;
            mViewHeight = h;

            mBirdWatchingNaturalistGameBinocularsModel = new BirdWatchingNaturalistGameBinocularsModel(mViewWidth, mViewHeight);

            mPaint.setTextSize(mViewHeight / 5);

            mBackgroundBitmap = BitmapFactory.decodeResource(
                    mContext.getResources(), R.drawable.bird_watching_game_canopy);

            mBitmap = BitmapFactory.decodeResource(
                    mContext.getResources(), R.drawable.bird_watching_game_red_bird);

            setUpBitmap();
        }


        private void init(Context context) {
            mContext = context;

            mSurfaceHolder = getHolder();

            mPaint = new Paint();
            mPaint.setColor(Color.WHITE);

            mLeftLens = new Path();
            mRightLens =new Path();
        }

        private void setUpBitmap() {

            mBitmapX = (int) Math.floor(
                    Math.random() * (mViewWidth - mBitmap.getWidth()));

            mBitmapY = (int) Math.floor(
                    Math.random() * (mViewHeight - mBitmap.getHeight()));

            mBackgroundBitmapX = 0;

            mBackgroundBitmapY = 0;

            mWinnerRect = new RectF(mBitmapX, mBitmapY,
                    mBitmapX + mBitmap.getWidth(),
                    mBitmapY + mBitmap.getHeight());
        }

        private void updateFrame(int newX, int newY) {
            mBirdWatchingNaturalistGameBinocularsModel.update(newX, newY);
        }
}
