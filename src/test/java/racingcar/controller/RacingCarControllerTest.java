package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

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
}