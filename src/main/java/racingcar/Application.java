package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" );
        String[] carNames = getCarNames(sc.nextLine());
        int[] carPositions = new int[carNames.length];
        int numAttempts = getNumAttempts(sc.nextLine());


    }
    public static String[] getCarNames(String names) {
        String[] nameSplit = names.split(",");
        for (int i = 0; i < nameSplit.length; i++) {
            if (nameSplit[i].length() > 5) {
                throw new IllegalArgumentException("5자 이하만 가능합니다.");
            }
        }
        return nameSplit;
    }

    public static int getNumAttempts(String numAttempt ) {
        System.out.println("시도할 회수는 몇회인가요?");
        if (!numAttempt.matches("[0-9]+")) {
            throw new IllegalStateException("숫자로 입력해주세요");
        }
        int numAttempts = Integer.parseInt(numAttempt);
        System.out.println(numAttempts);
        return numAttempts;
    }

}
