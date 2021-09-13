package Elevator;

import Elevator.CallRequset;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CallRequestTests
{
    @Nested
    @Tag("Unit")
    class UnitTests
    {
        @Test
        public void test1()
        {
            //assign
            final CallRequset callRequset = new CallRequset("Up", 3);

            //act
            //assert
            assertThat(callRequset.number()).isEqualTo(3);
            assertThat(callRequset.direction()).isEqualTo("Up");
        }
    }
}
