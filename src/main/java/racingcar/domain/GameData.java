package racingcar.domain;

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

    public void setCarList(int carNumber) {
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

    public Integer getTryRepetitionNumber() {
        return tryRepetitionNumber;
    }

    public List<Car> getWinnerList() {
        return winnerList;
    }

    public void setWinnerList(List<Car> winnerList) {
        this.winnerList = winnerList;
    }

    public void setTryRepetitionNumber(Integer tryRepetitionNumber) {
        this.tryRepetitionNumber = tryRepetitionNumber;
    }
}
