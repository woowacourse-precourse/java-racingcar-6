package racingcar.domain;

import static racingcar.domain.NumberConstant.*;

public class RacingCar {
    String name;
    long location;

    // 시작 location 설정해야 함
    public static RacingCar createRacingCar(String name) {
        RacingCar racingCar = new RacingCar();

        racingCar.setName(name);
        racingCar.setLocation(INITIAL_LOCATION);

        return racingCar;
    }

    public void putForward() {
        ++this.location;
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
