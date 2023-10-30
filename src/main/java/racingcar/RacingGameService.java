package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGameService {
    private final InputView inputView = new InputView();

    private int getPlayCount(){
        return inputView.playCount();
    }

    private List<String> getCarNameList(){
        return inputView.carNameList();
    }

    public RacingGame init(){
        int playCount = getPlayCount();
        List<String> carNameList = getCarNameList();
        List<Car> carList = new ArrayList<>();

        for(String carName: carNameList){
            Car car = new Car(carName);
            carList.add(car);
        }

        return new RacingGame(carList, playCount);
    }
}
