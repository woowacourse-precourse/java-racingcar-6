package racingcar.race;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.CarName;

public class RaceCarTest {

    private static MockedStatic<Randoms> random;

    @BeforeAll
    public static void beforeAll() {
        random = mockStatic(Randoms.class);
    }

    @AfterAll
    public static void afterAll() {
        random.close();
    }

    @Test
    @DisplayName("RaceCar 대소비교")
    void raceCarCompareTest() {
        //given
        CarName name1 = new CarName("gun");
        CarName name2 = new CarName("tan");

        RaceCar car1 = new RaceCar(name1);
        RaceCar car2 = new RaceCar(name2);

        //when
        random.when(() -> Randoms.pickNumberInRange(0, 9)).thenReturn(6);
        car1.moveForward();
        int compare1 = car1.compareTo(car2);
        car2.moveForward();
        car2.moveForward();
        int compare2 = car1.compareTo(car2);

        // then
        assertThat(compare1).isEqualTo(1);
        assertThat(compare2).isEqualTo(-1);
    }
}
