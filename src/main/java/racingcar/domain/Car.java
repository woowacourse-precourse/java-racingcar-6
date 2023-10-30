package racingcar.domain;

public class Car {
    private String name;
    private int movement;
    private String dash;
    private final Integer CAN_MOVE = 4;
    private final String DASH = "-";

    public Car (String name, int movement, String dash) {
        this.name = name;
        this.movement = movement;
        this.dash = dash;
    }

    public String getName() {
        return this.name;
    }

    public int getMovement() {
        return this.movement;
    }

    public String getResult() {
        return String.format("%s : %s", this.name, this.dash);
    }

    private void addDash(String dash) {
        this.dash += dash;
    }

    private void addMovement() {
        this.movement++;
    }
    
    public void moveStart(int randomNumber) {
        String dash = " ";
        if (randomNumber >= CAN_MOVE) {
            addMovement();
            dash = DASH;
        }
        addDash(dash);
    }
}
