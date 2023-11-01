package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Random;

public class RacingCarGame {

    private final User user;

    public RacingCarGame() {
        this.user = new User();
    }

    public void play() {
        List<Car> carList = user.createCar();
        int roundTime = user.setRoundTime();

        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < roundTime; i++) {
            proceedRacingCarGame(carList);
            printRacingCarGameProgress(carList);
        }

        printWinnerCarName(carList);
    }

    public void proceedRacingCarGame(List<Car> carList) {
        for (Car car : carList) {
            int num = pickNumber(0, 9);
            updateStatus(num, car);
        }
    }

    public int pickNumber(int start, int end) {
        int num = Randoms.pickNumberInRange(start, end);
        return num;
    }

    public void updateStatus(int num, Car car) {
        if (num >= 4) {
            car.updateStatus();
        }
    }

    public void printRacingCarGameProgress(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getStatus()));
        }
        System.out.println();
    }

    public void printWinnerCarName(List<Car> carList) {
        List<String> winnerList = judgeWinnerCarName(carList);
        System.out.println("최종 우승자 : " + String.join(", ", winnerList));
    }

    public List<String> judgeWinnerCarName(List<Car> carList) {
        int maxStatus = carList.stream()
                .mapToInt(car -> car.getStatus())
                .max()
                .getAsInt();
        List<String> winnerList = carList.stream()
                .filter(car -> car.getStatus() == maxStatus)
                .map(car -> car.getName())
                .toList();
        return winnerList;
    }
}
