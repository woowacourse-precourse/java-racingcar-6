package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public final class RacingGame {
    private static final RacingGame racingGame = new RacingGame();
    private final RaceResult raceResult = new RaceResult();
    private Cars cars;

    private RacingGame(){
    }

    public static RacingGame getInstance() {
        return racingGame;
    }

    public void startGame() {
        String names = receiveCarNames();
        int raceCount = receiveRaceCount();
        cars = Cars.getCarsFromNames(names);

        playGame(raceCount);
    }

    private void playGame(int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            cars = cars.race();
            System.out.println(raceResult.getRaceProgress(cars.carList()));
        }
        List<Car> winnerList = cars.findWinners();
        System.out.println(raceResult.getWinners(winnerList));
    }

    private int receiveRaceCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private String receiveCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }
}
