package Elevator.Bling;

import Elevator.ElevatorLogger;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;

public class JokeForTheRide
{
    public Joke getJoke() throws IOException, InterruptedException
    {
        return getJoke(false);
    }

    public Joke getJoke(boolean p) throws IOException, InterruptedException
    {
        OkHttpClient httpClient = new OkHttpClient();

        String url = "";
        Joke[] jokes = null;
        if (p == true)
        {
            url = "https://my-json-server.typicode.com/MyTurnyet/fakejson/jokes";
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = httpClient.newCall(request).execute();
            ObjectMapper om = new ObjectMapper();
            String jokeType = p ? "programming" : "general";
            final String jokeJson = "{\"id\":\"1\",\"type\":\"%s\",\"setup\":\"some setup line\",\"punchline\":\"something funny!\"}".formatted(jokeType);
            jokes = om.readValue(response.body().string().toString(), Joke[].class);
        } else
        {
            url = "https://my-json-server.typicode.com/MyTurnyet/fakejson/jokes/2";
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = httpClient.newCall(request).execute();
            ObjectMapper om = new ObjectMapper();
            String jokeType = p ? "programming" : "general";
            jokes = new ArrayList<Joke>().toArray(new Joke[1]);
            jokes[0] = om.readValue(response.body().string().toString(), Joke.class);
        }

        if (p != true)
        {
            ElevatorLogger.Info(jokes[0].setup);
            ElevatorLogger.Info(jokes[0].punchline);
            return jokes[0];
        } else
        {
            ElevatorLogger.Info(jokes[1].setup);
            ElevatorLogger.Info(jokes[1].punchline);
            return jokes[0];
        }
    }

}
