package Elevator.Bling;

import Elevator.ElevatorLogger;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class JokeForTheRide
{
    public Joke getJoke() throws IOException, InterruptedException
    {
        return getJoke(false);
    }

    public Joke getJoke(boolean p) throws IOException, InterruptedException
    {
        OkHttpClient httpClient = new OkHttpClient();

        String url ="";
        if(p==true){
            url ="https://elevator-jokes.herokuapp.com/jokes/programming/random";
        } else {
            url ="https://elevator-jokes.herokuapp.com/jokes/random";
        }

        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = httpClient.newCall(request).execute();
        ObjectMapper om = new ObjectMapper();
        Joke joke = om.readValue(response.body().string().toString(), Joke.class);
        ElevatorLogger.Info(joke.setup);
        ElevatorLogger.Info(joke.punchline);
        return joke;
    }

}
