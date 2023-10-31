package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racingcar.factories.CarFactory;
import racingcar.factories.CarRecordFactory;
import racingcar.underhood.CarRecord;
import racingcar.underhood.GameRule;

public class MoveForwardTest {

    static GameRule rule;
    static String[] names;
    CarRecord carRecord;
    MockedStatic<RandomNumberGenerator> mocked;

    @BeforeAll
    static void setNames() {
        names = new String[] {"Max", "Lando", "Lewis", "Oscar", "Alex", "Sainz", "Kevin"};
        rule = new GameRule(0, 9);
    }

    @AfterEach
    void clean() {
        mocked.close();
    }

    @BeforeEach
    void setCarRecordWithDefaultNames() {
        carRecord = CarRecordFactory.createEmptyCarRecord(rule);
        for (int i = 0; i < names.length; i++) {
            carRecord.register(CarFactory.car(rule, names[i]));
        }
        mocked = Mockito.mockStatic(RandomNumberGenerator.class);
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
