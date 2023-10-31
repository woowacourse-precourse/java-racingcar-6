package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
}