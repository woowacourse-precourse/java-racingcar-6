package racingcar.core.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NamesParserTest {
    private NamesParser parser;

    @BeforeEach
    void beforeEach() {
        parser = new NamesParser();
    }
    @Test
    @DisplayName("이름을 빈칸으로 입력한 경우")
    void 이름을_빈칸으로_입력한_경우() throws Exception {
        //given
        String userInput1 = "car1,car2,"; // 공백 X
        String userInput2 = "car1,car2, "; // 공백 O

        //when and then
        assertThatThrownBy(() ->
                parser.parsing(userInput1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                parser.parsing(userInput2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름을 생략한 경우")
    void 이름을_생략한_경우() throws Exception {
        //given
        String userInput = "car1,,,,,car2";
        //when and then
        assertThatThrownBy(() ->
                parser.parsing(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("처음을 생략한 경우")
    void 처음을_생략한_경우() throws Exception {
        //given
        String userInput1 = ",car1,car2";
        String userInput2 = ",,,,,car1,car2";
        String userInput3 = ", ,car1,car2";
        //when and then
        assertThatThrownBy(() ->
                parser.parsing(userInput1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                parser.parsing(userInput2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                parser.parsing(userInput3))
                .isInstanceOf(IllegalArgumentException.class);
    }

}