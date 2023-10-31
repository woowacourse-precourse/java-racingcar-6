package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Integer attemptsNumber;
    private Integer currentRound;
    private List<Car> carList;

    public Game() {
        this.currentRound = 0;
    }

    public void start() {
        userInputCarName();
        userInputAttemptsNumber();

        System.out.println("실행 결과");
        playRound(carList.get(0));
    }

    public void userInputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInputCarNameString = Console.readLine();
        String[] userInputCarNameArray = stringToArrayByComma(userInputCarNameString);

        carList = new ArrayList<>();

        for (String userInputCarName : userInputCarNameArray) {
            carList.add(new Car(userInputCarName));
        }
    }

    public void userInputAttemptsNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        attemptsNumber = Integer.valueOf(Console.readLine());
    }

    public String[] stringToArrayByComma(String userInputString) {
        return userInputString.split(",");
    }

    public void playRound(Car car) {
        judgeMovingForward(car);
        printResult(car);
    }

    public void judgeMovingForward(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            car.movingForward();
        }
    }

    private void printResult(Car car) {
        System.out.println(car.getName() + " : ");
        car.printCurrentLocation();
    }
}
