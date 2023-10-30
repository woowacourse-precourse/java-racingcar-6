package racingcar.repository;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.util.CarRacingStarts;

public class CarRaceResultsSave {

    private final CarRacingStarts carRacingStarts;

    public CarRaceResultsSave(CarRacingStarts carRacingStarts) {
        this.carRacingStarts = carRacingStarts;
    }

    public void carMovingDistanceCalculation(List<String> carNames, int tryTimes) {

        while (tryTimes > 0) {
            carRacingStarts.creation(carNames);
            carDistanceOutput();
            System.out.println();
            tryTimes--;
        }


    }

    public void carDistanceOutput() {

//        try {
//            Thread.sleep(1000);
        for (Entry<String, String> map : getCarMoveCheck().entrySet()) {
            System.out.printf("%s : %s\n", map.getKey(), map.getValue());
        }
//        }
//        catch (InterruptedException e){
//        }

    }

    private Map<String, String> getCarMoveCheck() {

        return carRacingStarts.getCarsDistanceData();

    }

}
