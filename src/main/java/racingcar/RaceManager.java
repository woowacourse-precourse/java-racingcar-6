package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class RaceManager {

    private Race race;
    public RaceManager(){
        this.race = new Race();
    }

    public void run(){
        startRace();
        award(this.race);
    }

    public void startRace(){
        settingRace();
        race.start();
    }

    private void award(Race race) {
        List<Driver> winners = race.getWinner();
        String awardNames = winners.stream()
                .map(Driver::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + awardNames);
    }


    private void settingRace(){
        entryDrivers();
        setNumbersOfRace();
    }

    private void entryDriver(String driverName){
        this.race.getDrivers().add(Driver.of(driverName));
    }

    private void entryDrivers(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        for (String driverName : Console.readLine().split(",")){
            entryDriver(driverName);
        }
    }

    private void setNumbersOfRace(){
        this.race.setNumbersOfRace();
    }

}
