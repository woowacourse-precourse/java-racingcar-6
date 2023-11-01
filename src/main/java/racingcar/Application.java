package racingcar;

import java.security.SecureRandomSpi;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        IllegalArgumentException ee = new IllegalArgumentException();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String nameList = camp.nextstep.edu.missionutils.Console.readLine();
        String name[] = nameList.split(",");
        int dis[] = new int[name.length];

        for (int i = 0; i < name.length; i++) {
            if (name[i].length() > 5) {
                throw ee;
            }
        }

        int n;
        System.out.println("시도 할 횟수는 몇 회 인가요?");
        try {
            n = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
        } catch (Exception e) {
            throw ee;
        }
    }

}
