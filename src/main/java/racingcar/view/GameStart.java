package racingcar.view;

import racingcar.control.GameProcess;
import racingcar.domain.RaceCar;

import java.util.Map;

public class GameStart {
    GameProcess gameProcess;

    public GameStart() {
        gameProcess = new GameProcess();
    }

    /**
     * 전진하는 모든 차들의 자동차를 출력한다.
     * "-"을 출력 ( pobi : - )
     * pobi : ----
     * woni : ---
     */
    public void printSituationOfCarCurrent() {
        Map<RaceCar, String> raceCarStringMap = gameProcess.makeMsgOfCurrentRace();

        for (Map.Entry<RaceCar, String> entry : raceCarStringMap.entrySet()) {
            String raceCar = entry.getKey().toString();
            String state = entry.getValue();
            System.out.println(raceCar + " : " + state);
        }
    }

    /**
     * 우승자가 누구인지 출력을 해준다.
     * 우승자는 한명이상이다.
     * 우승자가 여러명일경우 쉼표(,)를 이용하여 구분한다.
     */
    public void printWinnerOfRaceGame() {
        System.out.println("최종 우승자 : " + gameProcess.knowFinalWinner());
    }

    /**
     * 게임 진행 상황을 보여준다.
     */
    public void showPrsocessOfRaceGame() {
//        시도할 회수만큼 게임 진행 상황을 출력한다.
//        printSituationOfCarCurrent 실행
        Integer cntTryRace = gameProcess.getCntTryRace();
        for (int i = 0; i < cntTryRace; i++) {
            gameProcess.moveOfRaceCar();
            printSituationOfCarCurrent();
            System.out.println();
        }
    }

    /**
     * 경주할 자동차 이름을 입력하는 출력을 보여주는 기능
     */
    public void printInputNameOfRaceCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        gameProcess.inputNameOfRaceCar();
    }

    /**
     * 레이스 진행 시도할 횟수의 출력을 보여주는 기능
     */
    public void printInputNumOfTryCnt() {
        System.out.println("시도할 회수는 몇회인가요?");
        gameProcess.inputNumberGameAttempts();
    }

    /**
     * 실행결과 출력 메서드
     */
    public void printMsgResultOfRun() {
        System.out.println();
        System.out.println("실행 결과");
    }

    /**
     * 게임 시작하는 메서드
     */
    public void run() {
        printInputNameOfRaceCar();
        printInputNumOfTryCnt();
        printMsgResultOfRun();
        showPrsocessOfRaceGame();
        printWinnerOfRaceGame();
    }
}
