import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class EventController
{
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void sendATextEveryHalfHourForTwoHours()
    {
        final SendAText sendAText = new SendAText();

        final ScheduledFuture<?> textHandle = scheduler.scheduleAtFixedRate(sendAText, 0, 30, TimeUnit.MINUTES);

        scheduler.schedule(new Runnable()
        {
            public void run()
            {
                textHandle.cancel(true);
            }
        }, 2, TimeUnit.HOURS);
    }
}
