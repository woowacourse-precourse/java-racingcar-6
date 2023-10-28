package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class MainController {

    public static int ATTEMPT_COUNT = 0;
    public static List<String> CARS;

    public void gameStart() {
        setInput();
        System.out.println(ATTEMPT_COUNT);
        System.out.println(CARS);
    }

    private void setInput() {
        CARS = getCarNameInput();
        //유효 테스트
        ATTEMPT_COUNT = getAttemptCountInput();
        //유효 테스트

    }

    private int getAttemptCountInput() {
        String answer = Console.readLine();

        return Integer.parseInt(answer);
    }

    private List<String> getCarNameInput() {
        String answer = Console.readLine();

        return toListString(answer);
    }

    public List<String> toListString(String str) {
        String[] arry = str.split(",");

        List<String> list = new ArrayList<>();
        for (String sample : arry) {
            list.add(sample);
        }

        return list;
    }
}
