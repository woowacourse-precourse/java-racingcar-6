package racingcar;


import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();
        RacingController racingController = new RacingController(new RacingGame(inputNames));
        racingController.runGame();
    }
}
