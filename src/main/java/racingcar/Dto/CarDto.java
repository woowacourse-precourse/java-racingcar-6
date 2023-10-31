package racingcar.Dto;

public class CarDto {
    private static final int MIN_POSITION = 0;
    private String carName;
    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private int position;
    private boolean won = false;

    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public CarDto() {
        throw new IllegalArgumentException();
    }

    public CarDto(String carName, int position, int index) {
        throw new IllegalArgumentException();
    }

    public CarDto(String carName) {
        throw new IllegalArgumentException();
    }

    public CarDto(String carName, int index) {
        this.carName = carName;
        this.position = 0;
        this.index = index;
    }

    public void setPosition(int position) {
        isNegative(position);
        this.position = position;
    }

    private void isNegative(int position) {
        if (position < MIN_POSITION) {
            throw new IllegalArgumentException();
        }
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
