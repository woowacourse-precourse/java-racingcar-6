package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.constant.CarRacingErrorMessage.CAR_NAME_BLANK_ERROR_MESSAGE;
import static racingcar.constant.CarRacingErrorMessage.CAR_NAME_LENGTH_ERROR_MESSAGE;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Referee;
import racingcar.domain.Turn;
import racingcar.domain.Winners;
import racingcar.io.CarRacingOutputProcessor;

public class RacingCarTest {

    @Test
    void 자동차_객체_생성_기능_단일() {
        Car car = Car.fromName("john");
        assertThat("john").isEqualTo(car.getName());
        assertThat(0).isEqualTo(car.getPosition());
    }

    @Test
    void 자동차_정보_입력_기능_단체() {
        String carNames = "jamy,risa,jun";
        Cars cars = Cars.fromCarNames(carNames);
        List<Car> currentStatus = cars.getCurrentStatus();

        Assertions.assertEquals(currentStatus.get(0).getName(), "jamy");
        Assertions.assertEquals(currentStatus.get(1).getName(), "risa");
        Assertions.assertEquals(currentStatus.get(2).getName(), "jun");
    }

    @Test
    void 자동차_이름_길이_5자_제한_기능_단일() {
        List<String> fiveLengthOverName = List.of("abcdef", "aifhiawkgha", "awhdfaighkwuhgakhgka", "asdfakhfkah",
                "adwlafla");
        for (String name : fiveLengthOverName) {
            assertThatThrownBy(() -> Car.fromName(name))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    @Test
    void 자동차_이름_길이_5자_제한_기능_단체() {
        String carNames = "jamiiaa,risa,jun";
        assertThatThrownBy(() -> Cars.fromCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_LENGTH_ERROR_MESSAGE);
    }

    @Test
    void 자동차_이름_예외_공백() {
        List<String> blankCarNames = List.of("", " ", " , ", ",", ", ", " ,");
        for (String blankCarName : blankCarNames) {
            assertThatThrownBy(() -> Cars.fromCarNames(blankCarName))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CAR_NAME_BLANK_ERROR_MESSAGE);
        }
    }

    @Test
    void 이동_시도_횟수_입력() {
        Turn turn = Turn.fromTryCount("1");
        assertThat(1).isEqualTo(turn.getCount());
    }

    @Test
    void 이동_시도_횟수_입력_실패_문자열_처리() {
        assertThatThrownBy(() -> Turn.fromTryCount("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동_시도_횟수_입력_실패_공백_처리() {
        List<String> blanks = List.of(" ", "");
        for (String blank : blanks) {
            assertThatThrownBy(() -> Turn.fromTryCount(blank))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void 이동_시도_출력_형식() {
        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            String carNames = "jamy,risa,jun";
            Cars cars = Cars.fromCarNames(carNames);

            CarRacingOutputProcessor outputProcessor = new CarRacingOutputProcessor();
            for (Car car : cars.tryToMove()) {
                outputProcessor.printCarPosition(car.getName(), car.getPosition());
            }

            List<String> expectedOutputs = List.of("jamy : ", "risa : ", "jun : ");
            String actualOutput = outputStream.toString();

            assertThat(actualOutput).contains(expectedOutputs);


        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void 자동차_현위치_출력() {
        PrintStream originalOut = System.out;
        CarRacingOutputProcessor outputProcessor = new CarRacingOutputProcessor();
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            Car car1 = Car.fromName("car1");
            Car car2 = Car.fromName("car2");
            Car car3 = Car.fromName("car3");
            car2.move();
            car3.move();
            car3.move();
            List<Car> cars = new ArrayList<>(List.of(car1, car2, car3));

            for (Car car : cars) {
                outputProcessor.printCarPosition(car.getName(), car.getPosition());
            }

            String expectedOutput = """
                    car1 :\s
                    car2 : -
                    car3 : --
                    """;
            String actualOutput = outputStream.toString();

            assertThat(actualOutput).isEqualTo(expectedOutput);


        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void 우승자_도출() {

        Car car1 = Car.fromName("car1");
        Car car2 = Car.fromName("car2");
        Car car3 = Car.fromName("car3");
        car2.move();
        car3.move();
        List<Car> cars = new ArrayList<>(List.of(car1, car2, car3));

        Referee referee = new Referee();
        Winners winners = referee.judgeWinners(cars);

        assertThat(winners.getWinners()).containsOnly(car2, car3);
    }

    @Test
    void 우승자_출력() {
        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));
            CarRacingOutputProcessor outputProcessor = new CarRacingOutputProcessor();

            Car car1 = Car.fromName("car1");
            Car car2 = Car.fromName("car2");
            Car car3 = Car.fromName("car3");
            car1.move();
            car2.move();
            List<Car> cars = new ArrayList<>(List.of(car1, car2, car3));

            Referee referee = new Referee();
            Winners winners = referee.judgeWinners(cars);

            outputProcessor.printWinners(winners.getWinners());

            String expectedOutput = "최종 우승자 : car1, car2";
            String actualOutput = outputStream.toString().trim();

            assertThat(actualOutput).isEqualTo(expectedOutput);
        } finally {
            System.setOut(originalOut);
        }
    }
}
