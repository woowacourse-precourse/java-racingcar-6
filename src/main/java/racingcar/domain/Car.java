package racingcar.domain;

import racingcar.common.consts.SystemConst;

public class Car implements Comparable<Car> {
    private String name;
    private Integer advance;

    public Car(String name) {
        this.name = name;
        this.advance = SystemConst.INITIAL_ADVANCE;
    }

    public Car(String name, int advance) {
        this.name = name;
        this.advance = advance;
    }

    public Car(CarDto carDto) {
        this.name = carDto.getName();
        this.advance = carDto.getAdvance();
    }


    public CarDto toDto() {
        return new CarDto(this.name, this.advance);
    }

    public void move() {
        this.advance += SystemConst.ADVANCE_STEP;
    }

    @Override
    public int compareTo(Car other) {
        return other.advance.compareTo(this.advance);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" : ");
        for (int i = 0; i < this.advance; i++) {
            sb.append(SystemConst.ADVANCE_DISPLAY_CHARACTER);
        }
        return sb.toString();
    }
}
