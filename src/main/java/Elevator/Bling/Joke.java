package Elevator.Bling;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Joke{
    public int id;
    public String type;
    public String setup;
    public String punchline;
}
