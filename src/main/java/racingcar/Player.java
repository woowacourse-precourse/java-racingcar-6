package racingcar;

import java.util.List;

public class Player {
    protected static class RacingCar {
        String name;
        int distance;
    }

    protected static void getPlayer(String input, List<RacingCar> player) {
        splitPlayer(input, player);
    }

    private static void splitPlayer(String input, List<RacingCar> player) {
        String[] splitInput = input.split(",");
        for (int i = 0; i < splitInput.length; i++) {
            CheckInput.checkIsUnique(splitInput[i], player);
            addPlayer(splitInput[i], player);
        }
    }

    private static void addPlayer(String name, List<RacingCar> player) {
        RacingCar racingCar = new RacingCar();
        racingCar.name = name;
        racingCar.distance = 0;
        player.add(racingCar);
    }
}
