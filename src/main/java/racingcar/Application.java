package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.RacingGame;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        RacingGame game = RacingGame.getInstance();
        game.addCar(carNames);

        System.out.println("시도할 회수는 몇 회인가요?");
        String rounds = Console.readLine();
        game.play(rounds);

        System.out.printf("최종 우승자 : %s", game.getWinners());

    }
}
