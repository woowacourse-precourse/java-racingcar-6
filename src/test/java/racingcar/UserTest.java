package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @DisplayName("잘못된 입력값 확인")
    @Test
    void inputCheckError() {
        //given
        List<User> users1 = new ArrayList<>();
        List<User> users2 = new ArrayList<>();
        List<User> users3 = new ArrayList<>();
        User user = new User();

        //when
        users1.add(new User("abcdef", 0));
        users2.add(new User(" ", 0));
        users3.add(new User(null, 0));

        //then
        Assertions.assertThatThrownBy(() -> user.inputCheck(users1)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> user.inputCheck(users2)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> user.inputCheck(users3)).isInstanceOf(IllegalArgumentException.class);
    }


}