package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.script.Script;

import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Script.LINEUP.print();
        HashMap<String, Integer> entry = lineUp();
        // hi,my,name,is,hello,world

        System.out.println(entry);
    }

    public static HashMap<String, Integer> lineUp() {
        HashMap<String, Integer> lineUp = new HashMap<>();
        String[] lineUpArr = Console.readLine().split(",");

        for (String name : lineUpArr) {
            lineUp.put(name, 0);
        }

        return lineUp;
    }
}
