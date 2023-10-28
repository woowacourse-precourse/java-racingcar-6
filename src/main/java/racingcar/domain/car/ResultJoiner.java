package racingcar.domain.car;

public class ResultJoiner {
    public static String join(Name name, Distance distance) {
        return name.value() + " : " + distance.visualize();
    }
}
