package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Game {
    private int gameTurns;
    private List<Car> cars = new ArrayList<>();
    private List<String> winners = new ArrayList<>();

    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = inputCarNames();
        initCarList(carNames.split(","));
        System.out.println("시도할 회수는 몇회인가요?");
        inputGameTurns();
        System.out.println("\n실행결과");
        for (int i = 0; i < gameTurns; i++) {
            for (Car car : cars) {
                int randomNumber = RandomMaker.makeRandomNumber();
                car.move(randomNumber);
                System.out.println(car);
            }
            System.out.println();
        }
        findWinners();
        System.out.println(winnersToString());
    }

    public String inputCarNames() {
        String carNames = Console.readLine();
        checkValidCarNames(carNames);
        return carNames;
    }

    private void checkValidCarNames(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input, ",");
        while (tokenizer.hasMoreTokens()) {
            String carName = tokenizer.nextToken().trim();
            if (carName.isBlank() || carName.length() > 5) {
                throw new IllegalArgumentException("Not valid input: car names");
            }
        }
        // TODO : StringTokenizer vs String.split()
    }

    private void initCarList(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void inputGameTurns() {
        try {
            gameTurns = Integer.parseInt(Console.readLine().strip());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Not valid input: game turn number");
        }
    }

    public void findWinners() {
        int maxDistance = -1;
        for(Car car : cars) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
                winners.clear();
                winners.add(car.getName());
            } else if (car.getDistance() == maxDistance) {
                winners.add(car.getName());
            }
        }
    }

    public String winnersToString() {
        return "최종 우승자 : " + String.join(", ", winners);
    }
}
