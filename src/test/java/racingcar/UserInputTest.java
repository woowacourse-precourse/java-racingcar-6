package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.util.User;

class UserInputTest {
    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void 입력받은_자동차_이름_마지막에_콤마가_있는지_테스트() {
        String input1 = "test1,test2,test3";
        String input2 = "test1,test2,,test3";
        String input3 = "test1,test2,test3,";
        String input4 = ",";

        Assertions.assertThatCode(() -> user.checkLastComma(input1)).doesNotThrowAnyException();
        Assertions.assertThatCode(() -> user.checkLastComma(input2)).doesNotThrowAnyException();
        assertThatThrownBy(() -> user.checkLastComma(input3))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> user.checkLastComma(input4))
                .isInstanceOf(IllegalArgumentException.class);

    }
}