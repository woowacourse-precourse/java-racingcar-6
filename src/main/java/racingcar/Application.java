package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.GameConfig;
import racingcar.domain.Judgment;
import racingcar.domain.Race;

import java.util.List;


public class Application {
    public static void main(String[] args) {

        GameConfig gameConfig = new GameConfig();
        Judgment judgment = new Judgment();
        Race race = new Race();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<Car> cars = gameConfig.createCars(Console.readLine());
        System.out.println("시도할 회수는 몇회인가요?");

        try {
            gameConfig.setMoveCount(Integer.parseInt(Console.readLine()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }

        System.out.println("실행 결과");
        race.startRace(cars, gameConfig.getMoveCount());
        List<String> winners = judgment.checkWinners(cars);
        System.out.printf("최종 우승자 : %s", String.join(", ", winners));
    }
}
