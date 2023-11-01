package game;

import Util.InputUtil;
import car.Car;
import car.CarCollection;
import java.util.List;

import static constants.RacingCarConstants.NUMBER_OF_ATTEMPTS_MESSAGE;
import static constants.RacingCarConstants.PARTICIPANTS_INPUT_MESSAGE;
import static validate.InputValidation.*;

public class Game {

    private final CarCollection cars;
    private int frequency;

    public Game() {
        cars = new CarCollection();
        initializeParticipants();
        initializeFrequency();
    }

    private void initializeParticipants() {
        String carsInput = InputUtil.getUserInput(PARTICIPANTS_INPUT_MESSAGE);
        addCarsFromInput(carsInput);
    }

    private void initializeFrequency() {
        String frequencyInput = InputUtil.getUserInput(NUMBER_OF_ATTEMPTS_MESSAGE);
        frequency = stringToInt(frequencyInput);
    }

    public void start(){
        for (int i = 0; i < frequency; i++){
            cars.moveCarsForward();
            cars.printCarsDistance();
        }

        List<String> winners = cars.getWinners();

        cars.printWinners(winners);
    }

    private void addCarsFromInput(String input) {
        String[] data = input.split(",");

        validateListIsEmpty(data);

        for (String name : data) {
            cars.addCar(new Car(name));
        }
    }

    private int stringToInt(String data) {
        validateNumericInput(data);
        return Integer.parseInt(data);
    }
}
