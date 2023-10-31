package racingcar;

import java.util.List;

public class CheckInput extends GameManager {
    public static void checkLength(List<RacingCar> player) {
        for (int i = 0; i < player.size(); i++) {
            if (player.get(i).name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
