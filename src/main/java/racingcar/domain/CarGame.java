package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.util.ConvertUtil;

public class CarGame {

    private List<Car> cars;
    private int gameCount;

    public CarGame(String carNames, int gameCount){
        cars = ConvertUtil.convertStrToListCar(carNames);
        this.gameCount = gameCount;
    }

    public void movePosition(){
        for (Car car : cars) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if(randomNum >=4){
                car.addPosition();
            }
        }
    }
}
