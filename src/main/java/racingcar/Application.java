package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Set<String> carNames = getCarNames();
        int playCount = getPlayCount();

        System.out.println(carNames);
        System.out.println(playCount);

        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        System.out.println("\n실행 결과");
        for (int i = 0; i < playCount; i++) {
            for (Car car : cars) {
                car.move();
            }

            for (Car car : cars) {
                car.printLocation();
            }

            System.out.print("\n");
        }

        printGameResult(cars);

    }

    static void start() {

        RacingView racingView = new RacingView();

        racingView.inputCarNames();
        racingView.inputPlayCount();

        racingView.printPlayResult();
    }
    static Set<String> getCarNames() {
        Set<String> carNames = new HashSet<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = readLine();

        if (!inputNames.contains(",")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        String[] splitNames = inputNames.split(",");

        for (String carName : splitNames) {
            if (1 > carName.length() || carName.length() > 5) {
                throw new IllegalArgumentException("이름 길이는 1 ~ 5자 이내 입니다.");
            }

            if (carNames.contains(carName)) {
                throw new IllegalArgumentException("중복된 이름이 있습니다.");
            }

            carNames.add(carName);
        }

        if (carNames.size() == 0 || carNames.size() > 5) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        return carNames;
    }

    static int getPlayCount() {
        int playCount = 0;

        System.out.println("시도할 회수는 몇회인가요?");

        try {
            String inputCount = readLine();
            playCount = Integer.parseInt(inputCount);

        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        if (playCount < 1 || playCount > 10) {
            throw new IllegalArgumentException("플레이 횟수는 1~10 사이 입니다.");
        }

        return playCount;
    }

    static void printGameResult(List<Car> cars) {

        int maxMoveDistance = 0;
        List<String> winnerNames = new ArrayList<>();

        for (Car car : cars) {

            int nowCarMoveDistance = car.getMovedDistance();

            if (nowCarMoveDistance == maxMoveDistance) {
                winnerNames.add(car.getName());
            }

            if (nowCarMoveDistance > maxMoveDistance) {
                maxMoveDistance = nowCarMoveDistance;
                winnerNames.clear();
                winnerNames.add(car.getName());
            }
        }

        System.out.print("최종 우승자 : " + winnerNames.get(0));

        for (int i = 1; i < winnerNames.size(); i++) {
            System.out.print(", " + winnerNames.get(i));
        }
    }
}
