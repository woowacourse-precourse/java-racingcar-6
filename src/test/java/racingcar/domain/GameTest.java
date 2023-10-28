package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

class GameTest {

    private static MockedStatic<Randoms> randoms;

    @BeforeAll
    public static void beforeAll() {
        randoms = Mockito.mockStatic(Randoms.class);
    }

    @AfterAll
    public static void afterAll() {
        randoms.close();
    }

    @Test
    void forwardCars_메시지_반환() {

        given(Randoms.pickNumberInRange(anyInt(), anyInt())).willReturn(7);
        List<Car> cars = List.of(new Car("foo"), new Car("bar"));
        Game game = new Game(cars);

        List<CarDistanceMessage> carDistanceMessages = game.forwardCars();
        List<String> messages = carDistanceMessages.stream().map(CarDistanceMessage::toString).toList();

        assertThat(messages).contains("foo : -", "bar : -");

    }

    @Test
    void getWinnersMessage_메시지_반환() {

        List<Car> cars = List.of(new Car("foo"), new Car("bar"));
        cars.get(0).move();
        Game game = new Game(cars);

        WinnersMessage winnersMessage = game.getWinnersMessage();
        WinnersMessage expect = new WinnersMessage(List.of("foo"));

        assertEquals(winnersMessage.toString(), expect.toString());

    }

}