package racingcar.view;

import racingcar.control.GameProcess;
import racingcar.domain.RaceCar;
import racingcar.string.PrintConstans;
import racingcar.utill.Utill;

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
        String MsgMoveStateOfRaceCar = "";

        for (Map.Entry<RaceCar, String> entry : raceCarMapOfCurrent.entrySet()) {
            nameOfRaceCar = entry.getKey().toString();
            MsgMoveStateOfRaceCar = String.valueOf(entry.getValue());
            Utill.print(PrintConstans.MSG_SITUATION_PROCESS_ONE_CAR(nameOfRaceCar, MsgMoveStateOfRaceCar));
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
        Utill.print(PrintConstans.MSG_NAME_WINNER_CAR_RACE(carOfWinnerFinal));
    }

    /**
     * 자동차 레이스의 모든 상황을 보여준다.
     * 시도할 회수만큼 게임 진행 상황을 출력한다.
     */
    public void printAllProcessOfRaceGame() {
        Integer cntTryRace = gameProcess.getCntTryRace();

        for (int indexOfRaceGame = 0; indexOfRaceGame < cntTryRace; indexOfRaceGame++) {
            gameProcess.moveAllRaceCar();
            printSituationOfRaceProcessOneCycle();
            Utill.printNewLine();
        }
    }

    /**
     * 경주할 자동차 이름을 입력하는 출력을 보여주는 기능
     */
    public void printInputNameOfRaceCar() {
        Utill.print(PrintConstans.MSG_INPUT_NAME_RACE_CARS());
        gameProcess.inputNameOfRaceCar();
        gameProcess.createRaceCars();
    }

    /**
     * 레이스 진행 시도할 횟수의 출력을 보여주는 기능
     */
    public void printInputNumOfTryCnt() {
        Utill.print(PrintConstans.MSG_INPUT_COUNT_TRY_GAME());
        gameProcess.inputNumOfGameAttempts();
    }

    /**
     * 실행결과 출력 메서드
     */
    public void printMsgResultOfRun() {
        Utill.printNewLine();
        Utill.print(PrintConstans.MSG_PROCESS_RESULT());
    }

    /**
     * 게임 시작하는 메서드
     * <p>
     * 게임 레이스 자동차의 이름을 입력하고, 이름에 맞는 자동차를 생성
     * 게임 실행을 하는 count 입력
     * "실행결과" 출력
     * count에 맞게 자동차의 게임 진행 상황 출력
     * 누가 우승자인지 출력한다.
     */
    public void run() {
        printInputNameOfRaceCar();
        printInputNumOfTryCnt();
        printMsgResultOfRun();
        printAllProcessOfRaceGame();
        printWinnerOfRaceGame();
    }
}
