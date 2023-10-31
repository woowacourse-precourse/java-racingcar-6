package racingcar;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingGame;
import racingcar.util.StringToIntParser;
import racingcar.util.StringToListParser;

import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = StringToListParser.parseToList(readLine(), ",");
        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = StringToIntParser.parseToInt(readLine());

        List<RacingCar> cars = createCars(carNames);
        RacingGame game = new RacingGame(cars, tryCount);

        System.out.println("\n실행 결과");
        while (!game.isFinish()) {
            game.moveAllCars();
            System.out.println(getStatusDescription(game));
        }
        System.out.println("최종 우승자 : " + getWinnerNames(game));
    }

    private static List<RacingCar> createCars(List<String> carNames) {
        return carNames.stream().map(RacingCar::new).toList();
    }

    private static String getStatusDescription(RacingGame game) {
        return game.getCars().stream().map(RacingCar::getDescription).collect(Collectors.joining("\n")) + "\n";
    }

    private static String getWinnerNames(RacingGame game) {
        return game.getWinners().stream().map(RacingCar::getName).collect(Collectors.joining(", "));
    }
}
