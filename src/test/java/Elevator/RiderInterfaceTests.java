package Elevator;

import Elevator.Bling.Joke;
import Elevator.RiderInterface;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RiderInterfaceTests
{
    @Nested
    @Tag("Unit")
    class UnitTests
    {
        @Test
        public void jokeForFloorTest() throws IOException, InterruptedException
        {
            //assign
            final RiderInterface riderInterface = new RiderInterface();
            final Joke nextJoke = riderInterface.getNextJoke(false);

            //act
            final String setup = riderInterface.tellSetup(nextJoke);
            final String punchline = riderInterface.tellPunchline(nextJoke);

            //assert
            assertThat(setup).isNotEmpty();
            assertThat(setup).isEqualTo(nextJoke.setup);
            assertThat(punchline).isEqualTo(nextJoke.punchline);
        }
        @Test
        public void jokeForFloor42Test() throws IOException, InterruptedException
        {
            //assign
            final RiderInterface riderInterface = new RiderInterface();
            final Joke nextJoke = riderInterface.getNextJoke(true);

            //act
            final String setup = riderInterface.tellSetup(nextJoke);
            final String punchline = riderInterface.tellPunchline(nextJoke);

            //assert
            assertThat(nextJoke.type).isEqualTo("programmer");
            assertThat(setup).isNotEmpty();
            assertThat(setup).isEqualTo(nextJoke.setup);
            assertThat(punchline).isEqualTo(nextJoke.punchline);
        }

    }
}
