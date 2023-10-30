package study;

import java.util.ArrayList;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import racingcar.Model.Cars;

public class RacingGameTest {

    @Test
    @Disabled
    void 게임_출력_Test() {

        ArrayList<Cars> players = new ArrayList<>();
        Cars kim = new Cars("kim");
        Cars lee = new Cars("lee");
        Cars park = new Cars("park");
        players.add(kim);
        players.add(lee);
        players.add(park);
        //RacingGame.startRacing(players, 5);
    }
}
