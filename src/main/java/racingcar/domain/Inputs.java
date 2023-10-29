package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Inputs {
    private static List<String> cars = new ArrayList<>();
    private static int count;

    public static List<String> getCars(){
        return cars;
    }

    public static int getCount(){
        return count;
    }

    public static void raiseIllegalArgumentException() {
        IllegalArgumentException e = new IllegalArgumentException();
        throw e;
    }

    public static void inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            String inputStr = Console.readLine();
            String[] strArr = inputStr.split(",");

            for ( int i = 0; i < strArr.length; i++ ) {
                if ( strArr[i].length() <= 0 || strArr[i].length() > 5 ) {
                    raiseIllegalArgumentException();
                }
                cars.add(strArr[i]);
            }

        } catch ( IllegalArgumentException e ) {
            throw e;
        }

    }

    public static void inputCounts() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            String inputStr = Console.readLine();
            int inputCount = Integer.parseInt(inputStr);
            if ( inputCount < 1 ) {
                raiseIllegalArgumentException();
            }
            count = inputCount;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

}
