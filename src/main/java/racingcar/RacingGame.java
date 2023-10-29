package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGame {

    List<Car> participants = new ArrayList<>();
    List<Score> scores = new ArrayList<>();
    int times;

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        participants = readParticipantCars(readLine());

        System.out.println("시도할 회수는 몇회인가요?");
        times = readRacingTimes(readLine());

        for (int i = 0; i < times; i++) {
            scores.add(moving(participants));
        }

        System.out.println("\n실행 결과");
        for (Score score : scores) {
            score.printScore();
        }

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

    private int readRacingTimes(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자를 입력해주세요. (입력 : " + input + ")");
        }
    }

    private Score moving(List<Car> participants) {
        Map<String, Integer> movingDistance = new HashMap<>();
        for (Car participant : participants) {
            movingDistance.put(participant.name, participant.moveRandomDistance());
        }
        return new Score(movingDistance);
    }
}