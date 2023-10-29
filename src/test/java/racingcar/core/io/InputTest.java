package racingcar.core.io;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest {
    private Validator validator;
    private NamesParser parser;
    private Input input;

    @BeforeEach
    void beforeEach() {
        validator = new Validator();
        parser = new NamesParser();
        input = new Input(validator, parser);
    }

    @AfterEach
    void after() {
        Console.close();
    }

    @Test
    @DisplayName("정상 이름값들을 입력한 경우")
    void 정상값을_입력한_경우() throws Exception {
        // given
        String userInput = "car1,car2,car3";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // when
        List<String> names = input.readNames();

        // then
        assertThat(names).containsExactly("car1", "car2", "car3");
    }
    @Test
    @DisplayName("이름 값에 공백을 입력한 경우")
    void 이름_값에_공백을_입력한_경우() throws Exception {
        //given
        String userInput = "car1,car2,";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        // when and then
        assertThatThrownBy(() -> input.readNames())
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("이름값에 첫 글자를 생략한 경우")
    void 이름값에_첫_글자를_생략한_경우() throws Exception {
        //given
        String userInput = ",car1,car2";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        // when and then
        assertThatThrownBy(() -> input.readNames())
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("정상 반복 횟수를 입력한 경우")
    void 정상_반복_횟수를_입력한_경우() throws Exception {
        // given
        String userInput = "5";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        //when
        int tryNum = input.readTryNum();
        // then
        assertThat(tryNum).isEqualTo(5);
    }
    @Test
    @DisplayName("반복 횟수에 숫자가 아닌 값을 입력한 경우")
    void 반복_횟수에_숫자가_아닌_값을_입력한_경우() throws Exception {
        // given
        String userInput = "실패";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        //when and then
        assertThatThrownBy(() -> input.readTryNum())
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("반복 횟수에 공백을 입력한 경우")
    void 반복_횟수에_공백을_입력한_경우() throws Exception {
        // given
        String userInput = " ";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        //when and then
        assertThatThrownBy(() -> input.readTryNum())
                .isInstanceOf(IllegalArgumentException.class);
    }
}