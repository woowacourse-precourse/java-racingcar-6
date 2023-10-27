package racingcar.Model.Car;
public class Id {
    private Integer id;
    public Id(Integer id) {
        this.id = id;
    }

    public static IllegalArgumentException validateOverflow(int size) {
        if (size > Integer.MAX_VALUE) {
            throw new IllegalArgumentException();
        }
        return null;
    }
}