package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    protected static class RacingCar {
        String name;
        int distance;
    }

    public static void newGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        List<RacingCar> player = new ArrayList<>();

        splitPlayer(input, player);
        CheckInput.checkLength(player);

        for (RacingCar racingCar : player) {
            System.out.println(racingCar.name + " : ");
        }
        System.out.println("이름 쉼표로 나누기");
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
