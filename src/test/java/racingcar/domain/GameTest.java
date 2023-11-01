package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

class GameTest {

    @Test
    void simulate_메시지_반환() {

        List<Car> cars = List.of(new Car("foo"), new Car("bar"));
        Game game = new Game(cars);

        MockedStatic<RandomNumber> randomNumber = mockStatic(RandomNumber.class);
        given(RandomNumber.createRandomNumber()).willReturn(new RandomNumber(4));

        List<CarDistanceMessage> carDistanceMessages = game.simulate();
        List<CarDistanceMessage> expect = List.of(
                new CarDistanceMessage("foo", 1),
                new CarDistanceMessage("bar", 1)
        );

        assertIterableEquals(carDistanceMessages, expect);
        randomNumber.close();

    }

    @Test
    void getWinnersMessage_메시지_반환() {

        List<Car> cars = List.of(new Car("foo"), new Car("bar"));
        cars.get(0).move();
        Game game = new Game(cars);

        WinnersMessage winnersMessage = game.getWinnersMessage();
        WinnersMessage expect = new WinnersMessage(List.of("foo"));

        assertEquals(winnersMessage, expect);

    }

}