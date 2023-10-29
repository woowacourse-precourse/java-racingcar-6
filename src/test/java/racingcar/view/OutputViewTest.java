package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RaceHistory;
import racingcar.testutils.MyTest;

@SuppressWarnings("NonAsciiCharacters")
public class OutputViewTest extends MyTest {

    @Test
    void 게임_결과를_출력할_수_있다() throws Exception {
        // given
        List<Car> cars = List.of(new Car("car1"), new Car("car2"), new Car("car3"));
        RaceHistory raceHistory = new RaceHistory(cars);

        Field positionHistoryField = RaceHistory.class.getDeclaredField("positionHistory");
        positionHistoryField.setAccessible(true);
        positionHistoryField.set(raceHistory, List.of(List.of(1, 0, 0), List.of(2, 0, 1)));

        // when
        new OutputView().printRaceHistory(raceHistory);

        // then
        assertThat(output()).isEqualTo("""
                                
                실행 결과
                car1 : -
                car2 :\s
                car3 :\s
                                
                car1 : --
                car2 :\s
                car3 : -
                                
                """);
    }

    @Test
    void 우승자를_출력할_수_있다() {
        OutputView outputView = new OutputView();

        outputView.printWinners(List.of("car1", "car2"));

        assertThat(output()).isEqualTo("""
                최종 우승자 : car1, car2
                """);
    }
}
