import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.io.FileInputStream;
import java.util.Properties;

public class SendAText implements Runnable {

    public void run()
    {
        Message.creator(
                new PhoneNumber("+15125509414"),
                new PhoneNumber("+18559560182"),
                "\"Do or do not. There is no try\" -Jedi Master Yoda")
                .create();
    }
}
