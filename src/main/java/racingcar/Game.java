package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Game extends GameManager {
    public static void playGame(List<RacingCar> player, int numberTrials) {
        for (int i = 0; i < numberTrials; i++) {
            movingOrStop(player);
        }
    }

    private static void movingOrStop(List<RacingCar> player) {
        for (int i = 0; i < player.size(); i++) {
            int movingOrNot = Randoms.pickNumberInRange(0, 9);
            if (movingOrNot > 3) {
                RacingCar racingCar = new RacingCar();
                racingCar.name = player.get(i).name;
                racingCar.distance = player.get(i).distance + 1;
                player.set(i, racingCar);
            }
        }
    }
}
