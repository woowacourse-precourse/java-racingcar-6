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

    CarModel winnerCar;

    public void setWinnerCar(CarModel winnerCar) {
        this.winnerCar = winnerCar;
    }
}
