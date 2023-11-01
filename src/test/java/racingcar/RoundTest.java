package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.Round;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class RoundTest {
    private static MockedStatic<Randoms> randomsMockedStatic;

    @BeforeAll
    public static void beforeAll() {
        randomsMockedStatic = mockStatic(Randoms.class);
    }

    @AfterAll
    public static void afterAll() {
        randomsMockedStatic.close();
    }

    @Test
    @DisplayName("진행 테스트")
    public void roundTest() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        cars.add(new Car("car3"));
        Round round = new Round(1);
        given(Randoms.pickNumberInRange(0, 9)).willReturn(5);
        round.progress(cars);
        for (Car player : cars) {
            assertEquals(1, player.getCount());
        }
    }
}
