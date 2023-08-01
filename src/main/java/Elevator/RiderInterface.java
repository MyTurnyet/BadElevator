package Elevator;

import Elevator.Bling.Joke;
import Elevator.Bling.JokeForTheRide;

import java.io.IOException;

public class RiderInterface
{
    private final String jokeType;

    public RiderInterface(){
        this("general");
    }
    public RiderInterface(String jokeType){

        this.jokeType = jokeType;
    }
    public String tellSetup(Joke nextJoke)
    {
        return nextJoke.setup;
    }

    public Joke getNextJoke(boolean b) throws IOException, InterruptedException
    {
        final Joke joke = new JokeForTheRide().getJoke(b);
        ElevatorLogger.Info("Got joke type: "+ joke.type);
//        if(joke.type!="programming"&&b==true){
//            getNextJoke(true);
//        }
        return joke;
    }

    public String tellPunchline(Joke nextJoke)
    {
        return nextJoke.punchline;
    }
}
