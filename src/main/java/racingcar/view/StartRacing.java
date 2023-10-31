package racingcar.view;

import racingcar.control.GameProcess;

public class StartRacing {
    private final GameProcess gameProcess;

    public StartRacing() {
        this.gameProcess = new GameProcess();
    }

    public void run() {
        // 게임 시작 전 준비단계
        beforeStartGame();

        // 게임 중
        playGame();

        //게임 마무리
        endGame();
    }

    private void beforeStartGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        gameProcess.inputName();
        System.out.println("시도할 회수는 몇회인가요?");
        gameProcess.inputRaceTime();
        System.out.println();
    }

    private void playGame() {
        System.out.println("실행 결과");
        gameProcess.playingGame();
        System.out.println();
    }

    private void endGame() {
        System.out.print("최종 우승자 : ");
    }
}
