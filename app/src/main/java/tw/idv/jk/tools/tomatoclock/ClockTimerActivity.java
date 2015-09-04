package tw.idv.jk.tools.tomatoclock;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ClockTimerActivity extends SingleFragmentActivity
{
    public static final String EXTRA_NUMBER_OF_CLOCK = "tw.idv.jk.tools.ClockTimerActivity.NUMBER_OF_CLOCK";

    @Override
    protected Fragment createFragment()
    {
        int numberOfClock = getIntent().getIntExtra(EXTRA_NUMBER_OF_CLOCK, -1);

        if (numberOfClock != -1)
        {
            return ClockTimerFragment.newInstance(numberOfClock);
        }

        return new ClockTimerFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_clock_timer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
