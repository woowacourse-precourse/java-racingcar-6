package racingcar.component;

public class Inputter {
    private Inputter() {}
    private static Inputter inputter;

    public static Inputter getInputter() {
        if (inputter == null) {
            inputter = new Inputter();
        }
        return inputter;
    }
}
