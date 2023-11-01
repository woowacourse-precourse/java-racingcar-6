package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Player;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("자동차, 횟수 모두 바르게 입력함")
    public void isInputPerfect() {
        new Player("jenny,lisa,rose", "4");
    }

    @Test
    @DisplayName("자동차 이름의 길이가 5가 넘도록 입력함")
    public void carNameShouldNotBeLongerThan5() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Player("abcdef,lisa", "4");
        });
    }

    @Test
    @DisplayName("자동차 이름의 길이에 알파벳 외의 기호가 포함됨")
    public void carNameShouldHaveOnlyAlphabets_1() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Player("jenny,amy!,rose", "4");
        });
    }
    @Test
    @DisplayName("자동차 이름의 길이에 알파벳 외의 숫자가 포함됨")
    public void carNameShouldHaveOnlyAlphabets_2() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Player("jenny,amy0,rose", "4");
        });
    }

    @Test
    @DisplayName("자동차 이름의 길이에 알파벳 외의 한글이 포함됨")
    public void carNameShouldHaveOnlyAlphabets_3() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Player("jenny,amㄱy,rose", "4");
        });
    }

    @Test
    @DisplayName("횟수를 잘못 입력함")
    public void timesShouldBeAtLeast1() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Player("amy,lisa", "0");
        });
    }

}