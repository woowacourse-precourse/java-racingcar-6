package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import jdk.internal.util.xml.impl.Input;

import java.util.ArrayList;
import java.util.List;

import static racingcar.Number.NUMBER_RANGE_END;
import static racingcar.Number.NUMBER_RANGE_START;

public class RacingGameService {
    private final InputView inputView = new InputView();


    private int getPlayCount(){
        System.out.println(InputMessage.CAR_NAME);
        return inputView.playCount();
    }

    private List<String> getCarNameList(){
        System.out.println(InputMessage.COUNT);
        return inputView.carNameList();
    }

    public void play(RacingGame racingGame){
        List<Car> carList = racingGame.getCarList();
        for(Car car: carList){
            car.move(makeRandomPower());
        }
    }

    private Integer makeRandomPower(){
        return Randoms.pickNumberInRange(NUMBER_RANGE_START, NUMBER_RANGE_END);
    }
}
