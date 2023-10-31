package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Inputs {
    private List<String> cars = new ArrayList<>();
    private int count;

    public List<String> getCars(){
        return cars;
    }

    public int getCount(){
        return count;
    }

    public void raiseIllegalArgumentException(String messege) {
        IllegalArgumentException e = new IllegalArgumentException(messege);
        throw e;
    }

    public void inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            String inputStr = Console.readLine();
            String[] strArr = inputStr.split(",");

            for ( int i = 0; i < strArr.length; i++ ) {
                if ( strArr[i].length() <= 0 || strArr[i].length() > 5 ) {
                    raiseIllegalArgumentException("경주할 자동차 이름 길이 Exception");
                }
                cars.add(strArr[i]);
            }

        } catch ( IllegalArgumentException e ) {
            throw e;
        }

    }

    public void inputCounts() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            String inputStr = Console.readLine();
            int inputCount = Integer.parseInt(inputStr);
            if ( inputCount < 1 ) {
                raiseIllegalArgumentException("시도할 회수 입력값 0 이하로 받음");
            }
            count = inputCount;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

}
