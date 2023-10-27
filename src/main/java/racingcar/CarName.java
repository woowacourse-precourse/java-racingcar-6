package racingcar;

public class CarName {

    private String name;

    public CarName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != CarName.class) {
            return false;
        }
        return this.name.equals(((CarName) obj).name);
    }
}
