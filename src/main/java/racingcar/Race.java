package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Race {

    private List<Driver> participants = new ArrayList<>();
    private int numbersOfRace;

    public Race(){}

    public void start(){
        System.out.println("실행 결과");
        for (int raceTime = 0; raceTime < this.numbersOfRace; raceTime++){
            for (Driver driver : this.participants){
                driver.drive();
                announceDriverScore(driver);
            }
            System.out.println();
        }
    }

    private void announceDriverScore(Driver driver) {
        String repeatedDash = String.join("", Collections.nCopies(driver.getScore(), "-"));
        System.out.println(driver.getName() + " : " + repeatedDash);
    }


    public void setNumbersOfRace(){
        System.out.println("시도할 회수는 몇회인가요?");
        int numbersOfRace = Integer.parseInt(Console.readLine());
        if (numbersOfRace > 5 || numbersOfRace < 1){
            throw new IllegalArgumentException("경주 횟수는 1이상 5 이하로 입력");
        }
        this.numbersOfRace = numbersOfRace;
    }

    private void entryDriver(String driverName){
        this.participants.add(Driver.of(driverName));
    }

    public List<Driver> getWinner() {

        int maxDistance = this.participants.stream()
                .mapToInt(Driver::getScore)
                .max()
                .orElse(0);

        return this.participants.stream()
                .filter(driver -> driver.getScore() == maxDistance)
                .collect(Collectors.toList());
    }

    public List<Driver> getDrivers(){
        return this.participants;
    }

}
