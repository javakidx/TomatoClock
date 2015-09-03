package tw.idv.jk.tools.tomatoclock;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by Javakid on 2015/9/3.
 */
public class ClockTimerFragment extends Fragment
{
    private TextView mTimerTextView;

    private CountDownTimer mCountDownTimer;
    private static final long TOTAL_WORK_TIME = 25 * 60 * 1000;
    private NumberFormat m00NumberFormat = new DecimalFormat("00");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_clock_timer,container, false);

        return prepareView(v);
    }

    private View prepareView(final View view)
    {
        mTimerTextView = (TextView)view.findViewById(R.id.timer_TextView);

        mCountDownTimer = new CountDownTimer(TOTAL_WORK_TIME, 1000)
        {
            @Override
            public void onTick(long millisUntilFinished)
            {

                long second = (millisUntilFinished / 1000) % 60;
                long minute = millisUntilFinished / 1000 / 60;
                mTimerTextView.setText(minute + ":" + m00NumberFormat.format( second ));
            }

            @Override
            public void onFinish()
            {
                mTimerTextView.setText("Done");
            }
        };
        mCountDownTimer.start();

        return view;
    }
}
