package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayCarGame {
    public void playgame(){
        User user = new User();
        Car car = new Car();
        System.out.println("자동차 이름을 입력하세요");
        String[] carNames = car.build();
        System.out.println("시도할 횟수를 입력해주세요");
        int attempt = user.numAttempt();
        int[] moveDistances = new int[carNames.length];
        int carCount = carNames.length;
        int[] carPositions = new int[carCount];

        for (int i = 0; i < attempt; i++) {
            for (int j = 0; j < carCount; j++) {
                carPositions[j] = carPositions[j] + car.move();

                System.out.print(carNames[j] + " : ");
                for (int k = 0; k < carPositions[j]; k++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }

        int maxPosition = 0;
        for (int i = 0; i < carCount; i++) {
            if (carPositions[i] > maxPosition) {
                maxPosition = carPositions[i];
            }
        }

        System.out.print("최종 우승자 : ");
        StringBuilder winners = new StringBuilder();
        for (int i = 0; i < carCount; i++) {
            if (carPositions[i] == maxPosition) {
                winners.append(carNames[i]);
                winners.append(", ");
            }
        }
        winners.delete(winners.length() - 2, winners.length());
        System.out.println(winners);
    }


}
