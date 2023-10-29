package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RacingGame {

    List<Car> participants = new ArrayList<>();
    List<Score> scores = new ArrayList<>();
    List<String> winners = new ArrayList<>();
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

        checkWinner();
        // TODO : 우승한 자동차 리스트를 출력한다
    }

    private List<Car> readParticipantCars(String input) {
        List<Car> cars = new ArrayList<>();

        input = input.replaceAll(" ", "");
        String[] carNames = input.split(",");

        if (isEmptyString(input, carNames)) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }

        for (String carName : carNames) {
            cars.add(Car.of(carName));
        }

        return cars;
    }

    private boolean isEmptyString(String input, String[] carNames) {
        return input.isEmpty() || carNames.length == 0;
    }

    private int readRacingTimes(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자를 입력해주세요. (입력 : " + input + ")");
        }
    }

    private Score moving(List<Car> participants) {
        Map<String, Integer> movingDistance = new LinkedHashMap<>();
        for (Car participant : participants) {
            movingDistance.put(participant.name, participant.moveRandomDistance());
        }
        return new Score(movingDistance);
    }

    private void checkWinner() {
        Map<String, Integer> sumOfDistance = new LinkedHashMap<>();
        for (Car participant : participants) {
            int sum = 0;
            for (Score score : scores) {
                sum += score.movingDistance.get(participant.name);
            }
            sumOfDistance.put(participant.name, sum);
        }
        int maxValue = Collections.max(sumOfDistance.values());
        for (Entry<String, Integer> entrySet : sumOfDistance.entrySet()) {
            if (entrySet.getValue().equals(maxValue)) {
                winners.add(entrySet.getKey());
            }
        }
    }
}