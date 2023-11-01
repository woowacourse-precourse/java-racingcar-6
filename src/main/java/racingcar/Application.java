package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // 자동차 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carNames = Console.readLine();
        Validator.validateHasAtLeastOneCharacter(carNames);
        Validator.validateNoSpacesBetweenCommas(carNames);

        ArrayList<Car> cars = Arrays.stream(carNames.split(","))
                .map(name -> new Car(name))
                .collect(Collectors.toCollection(ArrayList::new));

        // 시도 횟수 입력
        System.out.println("시도할 회수는 몇회인가요?");

        String tryCountInput = Console.readLine();
        Validator.validateHasAtLeastOneCharacter(tryCountInput);
        Validator.validateOnlyNumber(tryCountInput);

        Integer tryCount = Integer.parseInt(tryCountInput);
        Validator.validateWithinRange(tryCount);

        // 게임 생성
        Game game = new Game(cars);

        // 게임 진행
        for (int i = 0; i < tryCount; i++) {
            game.play();
            printScoreBoard(cars);
        }

        // 우승자 결정
        ArrayList<Car> winners = game.pickWinners();
        printWinners(winners);
    }

    private static void printScoreBoard(ArrayList<Car> cars) {
        cars.stream().forEach(c -> System.out.println(c.toString()));
        System.out.println();
    }

    private static void printWinners(ArrayList<Car> cars) {
        StringJoiner joiner = new StringJoiner(", ");
        for (Car car : cars) {
            joiner.add(car.getName());
        }
        System.out.println("최종 우승자 : " + joiner);
    }
}
