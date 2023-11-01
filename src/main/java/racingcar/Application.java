package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static racingcar.Car.generateCars;
import static racingcar.GameResult.findWinner;
import static racingcar.RandomStepForward.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNamesBeforeGenerateCar = Validator.splitNames(input);
        List<Car> carsList = generateCars(carNamesBeforeGenerateCar);

        System.out.println("시도할 회수는 몇회인가요?");
        String roundCount = Console.readLine();

        if (roundCount == null) throw new IllegalArgumentException();
        int numberOfRounds = Integer.parseInt(roundCount);

        System.out.println("실행결과");
        for(int i = 0; i < numberOfRounds; i++) {
            playGames(carsList);
            printResultOfRound(carsList);
            System.out.println();
        }
        if (findWinner(carsList).size() == 1) {
            System.out.println("최종 우승자 : " + findWinner(carsList).get(0).getName());
        } else {
            ArrayList<String> winnerNames = new ArrayList();
            findWinner(carsList).forEach(car -> {
                winnerNames.add(car.getName());
            });
            System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
        }
    }
}
