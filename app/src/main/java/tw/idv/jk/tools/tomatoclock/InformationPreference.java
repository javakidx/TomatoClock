package tw.idv.jk.tools.tomatoclock;

import android.content.Context;
import android.preference.PreferenceManager;

/**
 * Created by bioyang on 15/9/7.
 */
public class InformationPreference
{
    public static final String PREF_TASK_NAME = "tw.idv.jk.tools.tomatoclock.TASK_NAME";
    public static final String PREF_POMODORO_ROUND = "tw.idv.jk.tools.tomatoclock.ROUND";

    public static void setTaskName(Context context, String taskName)
    {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putString(PREF_TASK_NAME, taskName)
                .commit();
    }

    public static String getTaskName(Context context)
    {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(PREF_TASK_NAME, null);
    }

    public static void setClockRound(Context context, int round)
    {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putInt(PREF_POMODORO_ROUND, round)
                .commit();
    }

    public static int getClockRound(Context context)
    {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(PREF_POMODORO_ROUND, 0);
    }
}
