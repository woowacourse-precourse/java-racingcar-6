package racingcar.Model;

import java.util.ArrayList;

public class GameModel {

    int carNumber;
    int coinNumber;
    ArrayList<CarModel> winnerCar = new ArrayList<>();


    public void setCarNumber(int carNumber) {

        this.carNumber = carNumber;
    }

    public void setCoinNumber(int coinNumber) {

        this.coinNumber = coinNumber;
    }

    public int getCarNumber() {

        return carNumber;
    }

    public int getCoinNumber() {

        return coinNumber;
    }

    public ArrayList<CarModel> getWinnerCar() {

        return winnerCar;
    }

    public void setWinnerCar(CarModel winnerCar) {

        this.winnerCar.add(winnerCar);
    }
}
