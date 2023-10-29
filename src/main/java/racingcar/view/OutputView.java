package racingcar.view;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OutputView {

    public void initial() {
        System.out.println("\n실행 결과");
    }

    public void result(String name, String bar) {
        System.out.println(name + " : " + bar);
    }

    public void winner(HashMap distance) {
        System.out.println(distance);
    }
}
