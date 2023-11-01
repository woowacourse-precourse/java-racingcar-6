package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}

class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("name should be less than or equal to 5 characters.");
        }
        this.name = name;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}

class Race {
    private final List<Car> cars;

    public Race(String[] carNames) {
        this.cars = Arrays.stream(carNames).map(Car::new).collect(Collectors.toList());
    }

    public void runRound() {
        cars.forEach(Car::move);
    }

    public List<Car> getCars() {
        return cars;
    }
}

class Game {
    private Race race;
    private int rounds;

    public void start() {
        initGame();
        executeRounds();
        printWinner();
    }

    private void initGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            this.rounds = Integer.parseInt(Console.readLine());
            this.race = new Race(carNames);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    private void executeRounds() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < rounds; i++) {
            race.runRound();
            printRaceState();
        }
    }

    private void printRaceState() {
        race.getCars().forEach(System.out::println);
        System.out.println();
    }

    private void printWinner() {
        int maxPosition = getMaxPosition();
        List<String> winners = race.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private int getMaxPosition() {
        return race.getCars().stream().mapToInt(Car::getPosition).max().orElse(0);
    }
}
