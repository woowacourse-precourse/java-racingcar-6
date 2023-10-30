package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {


    @DisplayName("게임 실행 테스트")
    @Test
    void playGame() {
    }

    @DisplayName("우승자를 출력")
    @Test
    void printWinner() {
    }

    @DisplayName("가장 멀리 전진한 자동차 찾기")
    @Test
    void findWinner() {
        //given
        List<User> users = new ArrayList<>();
        users.add(new User("abc", 3));
        users.add(new User("qwer", 5));

        //when
        int max = Game.findWinner(users);

        //then
        assertThat(max).isEqualTo(5);
    }

    @DisplayName("0~9중 한 값을 반환한다.")
    @Test
    void randomNumber() {
        //given
        int number = 0;

        //when
        number = Game.randomNumber();

        //then
        assertThat(number).isBetween(0, 9);
    }

    @DisplayName("")
    @Test
    void moveForward() {
    }

    @Test
    void printRacing() {
    }
}