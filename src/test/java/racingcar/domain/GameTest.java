package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void createdCars_이름이_5자_넘는_경우_예외_발생() throws Exception {
        Game game = new Game();
        String carNames = "aaa,bbb,ccc,dddddd";
        String[] split = carNames.split(",");
        assertThrows(IllegalArgumentException.class, () -> game.createCars(Arrays.asList(split)));
    }
    
    @Test
    void setRound_라운드가_숫자가_아닌_경우_예외_발생() throws Exception {
        Game game = new Game();
        String round = "a";
        assertThrows(IllegalArgumentException.class, () -> game.setRound(round));
    }
}
