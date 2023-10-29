package racingcar.core.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {
    private Validator validator;
    private NamesParser parser;
    @BeforeEach
    void beforeEach() {
        validator = new Validator();
        parser = new NamesParser();
    }
    @Test
    @DisplayName("이름이 정상적으로 입력된 경우")
    void 이름이_정상적으로_입력된_경우() throws Exception {
        //given
        String userInput = "car1,car2,car3";
        //when
        List<String> parsingList = parser.parsing(userInput);
        //then
        assertThat(parsingList.size()).isEqualTo(3);
        assertThat(parsingList).containsExactly("car1", "car2", "car3");
    }

    @Test
    @DisplayName("이름이 5자 이상인 경우")
    void 이름이_5자_이상인_경우() throws Exception {
        //given
        String userInput = "car1,car2,carcarcar";
        //when
        List<String> parsingList = parser.parsing(userInput);
        //then
        assertThatThrownBy(() -> validator.valid(parsingList))
                .isInstanceOf(IllegalArgumentException.class);
    }

}