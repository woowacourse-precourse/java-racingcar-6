package racingcar.racingGame;

import camp.nextstep.edu.missionutils.Console;
import racingcar.func.CarRace;

public class GameStart {
    public void setGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        String[] carNames = carNamesInput.split(",");

        System.out.println("시도할 회수는 몇회인가요? ");
        String tryCountInput = Console.readLine();
        int tryCount = Integer.parseInt(tryCountInput);
        CarRace cr = new CarRace(carNames,tryCount);
        cr.startRace();
    }
}
