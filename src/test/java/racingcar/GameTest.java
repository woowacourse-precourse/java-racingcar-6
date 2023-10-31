package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {


    @DisplayName("가장 멀리 전진한 자동차 찾기")
    @Test
    void findWinner() {
        //given
        Game game = new Game();
        List<User> users = new ArrayList<>();
        users.add(new User("abc", 3));
        users.add(new User("qwer", 5));

        //when
        int max = game.findWinner(users);

        //then
        assertThat(max).isEqualTo(5);
    }

    @DisplayName("0~9중 한 값을 반환한다.")
    @Test
    void randomNumber() {
        //given
        Game game = new Game();

        //when
        int number = game.randomNumber();

        //then
        assertThat(number).isBetween(0, 9);
    }

    @DisplayName("무작위 값이 4보다 크면 전진")
    @Test
    void moveForward() {
        //given
        Game game = new Game();
        User a = new User("a", 4);
        User b = new User("b", 6);

        //when
        game.moveForward(3, a);
        game.moveForward(7, b);

        //then
        assertThat(a.length).isEqualTo(4);
        assertThat(b.length).isEqualTo(7);
    }

}