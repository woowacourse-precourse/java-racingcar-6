package racingcar.services;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class RaceRoundSimulator {

    public static void execute(RaceGameState state) {
        Map<String, Integer> stateOfEachCar = state.getStateOfEachCar();
        stateOfEachCar
                .keySet()
                .stream()
                .filter(targetName -> goForward())
                .forEach(state::moveForwardByName);

        printCurrentProgress(state);
    }


    private static void printCurrentProgress(RaceGameState currentState) {
        System.out.println(currentState);
    }

    private static int generateZeroToNineRandomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private static boolean goForward() {
        return generateZeroToNineRandomValue() >= 4;
    }

}
