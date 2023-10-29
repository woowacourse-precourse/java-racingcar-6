package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Car {
    private List<String> car_name = new ArrayList<>();

    public void setCar_name(String name) {
        divideName(name);
    }

    private void divideName(String name) {
        StringTokenizer tokenizer = new StringTokenizer(name,",");

        while (tokenizer.hasMoreTokens()) {
            car_name.add(tokenizer.nextToken().trim());
        }
    }
}
