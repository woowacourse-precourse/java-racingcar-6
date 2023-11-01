package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.test.MyTest;

@SuppressWarnings("NonAsciiCharacters")
class OutputViewTest extends MyTest {

    @Test
    void 실행_결과_메세지를_출력할_수_있다() {
        new OutputView().printRaceResultMessage();
        assertThat(output()).isEqualTo("""
                
                실행 결과
                """);
    }

    @Test
    void 게임_결과를_출력할_수_있다() {
        List<Car> cars = List.of(
                new Car("car1", 3, null),
                new Car("car2", 0, null),
                new Car("car3", 2, null));

        new OutputView().printRaceResult(cars);

        assertThat(output()).isEqualTo("""
                car1 : ---
                car2 :\s
                car3 : --
                
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
