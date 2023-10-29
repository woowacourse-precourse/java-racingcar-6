package racingcar.Model;

public class GameModel {

    int carNumber;
    int coinNumber;

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

    public CarModel getWinnerCar() {
        return winnerCar;
    }

    CarModel winnerCar;

    public void setWinnerCar(CarModel winnerCar) {
        this.winnerCar = winnerCar;
    }
}
