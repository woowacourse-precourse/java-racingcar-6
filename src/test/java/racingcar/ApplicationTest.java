package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private Race race;
    private Car car1;
    private Car car2;
    private Driver driver1;
    private Driver driver2;

    @BeforeEach
    void setUp() {
        race = Race.toRaceManager();

        car1 = Mockito.mock(Car.class);
        car2 = Mockito.mock(Car.class);

        driver1 = Driver.of("driver1", car1);
        driver2 = Driver.of("driver2", car2);

        race.addParticipant(driver1.getName());
        race.addParticipant(driver2.getName());
    }

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 경주_횟수에_대한_예외_처리_입력값_1_미만일_경우(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 경주_횟수에_대한_예외_처리_입력값_6_이상일_경우(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "6"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 우승사_산출() {
        // Given
        Mockito.when(car1.respondToDriverInput(Mockito.anyInt())).thenReturn(1);
        Mockito.when(car2.respondToDriverInput(Mockito.anyInt())).thenReturn(0);

        // When
        race.start();

        // Then
        List<Driver> winners = race.getWinners();
        assertThat(winners).containsExactly(driver1);
    }
    @Test
    void 우승사_산출_여러명() {
        //given
        Mockito.when(car1.respondToDriverInput(Mockito.anyInt())).thenReturn(1);
        Mockito.when(car2.respondToDriverInput(Mockito.anyInt())).thenReturn(1);

        //when
        race.start();

        //then
        List<Driver> winners = race.getWinners();
        assertThat(winners).containsExactlyInAnyOrder(driver1, driver2);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
