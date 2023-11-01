package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Cars;
import racingcar.service.*;
import racingcar.view.SystemOutMessage;

import java.util.ArrayList;
import java.util.HashMap;

public class Controller {
    Cars cars = new Cars();
    RacePreparation racepreparations = new RacePreparation();
    RaceStart raceStart = new RaceStart();
    RaceLog raceLog = new RaceLog();
    WinnerCalculator winnerCalculator = new WinnerCalculator();

    public void raceGamePlay(){
        readyRace();
        startRace();
        prizeWinner();
    }

    // 1. 레이싱 게임을 위해 사용자에게 입력값을 받는다.
    public void readyRace(){
        // 1-1. 참가할 자동차 이름 받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        racepreparations.askCarNames();

        // 1-2. 레이싱 시도 횟수 받기
        System.out.println("시도할 회수는 몇회인가요?");
        racepreparations.askExecuteCount();
    }

    // 2. 레이스 경기를 시작한다
    public void startRace(){
        ArrayList<String> carNameList = cars.getCarNames();
        int raceCount = cars.getRaceCount();


        // 2-1. 경주 시작 전 레이스 로그를 만든다. -createEmptyRaceLog
        HashMap carLogs = raceLog.createEmptyRaceLog(carNameList);




        while(raceCount > 0){
            // 2-2. 경주차마다 무작위 값을 구한다 - createRandomNumbers
            HashMap<String,Integer> randomNumbers = raceStart.createRandomNumbers(carNameList);;

            // 2-3. 무작위값에 따라 경주 기록을 업데이트한다.
            raceStart.updateRaceLog(carNameList, randomNumbers, carLogs, raceCount);

            // 2-4. 각 실행결과를 출력한다.
            raceStart.showRaceLog(carNameList,carLogs);
            raceCount -= 1;
        }
    }


    // 3. 최종 우승자 출력
    public void prizeWinner(){
        SystemOutMessage.RaceResultMessage();
        ArrayList<String> winnerNames = winnerCalculator.calculateWinner();

        String winnersJoin = String.join(", ", winnerNames);
        System.out.println(winnersJoin);
    }

}
