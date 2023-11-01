package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분):");
        String input = Console.readLine();
        List<String> carNames = validateAndSplitCarNames(input);

        int rounds = getNumberOfRounds();

        RacingGame game = new RacingGame(carNames, rounds);
        game.start();
    }

    private static List<String> validateAndSplitCarNames(String input) {
        String[] names = input.split(",");
        if (names.length < 2) {
            throw new IllegalArgumentException("적어도 2대의 자동차가 필요합니다.");
        }
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
        return List.of(names);
    }

    private static int getNumberOfRounds() {
        System.out.println("시도할 회수를 입력하세요:");
        String input = Console.readLine();
        int rounds;
        try {
            rounds = Integer.parseInt(input);
            if (rounds <= 0) {
                throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }
        return rounds;
    }
}

class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

class RacingGame {
    private final List<Car> cars;
    private final int rounds;

    public RacingGame(List<String> carNames, int rounds) {
        this.cars = createCars(carNames);
        this.rounds = rounds;
    }

    public void start() {
        for (int i = 0; i < rounds; i++) {
            playRound(i + 1);
        }
        displayWinners();
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name));
        }
        return carList;
    }

    private void playRound(int round) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            car.move();
            System.out.printf("%s : %s%n", car.getName(), createProgress(car.getPosition()));
        }
        System.out.println();
    }

    private String createProgress(int position) {
        StringBuilder progress = new StringBuilder();
        for (int i = 0; i < position; i++) {
            progress.append("-");
        }
        return progress.toString();
    }

    private void displayWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
