package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.ExceptionCheck;
import racingcar.domain.Judgment;
import racingcar.domain.NumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    static ExceptionCheck err = new ExceptionCheck();
    public static void main(String[] args) {
        List<String> carNames = askCar();
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        int count = askCount();
        NumberGenerator numberGenerator = new NumberGenerator();
        Judgment judgment = new Judgment();

        progressOutput(count,numberGenerator,carNames,judgment,carList);
        resultOutput(judgment,carList);
    }

    private static void resultOutput(Judgment judgment, List<Car> carList) {
        String winner = judgment.carRaceWinner(carList);
        System.out.print("최종 우승자 : "+winner);
    }

    private static void progressOutput(int count, NumberGenerator numberGenerator, List<String> carNames, Judgment judgment, List<Car> carList) {
        System.out.println();
        System.out.println("실행결과");
        for(int i = 0; i < count; i++) {
            List<Integer> randomNumber = numberGenerator.createRandomNumber(carNames.size());
            judgment.horseMove(randomNumber, carList);
            System.out.println();
        }
    }

    private static List<String> askCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> input = Arrays.asList(Console.readLine().split(","));
        err.isDuplicate(input);
        for (String carName : input) {
            err.isOverSizeCarName(carName);
            err.isNull(carName, "자동차의 이름이");
        }
        return input;
    }

    private static int askCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        err.isNull(input, "횟수가");
        err.isStr(input);
        return Integer.parseInt(input);
    }
}
