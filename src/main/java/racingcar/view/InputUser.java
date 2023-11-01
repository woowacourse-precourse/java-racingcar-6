package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.InputException;
import racingcar.model.Car;
import racingcar.view.Message.GameViewMessage;

import java.util.ArrayList;
import java.util.Arrays;

public class InputUser {
    private String carNameString;
    private String inputRoundLength;
    private ArrayList<String> carNameArray;
    private static final String SEPARATOR = GameViewMessage.COMMA.getMessage();
    private final InputException inputException;

    public InputUser() {
        this.carNameString = "";
        this.inputRoundLength = "";
        this.carNameArray = null;
        this.inputException = new InputException();
    }

    public void inputCarNameString() {
        inputUserCarNameString();
        carNameArray = splitToArray(carNameString);
        inputException.checkInputCarNameArrayError(carNameArray);
    }

    public void inputUserCarNameString() {
        displayWriteCarNameMessage();
        carNameString = Console.readLine();
    }


    public ArrayList<Car> returnCar() {
        ArrayList<Car> carArrayList = new ArrayList<>();
        for (String carName : carNameArray) {
            carArrayList.add(new Car(carName));
        }
        return carArrayList;
    }

    private ArrayList<String> splitToArray(String carNameString) {
        return new ArrayList<>(Arrays.asList(carNameString.split(SEPARATOR)));
    }

    public int inputRoundLength() {
        displayWriteRaceLengthMessage();
        inputRoundLength = Console.readLine();

        inputException.checkInputRoundError(inputRoundLength);
        return Integer.parseInt(inputRoundLength);
    }

    private void displayWriteCarNameMessage() {
        System.out.println(GameViewMessage.WRITE_CAR_NAME_MESSAGE.getMessage());
    }

    private void displayWriteRaceLengthMessage() {
        System.out.println(GameViewMessage.WRITE_RACE_LENGTH_MESSAGE.getMessage());
    }

}
