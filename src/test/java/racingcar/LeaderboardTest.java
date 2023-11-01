package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LeaderboardTest {
    private static Map<Car, String> map;

    @BeforeEach
    void setUp() {
        String input = "test1,test2,test3";
        Player.makeCarList(input);
        Leaderboard.makeCarInstanceList();
        map = Leaderboard.getMap();
    }

    @Test
    void 입력된_이름이_Car_객체인지_확인() {
        for (Car car : map.keySet()) {
            assertThat(car).isInstanceOf(Car.class);
        }
    }
}