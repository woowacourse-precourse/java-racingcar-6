package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

import racingcar.domain.Car;
import racingcar.view.Input;
import racingcar.view.Output;
import racingcar.domain.RacingGame;

import java.util.ArrayList;
import java.util.List;

public class Service {
    Input inputView = new Input();
    Output outputView = new Output();
    Repository repo = new Repository();
    RacingGame racingGame;
    public void userInput(){
        getCarNames();
        getAttemptNumber();
    }

    private void getCarNames() throws IllegalArgumentException{
        String carNames = inputView.getCarInput();
        List<String> carNameList = List.of(carNames.split(","));
        for(String carName : carNameList){
            if(carName.length()>5){throw new IllegalArgumentException();}
            repo.add(new Car(carName));
        }
    }

    private void getAttemptNumber(){
        String attemptString = inputView.getAttemptNumber();
        try {
            Integer.parseInt(attemptString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        int attemptNumber = Integer.parseInt(attemptString);
        racingGame = new RacingGame(repo.returnAll(), attemptNumber);
    }

    public void gamePlay() {
        outputView.RunResult();
        play(racingGame);
    }

    private void play(RacingGame racingGame) {
        while(true){
            move(racingGame);
            increaseAttempt(racingGame);
            printResult(racingGame);
            if(racingGame.isEnd()){break;}
        }
    }

    private void printResult(RacingGame racingGame) {
        for(Car car : racingGame.getAllCars()) {
            outputView.printResult(car.getName(), car.getPosition());
        }
        outputView.printEnter();
    }

    private void move(RacingGame racingGame) {
        for(Car car : racingGame.getAllCars()) {
            if(getRandomNumber() >= 4) {
                car.move();
            }
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    private void increaseAttempt(RacingGame racingGame) {
        racingGame.increaseAttempt();
    }

    public void returnWinner() {
        List<String> winner = new ArrayList<>();

        for(Car car : racingGame.getAllCars()) {
            if(car.getPosition() == getMaxPosition()) {
                winner.add(car.getName());
                winner.add(", ");
            }
        }

        winner.remove(winner.size()-1);

        outputView.printWinner(winner);
    }

    private int getMaxPosition() {
        int max = -9999;
        for(Car car : racingGame.getAllCars()) {
            if(max < car.getPosition()) {
                max = car.getPosition();
            }
        }
        return max;
    }
}
