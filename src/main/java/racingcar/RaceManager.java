package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class RaceManager {
    private Race race;

    public RaceManager() {
        this.race = new Race();
    }

    public void run() {
        askAndSetNumbersOfRaces();
        entryDrivers();
        race.start();
        award();
    }

    private void award() {
        List<Driver> winners = race.getWinner();
        String winnersName = winners.stream()
                .map(Driver::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnersName);
    }

    private void entryDrivers() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        for (String driverName : Console.readLine().split(",")) {
            race.addParticipant(driverName);
        }
    }

    private void askAndSetNumbersOfRaces(){
        System.out.println("시도할 회수는 몇회인가요?");
        int numbersOfRace = Integer.parseInt(Console.readLine());
        race.setNumbersOfRaces(numbersOfRace);
    }
}