package racingcar.configuration;

import racingcar.model.CarList;
import racingcar.view.UserView;

public class GameSetter {
    private final CarList carList;
    private final CarRegisterer carRegisterer;
    private final UserView userView;

    private int coinValue;

    public GameSetter(CarList carList) {
        this.carList = carList;
        this.carRegisterer = new CarRegisterer(carList);

        this.userView = new UserView();
        this.coinValue = userView.inputCoinValue();
    }

    public void setGame() {
        carRegisterer.registerCars();
    }

    public int getCoin() {
        return this.coinValue;
    }
}
