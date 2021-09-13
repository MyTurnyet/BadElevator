package Elevator.Bling;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JokeForTheRideTests
{
    @Nested
    @Tag("Unit")
    class UnitTests
    {
        @Test
        public void jokeTest() throws IOException, InterruptedException
        {
            //assign
            final JokeForTheRide quoteForTheRide = new JokeForTheRide();

            //act
            final Joke joke = quoteForTheRide.getJoke();
            //assert
            assertThat(joke).isInstanceOf(Joke.class);
            assertThat(joke.setup).isNotEmpty();
            assertThat(joke.punchline).isNotEmpty();
        }
    }

}
