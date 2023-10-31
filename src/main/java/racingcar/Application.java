package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // 1. 사용자로부터 자동차 이름 입력을 받습니다.
        String carNames = ConsoleWrapper.promptCarNames();

        // 2. 입력받은 자동차 이름을 리스트로 변환합니다.
        List<Car> cars = Arrays.stream(carNames.split(",")).map(Car::new).collect(Collectors.toList());

        // 3. 사용자로부터 시도 횟수를 입력받습니다.
        int numOfMoves = ConsoleWrapper.promptNumOfMoves();

        // 4. Race 클래스를 생성하고, 시도 횟수만큼 경주를 실행합니다.
        Race race = new Race(cars);
        race.run(numOfMoves); // 수정된 부분

        // 5. 경주가 종료된 후 우승자를 출력합니다.
        List<Car> winners = race.getWinners();
        ConsoleWrapper.printWinners(winners);
    }
}