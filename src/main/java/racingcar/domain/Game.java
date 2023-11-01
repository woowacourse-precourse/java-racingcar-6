package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import racingcar.utils.GameUtil;

public class Game {

    private List<Car> cars = new ArrayList<>();
    private List<String> winners;
    private int totalTrialCount;
    private int curTrialCount = 0;

    private final GameUtil gameUtil = new GameUtil();

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public void generateCarsByCarNames(String carNames) {
        List<String> carNamesList = gameUtil.splitNamesByComma(carNames);

        for (String carName : carNamesList) {
            Car newCar = new Car(carName);
            cars.add(newCar);
        }
    }

    public void inputTrialCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String trialCountString = Console.readLine();
        totalTrialCount = Integer.parseInt(trialCountString);
    }

    public void playGame() {
        System.out.println();
        System.out.println("실행 결과");

        while (curTrialCount < totalTrialCount) {
            attemptTrial();
            curTrialCount++;
        }
    }

    public void attemptTrial() {
        for (Car car : cars) {
            car.attemptGo();
            car.printPosition();
        }
        this.curTrialCount++;
        System.out.println();
    }

    public void judgeWinners() {
        cars.sort(Comparator.comparingInt(car -> car.getPosition() * (-1)));
        int maxPosition = cars.get(0).getPosition();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            } else {
                break;
            }
        }
    }

    public void printWinners() {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

}
