package Elevator;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ElevatorTests
{
    @Nested
    @Tag("Unit")
    class UnitTests
    {
        @Test
        public void test1()
        {
            //assign
            final Elevator elevator = new Elevator();
            //act
            //assert
            assertThat(elevator.current(0)).isTrue();
            assertThat(elevator.current(1)).isFalse();
            assertThat(elevator.Up()).isTrue();
            assertThat(elevator.open()).isFalse();
        }

        @Test
        public void test2()
        {
            //assign
            final Elevator elevator = new Elevator("Down", 1, true);

            //act
            //assert
            assertThat(elevator.Up()).isFalse();
            assertThat(elevator.current(0)).isFalse();
            assertThat(elevator.current(1)).isTrue();

        }

        @Test
        public void test3()
        {
            //assign
            final Elevator elevator = new Elevator("Up", 5, true);

            //act
            //assert
            assertThat(elevator.location(5)).isEqualTo("Same");
            assertThat(elevator.location(4)).isEqualTo("Below");
            assertThat(elevator.location(6)).isEqualTo("Above");
        }

        @Test
        public void test4()
        {
            //assign
            final Elevator elevator = new Elevator("Up", 0, true);

            //act
            final boolean doorsAreOpen = elevator.open();
            //assert
            assertThat(doorsAreOpen).isTrue();
        }

        @Test
        public void test_doors_true()
        {
            //assign
            final Elevator elevator = new Elevator();

            //act
            elevator.move(5);

            //assert
            assertThat(elevator.current(5)).isTrue();
        }

        @Test
        public void test_doors_false()
        {
            //assign
            final Elevator elevator = new Elevator("Up", 2, true);

            //act
            elevator.move(5);

            //assert
            assertThat(elevator.current(5)).isFalse();
        }

        @Test
        public void should_fulfillRequest1()
        {
            //assign
            final CallRequset callRequset = new CallRequset("Up", 5);
            final Elevator elevator = new Elevator("Up", 5, true);
            elevator.callRequests.put(callRequset.number(), callRequset);

            //act
            final boolean fulfilled = elevator.hasFulfilled(callRequset);

            //assert
            assertThat(fulfilled).isTrue();
        }

        @Test
        public void should_not_fulfillRequest1()
        {
            //assign
            final CallRequset callRequset = new CallRequset("down", 3);
            final Elevator elevator = new Elevator("Up", 0, false);
            elevator.callRequests.put(callRequset.number(), callRequset);

            //act
            elevator.move(5);

            //assert
            final boolean fulfilled = elevator.hasFulfilled(callRequset);
            assertThat(fulfilled).isFalse();
        }

        @Test
        public void should_not_fulfillRequest2()
        {
            //assign
            final ButtonRequest buttonRequest = new ButtonRequest(3);
            final Elevator elevator = new Elevator("Up", 0, false);
            elevator.buttonRequests.put(buttonRequest.number(), buttonRequest);

            //act
            elevator.move(5);

            //assert
            final boolean fulfilled = elevator.hasFulfilled(buttonRequest);
            assertThat(fulfilled).isFalse();
        }

        @Test
        public void should_fulfillRequest()
        {
            //assign
            final ButtonRequest buttonRequest = new ButtonRequest(3);
            final Elevator elevator = new Elevator("Up", 0, false);
            elevator.buttonRequests.put(buttonRequest.number(), buttonRequest);

            //act
            elevator.move(5);

            //assert
            final boolean fulfilled = elevator.hasFulfilled(buttonRequest);
            assertThat(fulfilled).isFalse();
        }

        @Test
        void should_doors_be_open()
        {
            final Elevator elevator = new Elevator("Up", 0, false);
            elevator.doors(true);
            assertThat(elevator.open()).isTrue();
        }

        @Test
        void should_doors_be_false()
        {
            final Elevator elevator = new Elevator("Up", 0, false);
            elevator.doors(false);
            assertThat(!elevator.open()).isTrue();
        }
    }
}
