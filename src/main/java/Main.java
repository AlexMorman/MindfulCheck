
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.io.FileInputStream;
import java.util.Properties;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Properties properties = new Properties();
        properties.load(new FileInputStream("Parameters.config"));

        Twilio.init(properties.getProperty("ACCOUNT_SID"), properties.getProperty("AUTH_TOKEN"));

        EventController eventController = new EventController();
        eventController.sendATextEveryHalfHourForTwoHours();
    }
}
