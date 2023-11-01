package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    List<Car> participants = new ArrayList<>();
    List<String> winners = new ArrayList<>();
    int times;

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        participants = readParticipantCars(readLine());

        System.out.println("시도할 회수는 몇회인가요?");
        times = readRacingTimes(readLine());

        System.out.println("\n실행 결과");
        for (int i = 0; i < times; i++) {
            for (Car participant : participants) {
                participant.moveOrStay();
                participant.printSticks();
            }
            System.out.println();
        }

        checkWinner();

        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
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

    private void checkWinner() {
        for (Car participant : participants) {
            if (Car.maxDistance == participant.getDistance()) {
                winners.add(participant.getName());
            }
        }
    }
}