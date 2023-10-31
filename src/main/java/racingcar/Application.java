package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameIO.printCarNamesInputMessage();
        String carNames = Console.readLine();
        Cars cars = new Cars(carNames);

        GameIO.printLapInputMessage();
        String lapSize = Console.readLine();
        Lap lap = new Lap(lapSize);

        RacingGame racingGame = new RacingGame(cars, lap);
        racingGame.play();
    }
}
