package game;

import Util.InputUtil;
import car.Car;
import car.CarCollection;

import java.util.ArrayList;
import java.util.List;

import static constants.RacingCarConstants.NUMBER_OF_ATTEMPTS_MESSAGE;
import static constants.RacingCarConstants.PARTICIPANTS_INPUT_MESSAGE;

public class Game {

    private CarCollection participants;
    private int frequency;

    public Game() {
        participants = new CarCollection();
        initializeParticipants();
        initializeFrequency();
    }

    private void initializeParticipants() {
        String participantsInput = InputUtil.getUserInput(PARTICIPANTS_INPUT_MESSAGE);
        addCarsFromInput(participantsInput);
    }

    private void initializeFrequency() {
        String frequencyInput = InputUtil.getUserInput(NUMBER_OF_ATTEMPTS_MESSAGE);
        frequency = stringToInt(frequencyInput);
    }


    public void start(){

        for (int i = 0; i < frequency; i++){
            participants.moveCarsForward();
            participants.printCarsDistance();
        }

        List<String> winners = participants.getWinners();

        participants.printWinners(winners);
    }

    private void addCarsFromInput(String input) {
        String[] data = input.split(",");

        for (String name : data) {
            participants.addCar(new Car(name));
        }
    }

    private int stringToInt(String data) {
        return Integer.parseInt(data);
    }



}
