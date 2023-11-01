package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.CarNameList;
import racingcar.domain.GoStop;
import racingcar.domain.Rank;


import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();

        CarNameList carNameList = new CarNameList();
        List<String> listA = carNameList.compareName(carName);
        for (int i = 0; i < listA.size(); i++) {
            if (listA.get(i).length() > 5) {
                throw new IllegalArgumentException();
            }
        }

        System.out.println("시도할 회수는 몇회인가요?");
        String tryNumber = Console.readLine();
        int tryNum = Integer.parseInt(tryNumber);

        GoStop goStop = new GoStop();
        List<String> listB = goStop.racing(listA, tryNum);

        Rank rank = new Rank();
        System.out.println();
        System.out.print("최종 우승자 : " + rank.result(listA, listB));


    }
}
