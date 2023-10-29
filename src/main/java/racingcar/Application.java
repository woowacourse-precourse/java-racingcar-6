package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());

        String[] participants = input.split(",");
        int[] runDistance = new int[participants.length];

        for (int i = 0; i < tryCount; i++) {
            for (int j = 0; j < participants.length; j++) {
                if (goOrStop()) {
                    runDistance[j] = runDistance[j] + 1;
                }
            }
            for (int k = 0; k < participants.length; k++) {
                System.out.println(participants[k] + " : " + runDistance[k]);
            }
            System.out.println();
        }
    }

    public static boolean goOrStop() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            return true;
        } else {
            return false;
        }
    }
}
