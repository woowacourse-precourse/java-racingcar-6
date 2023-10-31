package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import racingcar.car.Car;
import racingcar.car.CarService;
import racingcar.constants.Constants;

public class GameService {
    private ArrayList<Car> carList;
    private int tryCount;
    private int maxStepCount = 0;

    public void play() {

        // 자동차 생성
        System.out.println(Constants.CAR_NAME_INPUT);
        CarService carService = new CarService();
        carList = carService.createCarList();

        // 시도 횟수 생성
        System.out.println(Constants.TRY_COUNT_INPUT);
        createTryCount();

        // 실행 결과 출력
        System.out.println(Constants.PLAY_RESULT);
        for (int i = 0; i < tryCount; i++) {
            printResultsByDegree();
        }

        // 최종 우승자 출력
        printFinalWinner();
    }

    public void createTryCount() {
        try {
            String input = Console.readLine();
            this.tryCount = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    // 각 차수별 실행 결과 출력
    public void printResultsByDegree() {
        for (Car car : carList) {
            if (shouldIncreaseStepCount()) {
                car.increaseStepCount();
            }
            int stepCount = car.getStepCount();

            StringBuilder sb = new StringBuilder();
            sb.append(car.getName());
            sb.append(" : ");
            sb.append("-".repeat(stepCount));
            System.out.println(sb);

            if (stepCount > maxStepCount) {
                maxStepCount = stepCount;
            }
        }
        System.out.println();
    }


    public boolean shouldIncreaseStepCount() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }

    public void printFinalWinner() {
        StringBuilder sb = new StringBuilder("최종 우승자 : ");

        for (var car : carList) {
            int stepCount = car.getStepCount();
            if (maxStepCount == stepCount) {
                sb.append(car.getName());
                sb.append(", ");
            }
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb);
    }
}
