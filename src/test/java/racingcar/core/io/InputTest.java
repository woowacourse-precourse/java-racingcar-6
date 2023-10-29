package racingcar.core.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    @DisplayName("정상값을 입력한 경우")
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

    /**
     * 현재 사용되는 readline() 메소드가 싱글톤 Scanner를 사용중이고,
     * Console를 직접 수정 할 수 없어서 input 객체의 readline만을 사용하여 테스트하기에는 제약이 있음.
     * 따라서 parser 테스트에서 깊이 있는 예외 케이스를 검증하도록 하겠음.
     */
}