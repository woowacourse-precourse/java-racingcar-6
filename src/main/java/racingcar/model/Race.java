package racingcar.model;

import racingcar.view.Input;
import racingcar.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Race {
    private final List<Car> carList;
    private int raceRounds;
    public Race() {
        carList = new ArrayList<>();
    }

    public void setRaceRounds(){
        raceRounds = Integer.parseInt(Input.inputRounds());
    }

    public boolean isRaceFinished(){
        return raceRounds == 0;
    }

    public void setCarList(){
        List<String> carNames = makeCarNameList();
        for (String carName : carNames) {
            Car newCar = new Car(carName);
            carList.add(newCar);
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    private List<String> makeCarNameList() {
        String carNames = Input.inputCarNames();
        String[] carNameArray = carNames.split(",");
        List<String> carNameList = List.of(carNameArray);
        return carNameList;
    }

    public void playOneRound(){
        moveCars();
        raceRounds--;
    }

    private void moveCars() {
        for (Car car : carList) {
            car.moveForward();
        }
    }

    public List<String> getRaceResult(){
        int maxLength = getMaxLength();
        List<String> raceResult = new ArrayList<>();
        for (Car car : carList){
            if (car.getMoveLength() == maxLength)
                raceResult.add(car.getCarName());
        }
        return raceResult;
    }

    private int getMaxLength(){
        int maxLength = 0;
        for (Car car : carList) {
            maxLength = Math.max(maxLength, car.getMoveLength());
        }
        return maxLength;
    }
}
