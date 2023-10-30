package racingcar;

import org.w3c.dom.ls.LSOutput;

public class RacingCarGame {
    private RaceInfo raceInfo;

    public void play() {
        getRaceInfo();
        System.out.print("자동차 이름 : ");
        for (String str: raceInfo.getCarNames()){
            System.out.print(str);
            System.out.print(" ");
        }
        System.out.println("");
        System.out.println("시도횟수 : " + raceInfo.getAttemptCount());

    }

    public void getRaceInfo(){
        System.out.print("자동차 이름 : ");
        String[] carNames = RaceInfoInput.inputCarName();
        System.out.print("시도횟수 : ");
        String attemptCount = RaceInfoInput.inputNumberOfAttempts();
        raceInfo = new RaceInfo(carNames, attemptCount);

    }
}
