package racingcar;

public class Car {
    private final String name;
    private int position = 0;
    public static int MINIMUM_REQUIRED_TO_MOVE = 4;
    public static int MOVE_DISTANCE = 1;

    public Car(String name) {
        this.name = name;
    }

    protected void move(Dice dice) {
        if (dice.roll() >= MINIMUM_REQUIRED_TO_MOVE){
            position += MOVE_DISTANCE;
        }
        printResult();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void printResult(){
        String posStr = this.name + " : " + "-".repeat(position);
        System.out.println(posStr);
    }

}
