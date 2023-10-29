package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class RacingGame {
    private static final String RACING_CARS_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACING_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private final RacingCarProvider racingCarProvider = new RacingCarProvider();
    private List<RacingCar> racingCars;

    public void start() {
        System.out.println(RACING_CARS_INPUT_MESSAGE);
        String nameInput = Console.readLine();
        String[] splitNames = nameInput.split(",");
        racingCarProvider.validate(splitNames);
        racingCars = racingCarProvider.createRacingCars(splitNames);

        System.out.println(RACING_COUNT_INPUT_MESSAGE);
        String countInput = Console.readLine();
        int tryCount = toInteger(countInput);

        System.out.println(RESULT_MESSAGE);
        for (int i=0; i<tryCount; i++) {
            race();
            printCurrentRace();
        }
    }

    private int toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private void race() {
        for (RacingCar racingCar : racingCars) {
            int randomNumber = NumberGenerator.createRandomNumber();
            if (randomNumber >= 4) {
                racingCar.move();
            }
        }
    }

    private void printCurrentRace() {
        for (int i=0; i<racingCars.size(); i++) {
            printCurrentRacingCarState(i);
        }
    }

    private void printCurrentRacingCarState(int index) {
        RacingCar racingCar = racingCars.get(index);
        String name = racingCar.getName();
        int distance = racingCar.getDistance();

        System.out.print(name + " : ");
        for (int i=0; i<distance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
