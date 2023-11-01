package racingcar.Domain;

import java.util.ArrayList;
import java.util.List;

public class Car {
    String name;
    ArrayList<String> forwardStack= new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getForwardStack() {
        return forwardStack;
    }

    public void setForwardStack(ArrayList<String> forwardStack) {
        this.forwardStack = forwardStack;
    }
}
