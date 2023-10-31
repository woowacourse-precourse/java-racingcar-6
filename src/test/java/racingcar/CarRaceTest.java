package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarRaceTest {

    @Test
    void contestantSignup_split() {
        CarRace carRace = new CarRace();
        String input = "c1,c2,c3,c4";
        String[] result = carRace.contestantSignup(input);

        assertThat(result).contains("c3","c2","c4","c1");
        assertThat(result).containsExactly("c1","c2","c3","c4");
    }

    @Test
    void contestantSignup_noSplit() {
        CarRace carRace = new CarRace();
        String input = "c1";
        String[] result = carRace.contestantSignup(input);

        assertThat(result).contains("c1");
        assertThat(result).containsExactly("c1");
    }

    @Test
    void goStop() {
        CarRace carRace = new CarRace();
        int previousRound = 5;
        int result = carRace.goStop(previousRound);
        assertTrue(result >= 5);
    }

    @Test
    void showCurrentRound() {
        CarRace carRace = new CarRace();
        int previousRound = 3;
        String contestant = "참가자1";
        int result = carRace.showCurrentRound(contestant, previousRound);
        assertTrue(result >= 3);
    }

    @Test
    void nameCheck() {
        CarRace carRace = new CarRace();
        String input = "abcdef";

        assertThatThrownBy(() -> carRace.nameCheck(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름 길이가 5를 초과할 수 없습니다.");
    }

    @Test
    void theWinnerIs_single() {
        CarRace carRace = new CarRace();
        String[] contestants = {"참가자1", "참가자2", "참가자3"};
        int[] move = {3, 4, 5};
        String[] result = new String[]{"참가자3"};
        assertThat(result).contains(carRace.theWinnerIs(contestants, move));
    }

    @Test
    void theWinnerIs_multiple() {
        CarRace carRace = new CarRace();
        String[] contestants = {"참가자1", "참가자2", "참가자3", "참가자4"};
        int[] move = {5, 4, 5, 5};
        String[] result = new String[]{"참가자1", "참가자3", "참가자4"};
        assertThat(result).contains(carRace.theWinnerIs(contestants, move));

    }
}