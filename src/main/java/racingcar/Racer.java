package racingcar;

import java.util.Arrays;

public class Racer {
    public final  String[] name;
    public final StringBuilder position;
    public Racer(String[] name) {
        this.name = name;
        this.position = new StringBuilder();
    }
    public void advance(){
        position.append("-");
    }
    public String toString(){
        return Arrays.toString(name) + " : " + position.toString();
    }
}
