package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetName {

    public List<String> person(){
        List<String> name = new ArrayList<>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        Collections.addAll(name, input.split(","));
        for (String s : name) {
            if (s.length() > 5)throw new IllegalArgumentException();
        }
        return name;
    }
}
