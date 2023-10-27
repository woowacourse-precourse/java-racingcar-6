package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static String carString;
    private static int tryNum;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        init();     // 자동차 이름 입력, 시도할 횟수 입력

        String[] carArray = changeToCarArr();       // 자동차 이름 분리 저장할 배열


    }

    public static void init() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carString = Console.readLine();
        if (!checkCarLength(carString)) {
            throw new IllegalArgumentException();
        }

        System.out.println("시도할 횟수는 몇회인가요?");
        String tryString = Console.readLine();
        tryNum = Integer.parseInt(tryString);
    }

    public static boolean checkCarLength(String carString) {
        String[] carSplit = carString.split(",");
        for (String c : carSplit) {
            if (c.length() > 5) {
                return false;
            }
        }

        return true;
    }

    public static String[] changeToCarArr() {
        return carString.split(",");
    }
}
