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

    // 입력값 받아 자동차 셋팅
    private void setCars() {
        List<String> carNames = parser.parseCarInput(gameInputView.getCarInput());
        for(String name : carNames) {
            carRepository.save(new Car(name));
        }
    }

    // 입력값 받아 시행 횟수 세팅
    private void setTrial() {
        int trial = parser.parseTrialInput(gameInputView.getTrialInput());
        game = new Game(carRepository.findAll(), trial);
    }

    public void playGame() {
        gameOutputView.printResult();
        play(game);
    }

    // 시행 횟수만큼 이동, 시행 결과 출력
    private void play(Game game){
        while(!game.isEnd()){
            moveForward(game);
            getResult(game);
            increaseTrialNum(game);
        }
    }

    // 1~9 중 랜덤으로 4이상 나오면 자동차 전진
    private void moveForward(Game game) {
        for(Car car : game.getCars()) {
            if(getRandomNumber() >= 4) {
                car.moveForward();
            }
        }
    }

    // 랜덤 번호 생성
    private int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    // 총 시행 횟수 1 증가
    private void increaseTrialNum(Game game) {
        game.increaseTrial();
    }

    // 시행 횟수별 결과 출력
    private void getResult(Game game) {
        for(Car car : game.getCars()) {
            gameOutputView.printScore(car.getName(), car.getPosition());
        }
        gameOutputView.printOneLine();
    }

    // 전진 횟수로 우승자 결정
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

    // 최대 전진 횟수 도출
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
