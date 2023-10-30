package racingcar.model;

import java.util.List;

public class RacingCar {

    private static final int FORWARD_THRESHOLD = 4;
    private static final int NAME_LIMIT = 5;
    private static final String WRONG_NAME_LENGTH = "이름은 5자 이하만 입력됩니다.";
    private static final String POSITION_SIGN = "-";
    private static final String COLON = " : ";
    private final String name;
    private int position;

    public RacingCar(String name) {
        validate(name);
        this.name = name;
        this.position = 0;
    }

    private void validate(String name) {
        if (name.length() > NAME_LIMIT) {
            throw new IllegalArgumentException(WRONG_NAME_LENGTH);
        }
    }

    public boolean move(int speed) {
        if (speed >= FORWARD_THRESHOLD) {
            this.position += speed;
            return true;
        }
        return false;
    }

    public List<RacingCar> compare(List<RacingCar> nominees) {
        if (nominees.isEmpty() || nominees.get(0).equals_pos(this.position)) {
            nominees.add(this);
        }

        if (nominees.get(0).compare(this.position)) {
            nominees.clear();
            nominees.add(this);
        }

        return nominees;
    }

    private boolean equals_pos(int position) {
        return this.position == position;
    }

    private boolean compare(int position) {
        return this.position < position;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name + COLON + position();
    }

    private String position() {
        return POSITION_SIGN.repeat(this.position);
    }
}
