package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.repository.CarRepository;
import racingcar.utils.Parser;
import racingcar.view.GameInputView;
import racingcar.view.GameOutputView;

import java.util.List;

public class GameService {

    GameInputView gameInputView = new GameInputView();
    GameOutputView gameOutputView = new GameOutputView();
    Parser parser = new Parser();
    CarRepository carRepository = new CarRepository();

    Game game;

    public void setGame() {
        setCars();
        setTrials();
    }

    private void setCars() {
        List<String> carNames = parser.parseCarInput(gameInputView.getCarInput());
        for(String name : carNames) {
            carRepository.save(new Car(name));
        }
    }

    private void setTrials() {
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
}
