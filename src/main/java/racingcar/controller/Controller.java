package racingcar.controller;
import racingcar.model.Race;
import racingcar.view.View;
import java.util.List;

public class Controller {

    private Race race;
    private View raceView = new View();
    private Input input = new Input();
    private RaceContent raceContent;
    private RaceResult raceResult;

    public void startRace() {

        carInput();
        moveRace();
        winner();
    }

    private void carInput(){

        String carInput = raceView.startMeg();
        List<String> carNames = input.carInput(carInput);

        this.race = new Race(carNames.toArray(new String[0]));
        this.raceContent = new RaceContent(race);
        this.raceResult = new RaceResult(race);
    }

    private int checkCount(int countInput) {

        try {
            int countNumber = countInput;

            if (countNumber <= 0) {
                throw new IllegalArgumentException("시도 횟수 음수 또는 0입력 오류");
            }
            return countNumber;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수 숫자 외 입력 오류");
        }
    }

    private void moveRace(){

        int countNumber = checkCount(raceView.countMeg());

        raceView.resultMeg();
        raceContent.runRace(countNumber);
    }

    private void winner(){

        String winnerCar = raceResult.checkWinner();
        raceView.winnerCar(winnerCar);
    }
}
