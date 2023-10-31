package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RacingGame {
    Integer targetAttempts;
    private static final int MIN_TARGET_ATTEMPS = 0;
    private List<Car> cars;

    public RacingGame() {
        targetAttempts = MIN_TARGET_ATTEMPS;
        cars = new ArrayList<>();
    }

    public void start() throws IllegalArgumentException {
        printCarNameInputMessages();
        List<String> carNames = getCarNames();
        cars = getCars(carNames);

        printTargetAttemptsInputMessage();
        targetAttempts = getTargetAttempts();
        validateTargetAttempts(targetAttempts);

        run();
    }

    private void run() {
        for (int attempts = 0; attempts < targetAttempts; attempts++) {
            tryToMoveCars();
            printProgress();
        }

        List<Car> winners = findWinners();
        printWinners(winners);
    }

    private void tryToMoveCars() {
        for (Car car : cars) {
            car.tryToMove();
        }
    }

    private List<Car> getCars(List<String> names) {
        if (Objects.isNull(names)) {
            throw new IllegalArgumentException("getCars(): names는 NULL이 될 수 없습니다.");
        }

        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name));
        }
        return carList;
    }

    private void printCarNameInputMessages() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private List<String> getCarNames() throws IllegalArgumentException {
        String strNames = Console.readLine();
        if (Objects.isNull(strNames)) {
            throw new IllegalArgumentException("자동차들의 이름은 NULL이 될 수 없습니다.");
        }
        return Arrays.asList(strNames.split(","));
    }

    private int getTargetAttempts() throws IllegalArgumentException {
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수가 올바른 숫자 형식 값이 아닙니다.");
        }
    }

    private void printTargetAttemptsInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    private void validateTargetAttempts(final int targetAttempts) throws IllegalArgumentException {
        if (targetAttempts < MIN_TARGET_ATTEMPS) {
            throw new IllegalArgumentException("시도 횟수는 최소 " + MIN_TARGET_ATTEMPS + "이상이어야 합니다");
        }
    }

    private void printProgress() {
        for (Car car : cars) {
            printProgressOfCar(car);
        }
        System.out.println();
    }

    private void printProgressOfCar(Car car) {
        System.out.print(car.getName() + " : ");
        for (int count = 0; count < car.getMoveCount(); count++) {
            System.out.print('-');
        }
        System.out.println();
    }

    private List<Car> findWinners() {
        List<Car> winners = new ArrayList<>();
        int maxDistance = 0;
        for (Car car : cars) {
            if (car.getMoveCount() > maxDistance) {
                maxDistance = car.getMoveCount();
                winners.clear();
            }

            if (car.getMoveCount() == maxDistance) {
                winners.add(car);
            }
        }
        return winners;
    }

    private void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        if (!Objects.isNull(winners) && !winners.isEmpty()) {
            String name = winners.get(0).getName();
            System.out.print(name);
            for (int i = 1; i < winners.size(); i++) {
                name = winners.get(i).getName();
                System.out.print(", " + name);
            }
        }
        System.out.println();
    }
}
