package tw.idv.jk.tools.tomatoclock;

import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * Created by bioyang on 15/9/7.
 */
public class ClockManager
{
    private static final long TOTAL_WORK_TIME = 25 * 60 * 1000;
    private static final long TOTAL_REST_TIME = 25 * 60 * 1000;

    private long mLeftWorkTime = TOTAL_WORK_TIME;
    private long mLeftRestTime = TOTAL_REST_TIME;
    private boolean mWorking = true;

    public ClockManager(long workTime, long restTime, boolean isWorking)
    {
        this.mLeftWorkTime = workTime;
        mLeftRestTime = restTime;
        mWorking = isWorking;
    }

    public void startWorkingTimer()
    {
        new CountDownTimer(mLeftWorkTime, 1000){

            @Override
            public void onTick(long millisUntilFinished)
            {
                mLeftWorkTime = millisUntilFinished;
            }

            @Override
            public void onFinish()
            {
                //TODO clock round - 1
                mLeftWorkTime = TOTAL_WORK_TIME;
                startRestTimer();
            }
        }.start();
    }

    public void startRestTimer()
    {
        new CountDownTimer(mLeftRestTime, 1000){
            @Override
            public void onTick(long millisUntilFinished)
            {
                mLeftRestTime = millisUntilFinished;
            }

            @Override
            public void onFinish()
            {
                mLeftRestTime = TOTAL_REST_TIME;
                //if clock round > 0 start another work round
            }
        }.start();
    }

    public long getLeftWorkTime()
    {
        return mLeftWorkTime;
    }

    public void setLeftWorkTime(long leftWorkTime)
    {
        mLeftWorkTime = leftWorkTime;
    }

    public long getLeftRestTime()
    {
        return mLeftRestTime;
    }

    public void setLeftRestTime(long leftRestTime)
    {
        mLeftRestTime = leftRestTime;
    }
}
