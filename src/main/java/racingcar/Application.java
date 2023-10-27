package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {
    static ArrayList<String> carNameSplit(String racingCarNames){
        ArrayList<String> nameList = new ArrayList<>();
        for(String carName : racingCarNames.split(",")){
            nameList.add(carName);
        }
        return nameList;
    }
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String racingCarNames = Console.readLine();
        System.out.println("시도할 회수는 몇회인가요?");
        String iterateNumber = Console.readLine();
    }
}
