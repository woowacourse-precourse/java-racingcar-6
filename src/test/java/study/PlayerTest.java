package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Player;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("자동차, 횟수 모두 바르게 입력함")
    public void isInputPerfect() {
        Player player = new Player("jenny,lisa,rose", "4");
        List<Car> cars = player.getCars();
    }

    @Test
    @DisplayName("자동차 이름의 길이가 5가 넘도록 입력함")
    public void carNameShouldNotBeLongerThan5() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Player("abcdef,lisa", "4");
        });
    }

    @Test
    @DisplayName("횟수를 잘못 입력함")
    public void timesShouldBeAtLeast1() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Player("amy,lisa", "0");
        });
    }

    @Test
    @DisplayName("자동차 이름의 길이에 알파벳 외의 문자,기호가 포함됨")
    public void carNameShouldHaveOnlyAlphabets() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Player("jenny,amy!,rose", "4");
        });
    }

}