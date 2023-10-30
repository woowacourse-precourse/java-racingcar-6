package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.Number.NUMBER_RANGE_END;
import static racingcar.constant.Number.NUMBER_RANGE_START;

public class RacingGameService {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private int highDistance = 0;

    public int getPlayCount(){
        outputView.countMessage();
        return inputView.playCount();
    }

    public List<String> getCarNameList(){
        outputView.carNameMessage();
        return inputView.carNameList();
    }

    public RacingGame raceSetting(List<Car> carList, int playCount){
        return new RacingGame(carList, playCount);
    }

    public void play(RacingGame racingGame){
        int raceCount = racingGame.getRaceCount();
        for(int playCount = 0; playCount<raceCount; playCount++){
            race(racingGame);
            printRaceResult(racingGame);
        }
    }

    private void race(RacingGame racingGame){
        List<Car> carList = racingGame.getCarList();
        for(Car car: carList){
            car.move(makeRandomPower());
            if (car.getPosition() > highDistance){
                highDistance = car.getPosition();
            }
        }
    }

    private void printRaceResult(RacingGame racingGame){
        List<Car> carList = racingGame.getCarList();
        for(Car car: carList){
            outputView.carPositionMessage(car.getName(), car.getPosition());
        }
        outputView.blank();
    }

    private List<String> checkWinner(RacingGame racingGame){
        List<String> winnerList = new ArrayList<>();

        List<Car> carList = racingGame.getCarList();
        for(Car car: carList){
            if (car.getPosition() == highDistance) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    public void printWinner(RacingGame racingGame){
        List<String> winnerList = checkWinner(racingGame);
        outputView.winnerMessage(winnerList);
    }
    private Integer makeRandomPower(){
        return Randoms.pickNumberInRange(NUMBER_RANGE_START, NUMBER_RANGE_END);
    }
}
