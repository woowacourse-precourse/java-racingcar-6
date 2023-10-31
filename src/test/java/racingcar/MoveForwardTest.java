package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racingcar.factories.CarFactory;
import racingcar.factories.CarRecordFactory;

public class MoveForwardTest {

    static GameRule rule;
    static String[] names;
    CarRecord carRecord;
    static MockedStatic<RandomNumberGenerator> mocked;

    @BeforeAll
    static void setNames() {
        names = new String[] {"Max", "Lando", "Lewis", "Oscar", "Alex", "Sainz", "Kevin"};
        rule = new GameRule(0, 9);
        mocked = Mockito.mockStatic(RandomNumberGenerator.class);
    }

    @AfterAll
    static void clean() {
        mocked.close();
    }

    @BeforeEach
    void setCarRecordWithDefaultNames() {
        carRecord = CarRecordFactory.createEmptyCarRecord(rule);
        for (int i = 0; i < names.length; i++) {
            carRecord.register(CarFactory.car(rule, names[i]));
        }
    }

    @Test
    void 모든_자동차_1회_전진_이동거리_4미만() {
        // given
        int distance = 3;
        // when
        moveAllCarsForGivenDistance(distance);
        // then
        assertThat(carRecord.getLeadingCarRecord().toString())
                .isEqualTo(String.join(", ", names));
    }

    @Test
    void 모든_자동차_1회_전진_이동거리_4이상() {
        // given
        int distance = 7;
        // when
        moveAllCarsForGivenDistance(distance);
        // then
        assertThat(carRecord.getLeadingCarRecord().toString())
                .isEqualTo(String.join(", ", names));
    }

    void moveAllCarsForGivenDistance(int distance) {
        mocked.when(() -> RandomNumberGenerator.pickRandomNumber(rule))
                .thenReturn(distance);
        carRecord.moveForwardAllCars();
    }
}
