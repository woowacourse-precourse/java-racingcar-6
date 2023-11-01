package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {
    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

//    @AfterEach
//    void restoreSystemInStream() {
//        System.setIn(System.in);
//    }

    @Test
    void input_정상_입력() {
        String input = "car1,car2\n3\n";
        provideInput(input);
        user.input();

        assertThat(user.getCarNames()).containsExactly("car1", "car2");
        assertThat(user.getMap()).containsKeys("car1", "car2");
        assertThat(user.getTryNum()).isEqualTo(3);
    }

    @Test
    void input_5자리_이상_입력() {
        String input = "car111,car222\n3\n";
        provideInput(input);

        assertThatThrownBy(() -> user.input())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자리 이하만 가능합니다.");
    }

    @Test
    void input_횟수_숫자_이외_입력() {
        String input = "car1,car2\na\n";
        provideInput(input);

        assertThatThrownBy(() -> user.input())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 숫자만 입력 가능합니다.");
    }

    private void provideInput(String input) {
        InputStream test = new ByteArrayInputStream(input.getBytes());
        System.setIn(test);
    }
}