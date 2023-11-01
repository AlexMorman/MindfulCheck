
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.twilio.Twilio;

import java.io.FileInputStream;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Properties properties = new Properties();
        properties.load(new FileInputStream("Parameters.config"));

        Twilio.init(properties.getProperty("ACCOUNT_SID"), properties.getProperty("AUTH_TOKEN"));

        // new way
        Timer timer = new Timer();
        QuoteManager quoteManager = new QuoteManager();

        Type listType = new TypeToken<ArrayList<UserData>>(){}.getType();
        List<UserData> userData = new Gson().fromJson(new FileReader("UserData/UserData.JSON"), listType);

        // for each user
        for (UserData entry : userData)
        {
            // for each event
            for (EventData eventData : entry.eventData)
            {
                // build time
                eventData.buildTime();

                timer.schedule(new SendATextTask(entry.phoneNumber, quoteManager.generateQuote(eventData.category)), eventData.buildTime());
            }
        }

        // old way
        //legacy.EventController eventController = new legacy.EventController();
        //eventController.sendATextEveryHalfHourForTwoHours();
        //eventController.sendATextPeriodically("+15125509414", 30);


        // middle way
        //Timer timer = new Timer();

        //Calendar tenAM = Calendar.getInstance();
        //tenAM.set(Calendar.HOUR_OF_DAY, 10);
        //tenAM.set(Calendar.MINUTE, 0);
        //tenAM.set(Calendar.SECOND, 0);

        //EventData eventData = new EventData(10, 30, "meditation");

        //timer.schedule(new SendATextTask(eventData, "+15125509414"), tenAM.getTime());


    }
}
