package Elevator;

public class ButtonRequest
{
    private final int floor;

    public ButtonRequest(int floor)
    {
        this.floor = floor;
    }

    public int number()
    {
        return floor;
    }
}
