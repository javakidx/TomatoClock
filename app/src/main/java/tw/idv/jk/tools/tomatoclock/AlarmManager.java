package tw.idv.jk.tools.tomatoclock;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;

/**
 * Created by bioyang on 15/9/3.
 */
public class AlarmManager
{
    private MediaPlayer mMediaPlayer;
    private Context mContext;
    private static AlarmManager sAlarmManager;

    private AlarmManager(Context context)
    {
        mContext = context;
    }

    public static AlarmManager newInstance(Context context)
    {
        if (sAlarmManager == null)
        {
            sAlarmManager = new AlarmManager(context);
        }

        return sAlarmManager;
    }

    public void startAlarm()
    {
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        mMediaPlayer = MediaPlayer.create(mContext, alarmUri);
        mMediaPlayer.start();
    }

    public void stopAlarm()
    {
        if (mMediaPlayer != null)
        {
            mMediaPlayer.stop();
            mMediaPlayer = null;
        }
    }
}
