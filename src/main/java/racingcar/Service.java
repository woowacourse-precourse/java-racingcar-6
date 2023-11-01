package racingcar;
import racingcar.domain.Car;
import racingcar.view.Input;
import racingcar.Repository;
import racingcar.domain.RacingGame;
import java.util.List;

public class Service {
    Input inputView = new Input();
    Repository repo = new Repository();
    RacingGame racingGame;
    public void userInput() {
        getCarNames();
        getAttemptNumber();
    }

    private void getCarNames(){
        String carNames = inputView.getCarInput();
        List<String> carNameList = List.of(carNames.split(","));
        for(String carName : carNameList){
            repo.add(new Car(carName));
        }
    }

    private void getAttemptNumber(){
        int attemptNumber = inputView.getAttemptNumber();
        racingGame = new RacingGame(repo.returnAll(), attemptNumber);
    }

}
