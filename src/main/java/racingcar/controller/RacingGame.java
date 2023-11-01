package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputUser;
import racingcar.view.Message.GameViewMessage;

import java.util.ArrayList;
import java.util.Arrays;

public class RacingGame {
    private static final String SEPARATOR = GameViewMessage.COMMA.getMessage();

    private final InputUser inputUser;
    private final InputException inputException = new InputException();

    private ArrayList<Car> carList;
    private ArrayList<String> carNameArray;
    private int roundLength;


    public RacingGame() {
        roundLength = 0;
        inputUser = new InputUser();
        carList = null;
    }

    public void gamePlay() {
        inputCarList();
        inputRoundLength();

        Round round = new Round(roundLength);
        round.playAllRound(carList);
    }

    private void inputCarList(){
        inputCarNameString(inputUser.userInputCarNameString());
        carList = returnCar();
    }

    private void inputRoundLength(){
        roundLength = inputRoundLength(inputUser.userInputRoundLength());
    }

    public void inputCarNameString(String carNameString) {
        carNameArray = splitToArray(carNameString);
        inputException.checkInputCarNameArrayError(carNameArray);
    }

    public ArrayList<Car> returnCar() {
        carList = new ArrayList<>();
        for (String carName : carNameArray) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    private ArrayList<String> splitToArray(String carNameString) {
        return new ArrayList<>(Arrays.asList(carNameString.split(SEPARATOR)));
    }

    public int inputRoundLength(String inputRoundLength) {
        inputException.checkInputRoundError(inputRoundLength);
        return Integer.parseInt(inputRoundLength);
    }
}
