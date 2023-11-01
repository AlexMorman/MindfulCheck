package legacy;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class EventController
{
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);


    /**
     * Trying specific time scheduling
     */

    public void scheduleAnEvent()
    {

    }








    /**
     * Used for testing purposes
     * not intended for final product
     */
    public void sendATextEveryHalfHourForTwoHours()
    {
        final SendAText sendAText = new SendAText("+15125509414");

        final ScheduledFuture<?> textHandle = scheduler.scheduleAtFixedRate(sendAText, 0, 30, TimeUnit.MINUTES);

        scheduler.schedule(new Runnable()
        {
            public void run()
            {
                textHandle.cancel(true);
            }
        }, 2, TimeUnit.HOURS);
    }

    /**
     * schedule a text to be sent at a configurable rate
     * @param phoneNumber target phone number
     * @param frequency number of minutes to wait before sending a message
     */
    public void sendATextPeriodically(String phoneNumber, int frequency)
    {
        final SendAText sendAText = new SendAText(phoneNumber);

        final ScheduledFuture<?> textHandle = scheduler.scheduleAtFixedRate(sendAText, 0, frequency, TimeUnit.MINUTES);

        scheduler.schedule(new Runnable()
        {
            public void run()
            {
                textHandle.cancel(true);
            }
        }, 8, TimeUnit.HOURS);
    }
}
