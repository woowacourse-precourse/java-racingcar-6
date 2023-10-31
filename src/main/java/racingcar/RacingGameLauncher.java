package racingcar;

import java.util.stream.IntStream;
import racingcar.utils.Phrases;
import racingcar.utils.UserInput;

public final class RacingGameLauncher {
    private final RacingBoard racingBoard = new RacingBoard();
    private final String[] userInput;

    public RacingGameLauncher() {
        this.userInput = UserInput.racingCarsName();
    }

    private void addRacingCar() {
        for (String carName : userInput) {
            racingBoard.addRacingCar(new RacingCar(carName));
        }
    }

    private void winner() {
        System.out.print(Phrases.winner);
        System.out.println(this.racingBoard.carsWithMaxDistance());
    }

    public void racingGameStart() {

        final int racingTimes = UserInput.racingTimes();

        addRacingCar();
        System.out.println("\n" + Phrases.racing);

        IntStream.range(0, racingTimes)
                 .forEach(car -> racingBoard.racingCarsMove());

        winner();
    }
}
