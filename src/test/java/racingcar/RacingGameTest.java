package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    @Test
    void move_테스트() {
        String[] carNames = {"Test_Car"};
        List<Car> cars = Car.createCars(carNames);

        int[] testNumbers = {1, 9, 6, 4, 3};

        for (int i = 0; i < testNumbers.length; i++) {
            int moveValue = testNumbers[i];
            for (Car car : cars) {
                car.move(moveValue);
            }

            // 각 단계에서 위치 검증
            if (i == 0) {
                assertThat(cars.get(0).getPosition()).isEqualTo(0); // 첫 번째 단계에서 Test_Car의 위치는 0
            }
            if (i == 1) {
                assertThat(cars.get(0).getPosition()).isEqualTo(1); // 두 번째 단계에서 Test_Car의 위치는 1
            }
            if (i == 2) {
                assertThat(cars.get(0).getPosition()).isEqualTo(2); // 세 번째 단계에서 Test_Car의 위치는 2
            }
            if (i == 3) {
                assertThat(cars.get(0).getPosition()).isEqualTo(3); // 네 번째 단계에서 Test_Car의 위치는 3
            }
            if (i == 4) {
                assertThat(cars.get(0).getPosition()).isEqualTo(3); // 네 번째 단계에서 Test_Car의 위치는 3
            }
        }
    }

    @Test
    void 화면에_표시_테스트() {
        String[] carNames = {"Test_Car"};
        List<Car> cars = Car.createCars(carNames);

        int[] testNumbers = {1, 9, 6, 4, 3};

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        for (int i = 0; i < testNumbers.length; i++) {
            int moveValue = testNumbers[i];
            for (Car car : cars) {
                car.move(moveValue);
            }
            displayResults(cars);
        }

        System.setOut(System.out);

        String expectedOutput = "Test_Car : \n\n" +
                "Test_Car : -\n\n" +
                "Test_Car : --\n\n" +
                "Test_Car : ---\n\n" +
                "Test_Car : ---\n\n";

        assertThat(outputStream.toString()).isEqualTo(expectedOutput);
    }

    private static void displayResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + generatePositionString(car.getPosition()));
        }
        System.out.println();
    }

    private static String generatePositionString(int position) {
        StringBuilder positionString = new StringBuilder();
        for (int i = 0; i < position; i++) {
            positionString.append("-");
        }
        return positionString.toString();
    }
}
