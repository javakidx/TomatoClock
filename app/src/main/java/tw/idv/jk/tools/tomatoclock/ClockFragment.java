package tw.idv.jk.tools.tomatoclock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 *
 */
public class ClockFragment extends Fragment
{
    private Button mStartWorkButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_clock,container, false);

        return setView(v);
    }

    private View setView(final View view)
    {
        mStartWorkButton = (Button)view.findViewById(R.id.startClock_Button);
        mStartWorkButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), ClockTimerActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }
}
