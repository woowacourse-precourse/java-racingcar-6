package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class game {
    String[] input_name(){ //자동차 이름 입력 후 분류
        String name_bundle;
        String[] names;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        name_bundle = readLine();
        names = name_bundle.split(",");

        return names;
    }
}
