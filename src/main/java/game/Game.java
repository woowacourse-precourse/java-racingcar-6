package game;

import Util.InputUtil;
import car.Car;
import car.CarCollection;

import java.util.ArrayList;
import java.util.List;

import static constants.RacingCarConstants.NUMBER_OF_ATTEMPTS_MESSAGE;
import static constants.RacingCarConstants.PARTICIPANTS_INPUT_MESSAGE;

public class Game {

    private List<Car> participants;
    private int frequency;

    public Game() {
        initializeParticipants();
        initializeFrequency();
    }

    private void initializeParticipants() {
        String participantsInput = InputUtil.getUserInput(PARTICIPANTS_INPUT_MESSAGE);
        participants = stringToCarList(participantsInput);
    }

    private void initializeFrequency() {
        String frequencyInput = InputUtil.getUserInput(NUMBER_OF_ATTEMPTS_MESSAGE);
        frequency = stringToInt(frequencyInput);
    }


    public void start(){

        for (int i = 0; i < frequency; i++){
            moveCarsForward(participants);
            printCarsDistance(participants);
        }

        int maxDistance = getMaxDistance(participants);

        List<String> winners = getWinners(participants, maxDistance);

        printWinners(winners);
    }

    public void moveCarsForward(List<Car> participants) {
        for (Car car : participants) {
            car.movingForward();
        }
    }

    public void printCarsDistance(List<Car> participants) {
        for (Car car : participants) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }

    public int getMaxDistance(List<Car> participants) {
        int maxDistance = 0;

        for (Car car : participants) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }

    public List<String> getWinners(List<Car> participants, int maxDistance) {
        List<String> winners = new ArrayList<>();

        for (Car car : participants) {
            if (car.getDistance() >= maxDistance){
                winners.add(car.getName());
            }
        }
        return winners;
    }


    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public List<Car> stringToCarList(String data) {
        List<Car> res = new ArrayList<>();
        String[] splitData = data.split(",");

        for(String name: splitData) {
            Car car = new Car(name);
            res.add(car);
        }
        return res;
    }

    public int stringToInt(String data) {
        return Integer.parseInt(data);
    }

}
