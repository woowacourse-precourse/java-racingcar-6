package racingcar;

public class Car {
    private String name;
    private int position = 0;

    public static int MINIMUM_REQUIRED_FOR_MOVE = 4;

    public static int MOVE_DISTANCE = 1;

    public Car(String name) {
        this.name = name;
    }

    protected void move(int number) {
        if (number >= MINIMUM_REQUIRED_FOR_MOVE){
            position += MOVE_DISTANCE;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    protected void printResult(){
        String posStr = this.name + " : " + "-".repeat(position);
        System.out.println(posStr);
    }

}
