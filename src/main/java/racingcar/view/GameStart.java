package racingcar.view;

import racingcar.control.GameProcess;
import racingcar.domain.RaceCar;

import java.util.LinkedHashMap;
import java.util.Map;

public class GameStart {
    GameProcess gameProcess;
    Map<RaceCar, String> raceCarMapOfCurrent;

    public GameStart() {
        gameProcess = new GameProcess();
        raceCarMapOfCurrent = new LinkedHashMap<>();
    }

    /**
     * 전진하는 모든 차들의 자동차를 출력한다.
     * "-"을 출력 ( pobi : - )
     * pobi : ----
     * woni : ---
     */
    public void printSituationOfRaceProcessOneCycle() {
        makeMapOfCurrentRace();
        String nameOfRaceCar = "";
        String moveStateStrOfRaceCar = "";

        for (Map.Entry<RaceCar, String> entry : raceCarMapOfCurrent.entrySet()) {
            nameOfRaceCar = entry.getKey().toString();
            moveStateStrOfRaceCar = entry.getValue();
            System.out.println(nameOfRaceCar + " : " + moveStateStrOfRaceCar);
        }
    }

    /**
     * 현재 레이스 자동차들의 Map을 만들어준다.
     */
    private void makeMapOfCurrentRace() {
        raceCarMapOfCurrent = gameProcess.makeMapOfCurrentRace();
    }

    /**
     * 우승자가 누구인지 출력을 해준다.
     * 우승자는 한명이상이다.
     * 우승자가 여러명일경우 쉼표(,)를 이용하여 구분한다.
     */
    public void printWinnerOfRaceGame() {
        String carOfWinnerFinal = gameProcess.knowFinalWinner();
        System.out.println("최종 우승자 : " + carOfWinnerFinal);
    }

    /**
     * 자동차 레이스의 모든 상황을 보여준다.
     * 시도할 회수만큼 게임 진행 상황을 출력한다.
     */
    public void printAllProcessOfRaceGame() {
        Integer cntTryRace = gameProcess.getCntTryRace();
        for (int i = 0; i < cntTryRace; i++) {
            gameProcess.moveOfRaceCar();
            printSituationOfRaceProcessOneCycle();
            printNewLine();
        }
    }

    /**
     * print new Line
     */
    private void printNewLine() {
        System.out.println();
    }

    /**
     * 경주할 자동차 이름을 입력하는 출력을 보여주는 기능
     */
    public void printInputNameOfRaceCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        gameProcess.inputNameOfRaceCar();
        gameProcess.createRaceCars();
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
        printAllProcessOfRaceGame();
        printWinnerOfRaceGame();
    }
}
