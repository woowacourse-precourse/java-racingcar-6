package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String totalCar = Console.readLine();
        String[] carName = totalCar.split(",");
        int[] carPresentPoint = new int[carName.length];

        System.out.println("시도할 회수는 몇회인가요?");
        int count = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < carPresentPoint.length; j++) {
                if (Randoms.pickNumberInRange(0, 9) >= MOVING_FORWARD) carPresentPoint[j] += 1;
            }

            for (int j = 0; j < carName.length; j++) {
                System.out.println(carName[j] + " : " + "-".repeat(carPresentPoint[j]));
            }
            System.out.println("");
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < carPresentPoint.length; i++) {
            max = Math.max(max, carPresentPoint[i]);
        }

        String answer = "";
        for (int i = 0; i < carName.length; i++) {
            if (carPresentPoint[i] == max) {
                answer += carName[i];
                answer += ", ";
            }
        }
        answer = answer.substring(0, answer.length() - 2);

        System.out.println("최종 우승자 : " + answer);
    }
}
