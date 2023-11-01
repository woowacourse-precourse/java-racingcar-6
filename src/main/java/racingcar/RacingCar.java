package racingcar;

public class RacingCar {
    private String name;
    private String count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public RacingCar(String name, String count) {
        this.name = name;
        this.count = count;
    }


}
