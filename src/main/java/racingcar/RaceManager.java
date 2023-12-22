package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RaceManager {
    private Race race;

    public static RaceManager setUp(Race race){
        return new RaceManager(race);
    }

    private RaceManager(Race race) {
        this.race = race;
    }

    public void run() {
        entryDrivers();
        askAndSetNumbersOfRaces();
        race.start();
        award();
    }

    private void award() {
        String winnersName = race.getWinners().stream()
                .map(Driver::getName)
                .collect(Collectors.joining(", "));
        System.out.println(UserMessages.WINNER_ANNOUNCEMENT + winnersName);
    }

    private void entryDrivers() {
        System.out.println(UserMessages.ASK_FOR_DRIVER_NAMES);
        Arrays.stream(Console.readLine().split(","))
                .forEach(race::addParticipant);
    }

    private void askAndSetNumbersOfRaces(){
        System.out.println(UserMessages.ASK_FOR_NUMBER_OF_RACES);
        int numbersOfRace = Integer.parseInt(Console.readLine());
        race.setNumberOfRaces(numbersOfRace);
    }
}