package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingCarControllerTest {
    private RacingCarController racingCarController;

    @BeforeEach
    void setUp() {
        racingCarController = new RacingCarController();
    }

    @Test
    void inputCarNames_올바른_입력일_때_입력_반환() {
        String testInput = "pobi,woni,jun";

        String result = racingCarController.inputCarNames(testInput);

        assertThat(result).isEqualTo("pobi,woni,jun");
    }

    @Test
    void inputCarNames_입력이_빈칸일_때_예외_발생() {
        String testInput = "";

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            racingCarController.inputCarNames(testInput);
        });

        assertThat(e.getMessage()).isEqualTo("빈칸은 이름이 될 수 없습니다.");
    }

    @Test
    void inputCarNames_가장_앞자리가_쉼표일_때_예외_발생() {
        String testInput = ",pobi,woni,jun";

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            racingCarController.inputCarNames(testInput);
        });

        assertThat(e.getMessage()).isEqualTo("빈칸은 이름이 될 수 없습니다.");
    }

    @Test
    void inputCarNames_가장_뒷자리가_쉼표일_때_예외_발생() {
        String testInput = "pobi,woni,jun,";

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            racingCarController.inputCarNames(testInput);
        });

        assertThat(e.getMessage()).isEqualTo("빈칸은 이름이 될 수 없습니다.");
    }

    @Test
    void splitCarNamesByComma_올바른_이름_목록일_때_목록_반환() {
        String testInput = "pobi,woni,jun";
        List<String> answerList = List.of("pobi", "woni", "jun");

        List<String> result = racingCarController.splitCarNamesByComma(testInput);

        assertThat(result).isEqualTo(answerList);
    }

    @Test
    void splitCarNamesByComma_구분자가_없을_때_목록_반환() {
        String testInput = "pobi";
        List<String> answerList = List.of("pobi");

        List<String> result = racingCarController.splitCarNamesByComma(testInput);

        assertThat(result).isEqualTo(answerList);
    }

    @Test
    void splitCarNamesByComma_빈칸_이름이_있을_때_예외_발생() {
        String testInput = "pobi,woni,,jun";

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            racingCarController.splitCarNamesByComma(testInput);
        });

        assertThat(e.getMessage()).isEqualTo("빈칸은 이름이 될 수 없습니다.");
    }

    @Test
    void createCarList_올바른_이름_목록일_때_자동차_목록_반환() {
        List<String> testList = List.of("pobi", "woni", "jun");

        List<Car> result = racingCarController.createCarList(testList);

        assertThat(result)
                .hasSize(3)
                .extracting(Car::getName, Car::getDistance)
                .containsExactly(tuple("pobi", 0), tuple("woni", 0), tuple("jun", 0));
    }

    @Test
    void createCarList_자동차_이름에_공백이_포함됐을_때_예외_발생() {
        List<String> testList = List.of("po bi", "woni", "jun");

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            racingCarController.createCarList(testList);
        });

        assertThat(e.getMessage()).isEqualTo("이름에 공백이 포함될 수 없습니다.");
    }

    @Test
    void createCarList_자동차_이름들이_중복됐을_때_예외_발생() {
        List<String> testList = List.of("pobi", "pobi", "jun");

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            racingCarController.createCarList(testList);
        });

        assertThat(e.getMessage()).isEqualTo("자동차 이름들은 중복될 수 없습니다.");
    }

    @Test
    void inputNumberOfTimes_올바른_입력일_때_횟수_반환() {
        String testInput = "5";

        int result = racingCarController.inputNumberOfTimes(testInput);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void inputNumberOfTimes_입력이_숫자가_아닐_때_예외_발생() {
        String testInput = "abc";

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            racingCarController.inputNumberOfTimes(testInput);
        });

        assertThat(e.getMessage()).isEqualTo("시도 횟수 입력이 숫자가 아닙니다.");
    }

    @Test
    void inputNumberOfTimes_입력이_음수일_때_예외_발생() {
        String testInput = "-5";

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            racingCarController.inputNumberOfTimes(testInput);
        });

        assertThat(e.getMessage()).isEqualTo("시도 횟수 입력이 숫자가 아닙니다.");
    }

    @Test
    void checkAtLeastFour_랜덤_숫자가_4_이상일_때_증가() {
        Car testCar = new Car("pobi", 0);

        racingCarController.checkAtLeastFour(testCar, 4);

        assertThat(testCar.getDistance()).isEqualTo(1);
    }

    @Test
    void checkAtLeastFour_랜덤_숫자가_4_미만일_때_그대로() {
        Car testCar = new Car("pobi", 0);

        racingCarController.checkAtLeastFour(testCar, 3);

        assertThat(testCar.getDistance()).isEqualTo(0);
    }

    @Test
    void checkEachCarForward_자동차_목록으로_경주했을_때_성공() {
        Cars testCars = new Cars(List.of("pobi", "woni", "jun"));
        List<Car> carList = testCars.getCars();

        racingCarController.updateEachCarForward(carList);

        assertThat(carList).hasSize(3);

        for (Car car : carList) {
            assertThat(car.getName()).isIn("pobi", "woni", "jun");
            assertThat(car.getDistance()).isGreaterThanOrEqualTo(0);
        }
    }

    @Test
    void findWinner_단독_우승자일_때_안내_문구() {
        List<Car> carList = List.of(new Car("pobi", 4), new Car("woni", 3), new Car("jun", 2));

        String result = racingCarController.getWinner(carList);

        assertThat(result).isEqualTo("pobi");
    }

    @Test
    void findWinner_공동_우승자일_때_안내_문구() {
        List<Car> carList = List.of(new Car("pobi", 4), new Car("woni", 4), new Car("jun", 2));

        String result = racingCarController.getWinner(carList);

        assertThat(result).isEqualTo("pobi, woni");
    }
}