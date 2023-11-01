package racingcar;

import racingcar.domain.Car;
import racingcar.view.InputView;

import java.util.HashSet;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> carNames = InputView.getCarNames();
        int attemptCount = InputView.getAttemptCount();
        int carCount = carNames.size();
        if (carCount < 1 || attemptCount < 1) {
            throw new IllegalArgumentException("자동차 이름과 시도 횟수는 1 이상이어야 합니다.");
        }
        HashSet<String> uniqueCarNames = new HashSet<>();
        for (String carName : carNames) {
            if (carName.trim().length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해야 합니다.");
            }
            if (!uniqueCarNames.add(carName.trim())) {
                throw new IllegalArgumentException("중복된 자동차 이름이 있습니다: " + carName);
            }
        }

        System.out.println("실행 결과");
        int[] carPositions = new int[carCount];
        for (int i = 0; i < attemptCount; i++) {
            for (int j = 0; j < carCount; j++) {
                Car car = new Car();
                if (car.isForward()) {
                    carPositions[j]++;
                }
                System.out.println(carNames.get(j) + " : " + getCarPositionString(carPositions[j]));
            }
            System.out.println();
        }

        int maxPosition = 0;
        for (int position : carPositions) {
            if (position > maxPosition) {
                maxPosition = position;
            }
        }

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < carCount; i++) {
            if (carPositions[i] == maxPosition) {
                System.out.print(carNames.get(i));
                if (i < carCount - 1) {
                    System.out.print(", ");
                }
            }
        }

    }
    private static String getCarPositionString(int position) {
        StringBuilder positionString = new StringBuilder();
        for (int i = 0; i < position; i++) {
            positionString.append("-");
        }
        return positionString.toString();
    }
}
