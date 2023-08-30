package Elevator.Bling;

import Elevator.ElevatorLogger;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JokeForTheRide
{
    public Joke getJoke() throws IOException, InterruptedException
    {
        return getJoke(false);
    }

    public Joke getJoke(boolean p) throws IOException, InterruptedException
    {
        ObjectMapper om = new ObjectMapper();
        String jokeType = p ? "programming" : "general";
        final String jokeJson = "{\"id\":\"1\",\"type\":\"%s\",\"setup\":\"some setup line\",\"punchline\":\"something funny!\"}".formatted(jokeType);
        Joke joke = om.readValue(jokeJson, Joke.class);
        ElevatorLogger.Info(joke.setup);
        ElevatorLogger.Info(joke.punchline);
        return joke;
    }

}
