package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.InputValidator;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Racing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        HashMap<String, String> carNames = carNames();
        int numberOfMoves = moves();

        for (int i = 0; i < numberOfMoves; i++) {
            carNames = Racing.raceSimulation(carNames);
            System.out.println(carNames);
        }
    }


    private static HashMap<String, String> carNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        HashMap<String, String> namesMap = InputValidator.validateNames(input);
        return namesMap;
    }

    private static int moves() {
        System.out.println("시도할 회수는 몇회인가요?");
        String moves = Console.readLine();

        int validatedNumberOfMoves = InputValidator.validateMoves(moves);
        return validatedNumberOfMoves;
    }

}


