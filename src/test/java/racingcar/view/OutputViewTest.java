package racingcar.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.constant.InputViewTestConstant.CarNameTest.SUCCESSFUL_CAR_NAMES_LIST;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

@DisplayName("출력 테스트")
class OutputViewTest {
    private final static int MOVEMENT_TIME = 4;
    private final static OutputView outputView = new OutputView();
    private static Cars cars;

    @BeforeAll
    static void init() {
        makeCarList();
        race();
    }

    private static void makeCarList() {
        cars = new Cars(SUCCESSFUL_CAR_NAMES_LIST);
    }

    private static void race() {
        for (int turn = 0; turn < MOVEMENT_TIME; turn++) {
            executeOneTurn();
        }
    }

    private static void executeOneTurn() {
        for (Car car : cars.getCarList()) {
            car.moveForward();
        }
    }

    @Nested
    @DisplayName("차수별 실행 결과 출력 테스트")
    class ExecutionResultsOrderTest extends NsTest {
        @Test
        @DisplayName("정상 작동")
        void printExecutionResultsOrderTest() {
            List<String> executionResult = getExecutionResult();
            assertSimpleTest(
                    () -> {
                        run();
                        assertThat(output()).contains(executionResult.stream().toArray(String[]::new));
                    }
            );
        }

        private List<String> getExecutionResult() {
            List<String> executionResult = new ArrayList<>();
            for (Car car : cars.getCarList()) {
                executionResult.add(String.format("%s : %s", car.getName(), "-".repeat(car.getForwards())));
            }
            return executionResult;
        }

        @Override
        protected void runMain() {
            outputView.printExecutionResultsOrder(cars.getCarList());
        }
    }

    @Nested
    @DisplayName("최종 우승자 출력 테스트")
    class FinalWinnerTest extends NsTest {
        @Test
        @DisplayName("정상 작동")
        void test() {
            String finalWinners = getFinalWinners();

            assertSimpleTest(
                    () -> {
                        run();
                        assertThat(output()).contains(finalWinners);
                    }
            );
        }

        private String getFinalWinners() {
            String finalWinners = cars.getMostForwardedCars().toString();
            finalWinners = finalWinners.substring(1, finalWinners.length() - 1);

            return finalWinners;
        }

        @Override
        protected void runMain() {
            outputView.printFinalWinners(cars.getMostForwardedCars());
        }
    }
}