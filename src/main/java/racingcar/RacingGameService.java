package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static racingcar.Number.NUMBER_RANGE_END;
import static racingcar.Number.NUMBER_RANGE_START;

public class RacingGameService {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private int highDistance = 0;

    private int getPlayCount(){
        outputView.countMessage();
        return inputView.playCount();
    }

    private List<String> getCarNameList(){
        outputView.carNameMessage();
        return inputView.carNameList();
    }

    public void play(int raceCount, RacingGame racingGame){
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
