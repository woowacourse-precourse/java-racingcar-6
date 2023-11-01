package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class Racing {

    private int count;
    public void printSetCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printSetCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public int getCount() {
        return count;
    }

    public void setCount() {
        String str = Console.readLine();
        count = Integer.parseInt(str);
    }
    
    public void printRacing(Map<String, Integer> carInfo) {
        for (Map.Entry<String, Integer> entry : carInfo.entrySet()) {
            System.out.println(entry.getKey() + " : " + "-".repeat(entry.getValue()));
        }
    }



}
