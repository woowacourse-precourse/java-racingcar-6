package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Race {

    private List<Driver> participants = new ArrayList<>();
    private int numbersOfRace;
    private static final int MIN_RACES = 1;
    private static final int MAX_RACES = 5;


    private Race(){}
    public static Race toRaceManager(){
        return new Race();
    }
    public void start(){
        System.out.println(UserMessages.RACE_RESULT);
        IntStream.range(0, this.numbersOfRace).forEach(raceTime -> {
            this.participants.forEach(driver -> {
                driver.drive();
                printDriverDistance(driver);
            });
            System.out.println();
        });
    }

    private void printDriverDistance(Driver driver) {
        String repeatedDash = "-".repeat(driver.getScore());
        System.out.println(driver.getName() + " : " + repeatedDash);
    }


    public void setNumberOfRaces(int numbersOfRace){
        if (numbersOfRace > MAX_RACES || numbersOfRace < MIN_RACES){
            throw new IllegalArgumentException(UserMessages.INVALID_NUMBER_INPUT.getContent());
        }
        this.numbersOfRace = numbersOfRace;
    }

    public List<Driver> getWinners() {
        int maxDistance = findMaxDistance();

        return this.participants.stream()
                .filter(driver -> driver.getScore() == maxDistance)
                .collect(Collectors.toList());
    }

    private int findMaxDistance() {
        return this.participants.stream()
                .mapToInt(Driver::getScore)
                .max()
                .orElse(0);
    }


    public void addParticipant(String driverName) {
        Car car = new Car();
        Driver driver = Driver.of(driverName, car);
        this.participants.add(driver);
    }

}
