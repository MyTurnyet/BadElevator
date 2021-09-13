package Elevator;

import Elevator.ButtonRequest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ButtonRequestTests
{
    @Nested
    @Tag("Unit")
    class UnitTests
    {
        @Test
        public void test1()
        {
            //assign
            final ButtonRequest buttonRequest = new ButtonRequest(1);

            //act
            //assert
            assertThat(buttonRequest.number()).isEqualTo(1);
        }
    }
}
