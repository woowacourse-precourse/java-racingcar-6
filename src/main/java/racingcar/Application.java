package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)");
        String names = Console.readLine();
        moreThanFiveLetter(names);
        String[] carNames = divideNames(names);

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());

    }

    static String [] divideNames(String names) {
        String [] carNames = names.split(",");
        return carNames;
    }

    static void moreThanFiveLetter(String names) {
        String [] carNames = names.split(",");
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
