package legacy;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class SendAText implements Runnable {

    private String phoneNumber;

    public SendAText(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public void run()
    {
        Message.creator(
                new PhoneNumber(phoneNumber),
                new PhoneNumber("+18777635931"),
                "\"Do or do not. There is no try\" -Jedi Master Yoda")
                .create();
    }
}
