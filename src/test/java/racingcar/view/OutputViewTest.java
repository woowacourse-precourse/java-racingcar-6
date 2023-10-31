package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.DTO.CarDTO;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {
    private final static OutputView OUTPUT_VIEW = new OutputView();
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("라운드가 시작한 후 라운드 결과 출력 확인")
    public void 라운드_결과_출력() {
        // given
        List<CarDTO> roundResult = Arrays.asList(
                new CarDTO("son", 2),
                new CarDTO("kim", 0),
                new CarDTO("lee", 1)
        );

        // when
        OUTPUT_VIEW.printPlayStart();
        OUTPUT_VIEW.printRoundResult(roundResult);

        // then
        Assertions.assertThat(getOutput()).contains("실행 결과", "son : --", "kim : ", "lee : -");
    }

    @Test
    @DisplayName("단독 우승자 출력 확인")
    public void 단독_우승자_출력() {
        // given
        List<CarDTO> finalRoundResult = Arrays.asList(new CarDTO("son", 2));

        // when
        OUTPUT_VIEW.printWinner(finalRoundResult);

        // then
        Assertions.assertThat(getOutput()).contains("최종 우승자 : ", "son");
    }

    @Test
    @DisplayName("공동 우승자 출력 확인")
    public void 공동_우승자_출력() {
        // given
        List<CarDTO> finalRoundResult = Arrays.asList(
                new CarDTO("son", 2),
                new CarDTO("kim", 2),
                new CarDTO("lee", 2)
        );

        // when
        OUTPUT_VIEW.printWinner(finalRoundResult);

        // then
        Assertions.assertThat(getOutput()).contains("최종 우승자 : ", "son", "kim", "lee");
    }

    public String getOutput() {
        return outputStream.toString();
    }
}