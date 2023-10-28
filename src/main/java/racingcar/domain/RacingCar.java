package racingcar.domain;

public class RacingCar {
    String name;
    long location;

    // 시작 location 설정해야 함
    public static RacingCar createRacingCar(String name) {
        RacingCar racingCar = new RacingCar();

        racingCar.name = name;
        racingCar.location = 0;

        return racingCar;
    }

    public void putForward(long distance) {
        this.location += distance;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Long getLocation() {
        return location;
    }

    private void setLocation(long location) {
        this.location = location;
    }
}
