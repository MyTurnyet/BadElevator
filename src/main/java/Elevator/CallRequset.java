package Elevator;

public class CallRequset
{
    private String dir = "";
    private int floor = 0;

    public CallRequset(String dir, int floor)
    {
        this.dir = dir;
        this.floor = floor;
    }

    public int number()
    {
        return floor;
    }

    public String direction()
    {
        return dir;
    }
}
