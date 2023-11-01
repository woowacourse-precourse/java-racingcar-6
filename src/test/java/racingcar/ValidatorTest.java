package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    private final Validator validator = new Validator();

    @Test
    void String_이름에_대한_미입력_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkStringCarNames(""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void String_이름에_대한_공백_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkStringCarNames("pobi,"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void List_이름에_대한_5글자초과_처리(){
        List<String> input = List.of("pobi","javaij");

        assertSimpleTest(() ->
                assertThatThrownBy(() -> validator.checkListCarNames(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void List_이름에_대한_중복_처리(){
        List<String> input = List.of("pobi","pobi");

        assertSimpleTest(()->
                assertThatThrownBy(()->validator.checkListCarNames(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void List_이름에_대한_공백_처리(){
        List<String> input = List.of("pobi,bba i,javai");

        assertSimpleTest(()->
                assertThatThrownBy(()->validator.checkListCarNames(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수에_대한_미입력_처리(){
        assertSimpleTest(()->
                assertThatThrownBy(()->validator.checkTrial(""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수에_대한_문자입력_처리(){
        assertSimpleTest(()->
                assertThatThrownBy(()->validator.checkTrial("A"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}