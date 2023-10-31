package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class InputDesk {
    private List<String> cars = new ArrayList<>();
    private int count;

    public List<String> getCars(){
        return cars;
    }

    public int getCount(){
        return count;
    }

    public void checkIllegalArgumentException(String carName) {
        if ( carName == null ) {
            throw new IllegalArgumentException("자동차 이름 입력값 null");
        }

        if ( carName.length() <= 0 ) {
            throw new IllegalArgumentException("자동차 이름 길이 0");
        }

        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름 길이 5 초과");
        }

    }

    public void checkIllegalArgumentException(int inputCount) {
        if ( inputCount < 1 ) {
            throw new IllegalArgumentException("시도할 회수 입력값 0 이하");
        }
    }


    public void inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            String inputStr = Console.readLine();
            checkIllegalArgumentException(inputStr);
            String[] strArr = inputStr.split(",");

            for ( int i = 0; i < strArr.length; i++ ) {
                checkIllegalArgumentException(strArr[i]);
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
                checkIllegalArgumentException(inputCount);
            }
            count = inputCount;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

}
