package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.domain.Winner;
import racingcar.utils.InputValidator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Race race = prepareRace();
        performRacing(race);
        declareWinners(race);
    }

    private static Race prepareRace() {
        String carNames = getCarNames();
        int raceCount = getRaceCount();

        return new Race(carNames, raceCount);
    }

    private static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        InputValidator.validateCarNames(carNames);
        return carNames;
    }

    private static int getRaceCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String raceCountInput = Console.readLine();
        InputValidator.validateRaceCount(raceCountInput);
        return Integer.parseInt(raceCountInput);
    }

    private static void performRacing(Race race) {
        race.start();
    }

    private static void declareWinners(Race race) {
        List<String> winners = Winner.findWinners(race.getCars());
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
