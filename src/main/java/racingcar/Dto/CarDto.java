package racingcar.Dto;

public class CarDto {
    private String carName;
    private int position;

    public CarDto() {
        throw new IllegalArgumentException();
    }

    public CarDto(String carName, int position) {
        throw new IllegalArgumentException();
    }

    public CarDto(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public void setPosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException();
        }
        this.position = position;
    }

    public void plusPosition() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }
}
