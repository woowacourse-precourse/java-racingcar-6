package racingcar.Model;

public class GameModel {

    int carNumber;
    int coinNumber;

    CarModel winnerCar;

    public GameModel(int carNumber, int coinNumber) {
        this.carNumber = carNumber;
        this.coinNumber = coinNumber;
    }

    public void setWinnerCar(CarModel winnerCar) {
        this.winnerCar = winnerCar;
    }
}
