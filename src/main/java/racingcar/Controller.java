package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.RaceService;
import racingcar.service.Racepreparations;
import racingcar.view.UserInputMessage;

public class Controller {

    RaceService raceService = new RaceService();
    Racepreparations racepreparations = new Racepreparations();
    public void run(){
        readyRace();
        startRace();
        prizeWinner();
    }

    public void readyRace(){
        // 1. 참가할 자동차 이름 받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        racepreparations.askCarNames();

        // 2. 레이싱 시도 횟수 받기
        System.out.println("시도할 회수는 몇회인가요?");
        racepreparations.askExecuteCount();
    }

    // 레이스 시작
    public void startRace(){
        raceService.raceStart();
    }

    // 최종 우승자 출력
    public void prizeWinner(){
        raceService.showWinner();
    }


}
