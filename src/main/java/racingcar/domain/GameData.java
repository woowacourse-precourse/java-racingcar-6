package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameData {

    private Integer tryRepetitionNumber;
    private List<Car> winnerList;
    private String CarNamesInput;
    private List<Car> carList;


    public List<Car> getCarList() {
        return carList;
    }

    public void createCarList(int carNumber) {
        this.carList = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            carList.add(new Car());
        }
    }

    public String getCarNamesInput() {
        return CarNamesInput;
    }

    public void setCarNamesInput(String carNamesInput) {
        CarNamesInput = carNamesInput;
    }

    public void setCarsName(String[] carNamesArray) {

        for (int i = 0; i < carNamesArray.length; i++) {
            Car car = carList.get(i);
            car.setName(carNamesArray[i]);
        }
    }

    public Integer getTryRepetitionNumber() {
        return tryRepetitionNumber;
    }

    public void setTryRepetitionNumber() {
        String repetitionNumberInput = Console.readLine();
        this.tryRepetitionNumber = Integer.parseInt(repetitionNumberInput);
    }

    public List<Car> getWinnerList() {
        return winnerList;
    }

    public void setWinnerList(List<Car> winnerList) {
        this.winnerList = winnerList;
    }
}
