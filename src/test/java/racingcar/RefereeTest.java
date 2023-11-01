package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;

import java.time.Duration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockedStatic;
import racingcar.factories.CarFactory;
import racingcar.factories.CarRecordFactory;
import racingcar.underhood.Car;
import racingcar.underhood.CarRecord;
import racingcar.underhood.GameRule;
import racingcar.underhood.Referee;

public class RefereeTest {

    String[] names;
    private static GameRule rule = new GameRule(0, 9);
    private Referee referee;
    private CarRecord carRecord;
    private static int laps = 10;

    @BeforeEach
    private void init() {
        carRecord = CarRecordFactory.createEmptyCarRecord(rule);
        names = new String[] {"Max", "Lando", "Lewis", "Oscar", "Alex", "Sainz", "Kevin"};
        for (int i = 0; i < names.length; i++) {
            carRecord.register(CarFactory.car(rule, names[i]));
        }
        referee = new Referee(carRecord);
    }

    /**
     * 기존의 자동차들은 0만큼 움직이고 winner 자동차는 전진한다.
     * 승자는 winner 한 명이다.
     */
    @Test
    void 우승한_차량이_한_대() {
        assertWithMockedRandomNumberGenerator(5, () -> {
            // when
            Car winner = CarFactory.car(rule, "Nick");
            winner.moveForward();
            carRecord.register(winner);
            // then
            assertThat(referee.announceAllWinners()).isEqualTo(winner.getName());
        });
    }

    /**
     * 기존 차량들은 laps회동안 이동하지 않는다.
     * winners 자동차들은 1씩 laps회 만큼 이동한다.
     */
    @Test
    void 우승한_차량이_두_대_이상() {
        assertWithMockedRandomNumberGenerator(7, () -> {
            // when
            CarRecord winners = CarRecordFactory.createEmptyCarRecord(rule);
            Car w1 = CarFactory.car(rule, "w1");
            Car w2 = CarFactory.car(rule, "w2");
            Car w3 = CarFactory.car(rule, "w3");
            for (int i = 0; i < laps; i++) {
                w1.moveForward();
                w2.moveForward();
                w3.moveForward();
            }
            winners.register(w1);
            winners.register(w2);
            winners.register(w3);
            carRecord.register(w1);
            carRecord.register(w2);
            carRecord.register(w3);
            // then
            assertThat(referee.announceAllWinners()).isEqualTo(winners.toString());
        });
    }

    /**
     * 모든 자동차들이 동일한 거리를 이동한다.
     */
    @Test
    void 모든_차량이_동일한_거리_이동() {
        assertWithMockedRandomNumberGenerator(4, () -> {
            for (int i = 0; i < laps; i++) {
                carRecord.moveForwardAllCars();
            }
            // then
            assertThat(referee.announceAllWinners()).isEqualTo(String.join(", ", names));
        });
    }

    /**
     * executable은 RandomNumberGenerator가 randomNumber를 반환하는 환경(별도의 스레드)에서 실행된다.
     */
    static void assertWithMockedRandomNumberGenerator(
            int randomNumber, final Executable executable) {
        assertInDifferentThread(() -> {
            try (final MockedStatic<RandomNumberGenerator> mocked = mockStatic(RandomNumberGenerator.class);) {
                // given
                mocked.when(() -> RandomNumberGenerator.pickRandomNumber(any()))
                        .thenReturn(randomNumber);
                // when && then
                executable.execute();
            } catch (Throwable e) {
                Assertions.fail(e.getMessage());
            }
        });
    }

    static void assertInDifferentThread(final Executable executable) {
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1L), executable::execute);
    }

}
