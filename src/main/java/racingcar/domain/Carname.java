package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Carname {
    public List<String> name() {
        List<String> carname = new ArrayList<>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] inputsplit = input.split(",");
        for (int i = 0; i < inputsplit.length; i++) {
            if (inputsplit[i].length() > 5) throw new IllegalArgumentException();
            if (inputsplit[i].length() == 0) throw new IllegalArgumentException();
            carname.add(inputsplit[i]);
        }
        return carname;
    }
}