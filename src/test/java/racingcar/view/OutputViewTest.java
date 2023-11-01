package racingcar.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.mock.TestNumberGenerator;
import racingcar.model.Cars;

class OutputViewTest {

    OutputView outputView;

    @BeforeEach
    public void setUp() {
        outputView = new OutputView();
    }

    @Nested
    class printStatusTest extends NsTest {
        Cars cars;

        @Test
        public void 차수별_전진_상태가_출력된다() {
            List<String> names = Arrays.asList("Car1", "Car2");
            cars = new Cars(names, new TestNumberGenerator(5));

            cars.move();

            assertSimpleTest(() -> {
                run();
                assertThat(output()).contains(
                        "Car1 : -",
                        "Car2 : -"
                );
            });

        }

        @Override
        protected void runMain() {
            outputView.printStatus(cars.getStatus());
        }
    }


    @Nested
    class printWinnerTest extends NsTest {
        List<String> winners;

        @Test
        public void 최종_우승자가_출력된다() {
            winners = List.of("Car1", "Car2", "Car3");

            assertSimpleTest(() -> {
                run();
                assertThat(output()).contains(
                        "최종 우승자 : Car1, Car2"
                );

            });

        }

        @Override
        protected void runMain() {
            outputView.printWinner(winners);
        }
    }


}