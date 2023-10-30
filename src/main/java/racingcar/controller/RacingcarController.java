package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.RacingcarService;
import racingcar.service.RacingcarServiceImpl;
import racingcar.view.ReaultView;

import java.util.ArrayList;

public class RacingcarController {

    private final static RacingcarService racingcarService = new RacingcarServiceImpl();

    private final static ReaultView resultView = new ReaultView();

    private int testTimes;

    public RacingcarController() {
        this.testTimes = 0;
    }

    public boolean run() {
        try {
            inputRacingcar();
            inputTestTimes();
            testProcess();
            outputWinners();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public void inputRacingcar() throws Exception {
        resultView.scanRacingcarName();
        String input = Console.readLine();

        racingcarService.joinRacingcar(input);
    }

    public void inputTestTimes() throws Exception {
        resultView.scanTestTimes();

        try {
            testTimes = Integer.parseInt(Console.readLine());

        } catch (Exception e) {
            System.out.println("[ERROR] 입력값이 잘못되었습니다.");
        }
    }

    public void testProcess() throws Exception {
        System.out.println("실행 결과");
        for (int i = 0; i < testTimes; i++) {
            resultView.printProcess(racingcarService.changeMoving());
        }
    }

    public void outputWinners() throws Exception {
        ArrayList<String> winners = racingcarService.selectWinner();
        resultView.printWinners(winners);
    }

}
