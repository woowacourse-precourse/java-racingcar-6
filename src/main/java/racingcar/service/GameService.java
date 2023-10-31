package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.repository.CarRepository;
import racingcar.utils.Parser;
import racingcar.view.GameInputView;
import racingcar.view.GameOutputView;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    GameInputView gameInputView = new GameInputView();
    GameOutputView gameOutputView = new GameOutputView();
    Parser parser = new Parser();
    CarRepository carRepository = new CarRepository();

    Game game;

    public void setGame() {
        setCars();
        setTrial();
    }

    private void setCars() {
        List<String> carNames = parser.parseCarInput(gameInputView.getCarInput());
        for(String name : carNames) {
            carRepository.save(new Car(name));
        }
    }

    private void setTrial() {
        int trial = parser.parseTrialInput(gameInputView.getTrialInput());
        game = new Game(carRepository.findAll(), trial);
    }

    public void playGame() {
        gameOutputView.printResult();
        play(game);
    }

    private void play(Game game){
        while(!game.isEnd()){
            moveForward(game);
            getResult(game);
            increaseTrialNum(game);
        }
    }

    private void moveForward(Game game) {
        for(Car car : game.getCars()) {
            if(getRandomNumber() >= 4) {
                car.moveForward();
            }
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    private void increaseTrialNum(Game game) {
        game.increaseTrial();
    }

    private void getResult(Game game) {
        for(Car car : game.getCars()) {
            gameOutputView.printScore(car.getName(), car.getPosition());
        }
        gameOutputView.printOneLine();
    }

    public void getWinners() {
        List<String> winner = new ArrayList<>();

        for(Car car : game.getCars()) {
            if(car.getPosition() == getMaxPosition()) {
                winner.add(car.getName());
                winner.add(", ");
            }
        }

        winner.remove(winner.size()-1);

        gameOutputView.printWinner(winner);
    }

    private int getMaxPosition() {
        int max = 0;
        for(Car car : game.getCars()) {
            if(max < car.getPosition()) {
                max = car.getPosition();
            }
        }
        return max;
    }
}
