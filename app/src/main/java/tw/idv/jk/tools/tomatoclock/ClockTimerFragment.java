package tw.idv.jk.tools.tomatoclock;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 */
public class ClockTimerFragment extends Fragment
{
    private TextView mTimerTextView;
    private Button mToggleTimerButton;
    private Button mTakeRestButton;

    private CountDownTimer mCountDownTimer;

    private boolean mTimePaused = false;
    private static final long TOTAL_WORK_TIME = 25 * 60 * 1000;
    private long total = 5000;
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

        resumeCountDownTimer();

        mToggleTimerButton = (Button)view.findViewById(R.id.toggleTimer_Button);
        mToggleTimerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                toggleTimer();
            }
        });

        mTakeRestButton = (Button) view.findViewById(R.id.takeRest_Button);
        mTakeRestButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AlarmManager.newInstance(getActivity()).stopAlarm();
                getActivity().finish();
            }
        });

        mTakeRestButton.setEnabled(false);

        return view;
    }

    private void toggleTimer()
    {
        if (mTimePaused)
        {
            resumeCountDownTimer();
            mToggleTimerButton.setText(getString(R.string.pause_timer));
        } else
        {
            pauseCountDownTimer();
            mToggleTimerButton.setText(getString(R.string.resume_timer));
        }

        mTimePaused = !mTimePaused;
    }

    private void resumeCountDownTimer()
    {
        mCountDownTimer = new CountDownTimer(total, 1000)
        {
            @Override
            public void onTick(long millisUntilFinished)
            {
                updateUI(millisUntilFinished);
            }

            @Override
            public void onFinish()
            {
                AlarmManager.newInstance(getActivity()).startAlarm();
                mTakeRestButton.setEnabled(true);
                mToggleTimerButton.setEnabled(false);
                mTimerTextView.setText(getString(R.string.timer_rings));
            }
        };
        mCountDownTimer.start();
    }

    private void pauseCountDownTimer()
    {
        if (mCountDownTimer != null)
        {
            mCountDownTimer.cancel();
        }
    }

    private void updateUI(long millisUntilFinished)
    {
        total = millisUntilFinished;
        long second = (millisUntilFinished / 1000) % 60;
        long minute = millisUntilFinished / 1000 / 60;

        if (mTimerTextView != null)
        {
            mTimerTextView.setText(minute + ":" + m00NumberFormat.format( second ));
        }
    }

    @Override
    public void onPause()
    {
        super.onPause();

        AlarmManager.newInstance(getActivity()).stopAlarm();
    }
}
