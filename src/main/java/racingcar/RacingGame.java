package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    List<Car> participant = new ArrayList<>();
    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        participant = readParticipantCars(readLine());

        // TODO : 경주 횟수를 입력받는다
        // TODO : n개의 자동차가 각자 전진한다
        // TODO : 각 차수별 실행 결과를 출력한다
        // TODO : 우승한 자동차 리스트를 구한다
        // TODO : 우승한 자동차 리스트를 출력한다
    }

    private List<Car> readParticipantCars(String input) {
        List<Car> cars = new ArrayList<>();

        input = input.replaceAll(" ", "");
        String[] carNames = input.split(",");

        for (String carName : carNames) {
            cars.add(Car.of(carName));
        }

        return cars;
    }
}
