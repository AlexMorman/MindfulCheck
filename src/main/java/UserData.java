public class UserData
{
    public int id;
    public String phoneNumber;
    public EventData[] eventData;

    public UserData(int id, String phoneNumber, EventData[] eventData)
    {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.eventData = eventData;
    }
}
