package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
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
    
    public Map<String, Integer> printRacing(Map<String, Integer> carInfo) {
        for (Map.Entry<String, Integer> entry : carInfo.entrySet()) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (randomNumber >= 4) {
                entry.setValue(entry.getValue() + 1);
            }
            System.out.println(entry.getKey() + " : " + "-".repeat(entry.getValue()));
        }
        return carInfo;
    }

    public void printTotalRacing(Map<String, Integer> carInfo, int count) {
        System.out.println("실행 결과");
        for (int i = 0; i<count; i++) {
            printRacing(carInfo);
        }
        int maxValueInMap=(Collections.max(carInfo.values()));
        System.out.print("최종 우승자 : ");
        int cnt = 0;
        for (Map.Entry<String, Integer> entry : carInfo.entrySet()) {
            cnt++;
            if (cnt == 1) {
                System.out.println(entry.getKey());
            }
            else if (entry.getValue() == maxValueInMap) {
                System.out.print("," + entry.getKey());
            }
        }
    }

}
