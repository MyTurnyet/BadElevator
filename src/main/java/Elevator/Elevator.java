package Elevator;

import Elevator.Bling.Joke;

import java.util.HashMap;

public class Elevator
{
    public HashMap<Integer, CallRequset> callRequests = new HashMap<Integer, CallRequset>();
    public HashMap<Integer, ButtonRequest> buttonRequests = new HashMap<Integer, ButtonRequest>();
    private String dir = "";
    private int floor = 0;
    private boolean open = false;

    public Elevator()
    {
        this("Up", 0, false);
    }

    public Elevator(String dir, int floor, boolean open)
    {
        this.dir = dir;
        this.floor = floor;
        this.open = open;
    }


    public boolean current(int floor)
    {
        return this.floor == floor;
    }

    public boolean Up()
    {
        return dir == "Up";
    }

    public String location(int expectedFloor)
    {
        if (expectedFloor < floor) return "Below";
        if (expectedFloor > floor) return "Above";
        return "Same";
    }

    public boolean open()
    {
        return open;
    }

    public void move(int floor)
    {
        try
        {
            ElevatorLogger.Info("Moving to floor " + floor);
            final RiderInterface riderInterface = new RiderInterface();
            final Joke nextJoke = riderInterface.getNextJoke(floor == 42);
            ElevatorLogger.Info(nextJoke.setup);
            ElevatorLogger.Info(nextJoke.punchline);
            if (this.open == false)
            {
                this.floor = floor;
            } else
            {
                return;
            }
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public boolean hasFulfilled(CallRequset callRequset)
    {
        try
        {
            if (callRequset.direction() == this.dir)
            {
                if (callRequset.number() == this.floor)
                {
                    ElevatorLogger.Info("fulfilled request");
                    return this.open() == true;
                } else
                {
                    ElevatorLogger.Info("fulfilled request is false");
                    return false;
                }

            } else
            {
                return false;
            }
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void doors(boolean state)
    {
        this.open = state;
    }

    public boolean hasFulfilled(ButtonRequest buttonRequest)
    {
        try
        {
            if (buttonRequest.number() == this.floor)
            {
                ElevatorLogger.Info("fulfilled");
                return this.open == true;
            } else
            {
                ElevatorLogger.Info("fulfilled request" + (buttonRequest.number() == this.floor));
                return false;
            }
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
