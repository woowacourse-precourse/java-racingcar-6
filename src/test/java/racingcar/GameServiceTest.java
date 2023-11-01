package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameServiceTest {

    RandomUtils randomUtils = new RandomUtils();

    @DisplayName("자동차가 난수 만큼 이동하는 지 확인")
    @Test
    void moveCarTest() {
        List<Integer> randomList = randomUtils.getRandomNumberList(10);

        Car car = new Car("test");
        int goCount = 0;

        for (Integer count : randomList) {
            car.moveOrGo(count);
            if (count >= 4) {
                goCount++;
            }
        }

        assertEquals(goCount, car.getPosition());

    }
}
