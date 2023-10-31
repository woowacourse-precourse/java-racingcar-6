package racingcar.input.name;

public class NameCounter {
    public static int getCount(String names) {
        if(!names.contains(",")) {
            return 1;
        }

        return names.split(",").length;
    }
}
