package racingcar.user;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user = new User();
    @Test
    void 이름에_쉼표_2개_들어간_경우() {
        String input = "abc,,aab";
        ByteArrayInputStream testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);
        assertThatThrownBy(user::carNameInput)
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 이름끝에_쉼표_들어간_경우() {
        String input = "abc,aab,";
        assertThat(input.split(",")).containsExactly("abc","aab");
    }
    @Test
    void 이름끝에_쉼표_들어간_경우_메서드(){
        String input = "abc,aab,";
        ByteArrayInputStream testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);
        assertThat(user.carNameInput()).containsExactly("abc","aab");
    }
    @Test
    void 쉼표로_시작되는_경우() {
        String input = ",abc,aab,";
        assertThat(input.split(",")).containsExactly("","abc","aab");
    }
    @Test
    void 쉼표로_시작되는_경우_메서드(){
        String input = ",abc,aab,";
        ByteArrayInputStream testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);
        assertThatThrownBy(user::carNameInput)
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 중복되는_입력인_경우(){
        String input = "abc,abc";
        ByteArrayInputStream testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);
        assertThatThrownBy(user::carNameInput)
                .isInstanceOf(IllegalArgumentException.class);
    }

}