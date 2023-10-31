package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PromptTest {

    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream(); // OutputStream 생성
        System.setOut(new PrintStream(outputMessage)); // 생성한 OutputStream 으로 설정
    }

    @AfterEach
    void afterEach() {
        Console.close();
        System.setOut(System.out); // 원상복귀
    }

    @Test
    @DisplayName("자동차의 이름들을 입력받는다.")
    void readCarNames() {
        //given
        String carNames = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(carNames.getBytes()));
        String[] carNameArray = new String[]{"pobi", "woni", "jun"};
        //when
        String[] result = Prompt.readCarNames();

        //then
        Assertions.assertThat(result).isEqualTo(carNameArray);
    }

    @Test
    @DisplayName("자동차의 이름은 5자 이하로 입력받는다.")
    void readCarNamesException() {
        String carNames = "iamcar,woni,jun";
        System.setIn(new ByteArrayInputStream(carNames.getBytes()));

        Assertions.assertThatThrownBy(() -> Prompt.readCarNames())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("경주에서 진행할 턴의 최대 횟수를 입력 받는다.")
    void readMaxTurn() {
        //given
        String input = "1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        Integer result = Prompt.readMaxTurn();

        //then
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("입력 받은 횟수는 숫자이어야 한다.")
    void readMaxTurnException() {
        //given
        String input = "a";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //then
        Assertions.assertThatThrownBy(() -> Prompt.readMaxTurn())
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("자동차의 현재 위치들을 출력한다.")
    void printCarPositions() {
        HashMap<String, Integer> cars = new HashMap<>();
        cars.put("pobi", 1);
        cars.put("woni", 2);

        Prompt.printCarPositions(cars);
        Assertions.assertThat(outputMessage.toString())
                .contains("pobi : -", "woni : --");
    }

    @Test
    @DisplayName("우승한 자동차 이름들을 출력한다.")
    void printWinners() {
        List<String> winners = Arrays.asList("pobi", "woni");

        Prompt.printWinners(winners);
        Assertions.assertThat(outputMessage.toString())
                .isEqualTo("최종 우승자 : pobi, woni");
    }
}