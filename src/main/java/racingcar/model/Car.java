package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Car {

    static List<String> names = new ArrayList<>();
    static List<Integer> moves = new ArrayList<>();

    public Car() {

    }

    public Car(List<String> names) {
        this.names = names;
        for (int i = 0; i < names.size(); i++) {
            this.moves.add(0);
        }
    }

    public static List<Integer> getMoves() {
        return moves;
    }

    public static List<String> getNames() {
        return names;
    }

    public int getSize() {
        return names.size();
    }

    public void increaseMove(int index) {
        moves.set(index, moves.get(index) + 1);
    }

    public void addCarNames(List<String> names) {
        this.names.addAll(names);
    }
}
