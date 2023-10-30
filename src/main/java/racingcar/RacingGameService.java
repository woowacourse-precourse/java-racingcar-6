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

    public void playRound(RacingGame racingGame){
        List<Car> carList = racingGame.getCarList();
        for(Car car: carList){
            car.move(makeRandomPower());
            if (car.getPosition() > highDistance){
                highDistance = car.getPosition();
            }
        }
    }

    public void printRoundResult(RacingGame racingGame){
        List<Car> carList = racingGame.getCarList();
        for(Car car: carList){
            outputView.carPositionMessage(car.getName(), car.getPosition());
        }
    }

    private List<Car> checkWinner(RacingGame racingGame){
        List<Car> winnerList = new ArrayList<>();

        List<Car> carList = racingGame.getCarList();
        for(Car car: carList){
            if (car.getPosition() == highDistance) {
                winnerList.add(car);
            }
        }
        return winnerList;
    }

    public void printWinner(RacingGame racingGame){
        List<Car> winnerList = checkWinner(racingGame);

        for(Car car: winnerList){
            outputView.carPositionMessage(car.getName(), car.getPosition());
        }
    }
    private Integer makeRandomPower(){
        return Randoms.pickNumberInRange(NUMBER_RANGE_START, NUMBER_RANGE_END);
    }
}
