import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.util.TimerTask;

public class SendATextTask extends TimerTask
{
    private String phoneNumber;
    private String message;

    public SendATextTask(String phoneNumber, String message)
    {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    @Override
    public void run()
    {
        System.out.println("sending message: " + message + " to: " + phoneNumber);
        Message.creator(
                new PhoneNumber(phoneNumber),
                new PhoneNumber("+18777635931"),
                message)
                .create();
        System.out.println("sent");
    }
}
