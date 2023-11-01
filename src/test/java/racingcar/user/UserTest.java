package racingcar.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
//    User user;
//    @BeforeEach
//    void 객체_생성(){
//        user = new User();
//    }
//    @AfterEach
//    void 입력_복원(){
//        System.setIn(System.in);
//        System.out.println(System.out);
//    }
    private User user;
    @BeforeEach
    void setUp(){
        user = new User();
    }
    @Test
    void 이름에_쉼표_2개_들어간_경우() {
//        User user = new User();
        String input = "abc,,aab";
        ByteArrayInputStream testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);
        assertThatThrownBy(user::carNameInput)
                .isInstanceOf(IllegalArgumentException.class);
//        System.setIn(System.in);
    }
    @Test
    void 이름끝에_쉼표_들어간_경우() {
        String input = "abc,aab,";
        assertThat(input.split(",")).containsExactly("abc","aab");
    }
    @Test
    void 이름끝에_쉼표_들어간_경우_메서드(){
//        User user = new User();
        String input = "abc,aab,";
        ByteArrayInputStream testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);
        assertThat(user.carNameInput()).containsExactly("abc","aab");
        System.setIn(System.in);
    }
    @Test
    void 쉼표로_시작되는_경우() {
        String input = ",abc,aab,";
        assertThat(input.split(",")).containsExactly("","abc","aab");
    }
    @Test
    void 쉼표로_시작되는_경우_메서드(){
//        User user = new User();
        String input = ",abc,aab,";
        ByteArrayInputStream testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);
        assertThatThrownBy(user::carNameInput)
                .isInstanceOf(IllegalArgumentException.class);
        System.setIn(System.in);
    }
    @Test
    void 중복되는_입력인_경우(){
//        User user = new User();
        String input = "abc,abc";
        ByteArrayInputStream testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);
        assertThatThrownBy(user::carNameInput)
                .isInstanceOf(IllegalArgumentException.class);
        System.setIn(System.in);
    }
    @Test
    void Round에_숫자입력(){
//        User user = new User();
        String input = "123";
        ByteArrayInputStream testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);
        assertThat(user.gameRoundInput())
                .isEqualTo(123);
        System.setIn(System.in);
    }
    @Test
    void Round에_숫자아닌값_입력(){
//        User user = new User();
        String input = "123,";
        ByteArrayInputStream testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);
        assertThatThrownBy(user::gameRoundInput)
                .isInstanceOf(IllegalArgumentException.class);
        System.setIn(System.in);
    }
}