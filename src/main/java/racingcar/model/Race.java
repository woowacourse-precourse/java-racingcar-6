package racingcar.model;

import racingcar.view.Input;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> carList;
    private int raceRounds;
    public Race() {
        carList = new ArrayList<>();
    }

    public void setRaceRounds(){
        raceRounds = Integer.parseInt(Input.inputRounds());
    }

    public void setCarList(){
        List<String> carNames = makeCarNameList();
        for (String carName : carNames) {
            Car newCar = new Car(carName);
            carList.add(newCar);
        }
    }

    private List<String> makeCarNameList() {
        String carNames = Input.inputCarNames();
        String[] carNameArray = carNames.split(",");
        List<String> carNameList = List.of(carNameArray);
        return carNameList;
    }

    public void playRace(){
        while(raceRounds > 0){
            moveCars();
            printRoundResult();
            raceRounds--;
        }
    }

    private void moveCars() {
        for (Car car : carList) {
            car.moveForward();
        }
    }

    private void printRoundResult() {
    }

    public List<String> getRaceResult(){

    }
}
