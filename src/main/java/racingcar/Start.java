package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Start {
    private int attempts;
    private ArrayList<String> carList;

    public void getInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String car = Console.readLine();
        carList = new ArrayList<>();
        String[] inputList = car.split(","); // ok
        for (String o : inputList) {
            if (o.length() >= 6) {
                throw new IllegalArgumentException("입력된 자동차 이름이 6자리 이상입니다.");
            }
            carList.add(o);
        }
        System.out.println("시도할 회수는 몇회인가요?");
        String numberAttemptsStr = Console.readLine();
        attempts = Integer.parseInt(numberAttemptsStr);
    }

    public ArrayList<String> getCarList() {
        return carList;
    }

    public int getNumberAttempts() {
        return attempts;
    }

}
