package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.CarNameList;


import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        CarNameList carNameList = new CarNameList();

        System.out.println(carNameList.compareName(carName));
        System.out.println("시도할 회수는 몇회인가요?");
        String tryNum = Console.readLine();


    }
}
