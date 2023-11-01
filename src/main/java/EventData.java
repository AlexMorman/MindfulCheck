import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

public class EventData
{
    public int hour;
    public int minute;
    public String category;

    public EventData(int hour, int minute, String category)
    {
        this.hour = hour;
        this.minute = minute;
        this.category = category;
    }

    public Date buildTime()
    {
        // build time
        Calendar time = Calendar.getInstance();
        time.set(Calendar.HOUR_OF_DAY, hour);
        time.set(Calendar.MINUTE, minute);
        time.set(Calendar.SECOND, 0);

        return time.getTime();
    }
}
