package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void main(String[] args) {
        Application game = new Application();
        game.start();
    }

    private void start() {
        String inputNames = getUserInput("경주할 자동차 이름을 입력하세요 (이름은 쉼표(,)로 구분):");
        String[] carNames = validateCarNames(inputNames);

        int tryCount = Integer.parseInt(getUserInput("시도할 회수는 몇 회인가요?"));
        validateTryCount(tryCount);

        Race race = new Race(carNames, tryCount);
        race.startRace();
    }

    private String getUserInput(String prompt) {
        System.out.println(prompt);
        return Console.readLine();
    }


    private String[] validateCarNames(String inputNames) {
        String[] carNames = inputNames.split(",");
        Set<String> uniqueCarNames = new HashSet<>();

        for (String name : carNames) {
            String trimmedName = name.trim();
            validateCarNameLength(trimmedName);
            uniqueCarNames.add(trimmedName);
        }

        if (uniqueCarNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력하세요.");
        }

        return uniqueCarNames.toArray(new String[0]);
    }
    private void validateCarNameLength(String name) {
        if (name.length() < MIN_CAR_NAME_LENGTH || name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1에서 5자 사이여야 합니다.");
        }
    }
    private void validateTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    public class Car {
        private final String name;
        private int position;

        Car(String name) {
            this.name = name;
            this.position = 0;
        }

        void move() {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (randomValue >= 4) {
                position++;
            }
        }

        int getPosition() {
            return position;
        }

        String getName() {
            return name;
        }
    }
    public class Race {
        private final Car[] cars;
        private final int tryCount;

        Race(String[] carNames, int tryCount) {
            this.tryCount = tryCount;
            this.cars = createCars(carNames);
        }
        private Car[] createCars(String[] carNames) {
            Car[] cars = new Car[carNames.length];
            for (int i = 0; i < carNames.length; i++) {
                cars[i] = new Car(carNames[i]);
            }
            return cars;
        }

        void startRace() {
            for (int tryNumber = 1; tryNumber <= tryCount; tryNumber++) {
                StringBuilder raceResult = new StringBuilder("\n");
                for (Car car : cars) {
                    car.move();
                    appendCarStatus(raceResult, car);
                }
                printRaceResult(raceResult.toString());
            }
            printWinners();
        }

        private void appendCarStatus(StringBuilder raceResult, Car car) {
            raceResult.append(car.getName()).append(" : ");
            for (int i = 0; i < car.getPosition(); i++) {
                raceResult.append("-");
            }
            raceResult.append("\n");
        }
        private void printRaceResult(String result) {
            System.out.print(result);
        }

        private void printWinners() {
            int maxPosition = getMaxPosition();
            String winners = findWinners(maxPosition);
            printWinnersMessage(winners);
        }

        private int getMaxPosition() {
            int maxPosition = 0;
            for (Car car : cars) {
                maxPosition = Math.max(maxPosition, car.getPosition());
            }
            return maxPosition;
        }
        private String findWinners(int maxPosition) {
            List<String> winnerList = new ArrayList<>();
            for (Car car : cars) {
                if (car.getPosition() == maxPosition) {
                    winnerList.add(car.getName());
                }
            }
            return String.join(", ", winnerList);
        }
        private void printWinnersMessage(String winners) {
            StringBuilder result = new StringBuilder();
            for (Car car : cars) {
                result.append(car.getName()).append(" : - ");
            }
            result.append("최종 우승자 : ").append(winners);
            System.out.print(result.toString() + "\n");
        }
    }
 }