package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.dto.CarStateDto;

class ConsoleOutputTest {
    private OutputStream captor;
    private Output output;

    @BeforeEach
    void init() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
        output = new ConsoleOutput();
    }

    @AfterEach
    void cleanBuffer() {
        System.out.flush(); //출력버퍼 비우기
    }

    @Test
    @DisplayName("자동차 이름 입력 문구 출력")
    void print_car_names_input_request() {
        output.printCarNamesInputRequest();
        assertThat(getOutput()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    @DisplayName("시도할 횟수 입력 문구 출력")
    void print_move_count_input_request() {
        output.printMoveCountInputRequest();
        assertThat(getOutput()).contains("시도할 회수는 몇회인가요?");
    }

    @Test
    @DisplayName("결과 출력 시작 문구 출력")
    void print_result_started() {
        output.printResultStartedMessage();
        assertThat(getOutput()).contains("\n실행 결과");
    }

    @ParameterizedTest
    @CsvSource(value = {"0", "1", "5", "10", "100", "1000"})
    @DisplayName("자동차 이동상태 출력")
    void print_car_state(int path) {
        //given
        List<CarStateDto> dtoList = new ArrayList<>();
        dtoList.add(new CarStateDto("붕붕카", path));

        //when
        output.printCarsState(dtoList);

        //then
        assertThat(getOutput()).contains("붕붕카 : " + "-".repeat(path));
    }

    String getOutput() {
        return captor.toString();
    }
}