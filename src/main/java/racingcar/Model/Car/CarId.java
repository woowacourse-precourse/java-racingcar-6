package racingcar.Model.Car;
public class CarId {
    private Integer id;
    public CarId(Integer id) {
        this.id = id;
    }

    public static IllegalArgumentException validateOverflow(int size) {
        if (size > Integer.MAX_VALUE) {
            throw new IllegalArgumentException();
        }
        return null;
    }

    public Integer getId() {
        return id;
    }
}