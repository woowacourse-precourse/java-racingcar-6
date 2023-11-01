package Model;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void changePosition(int num) {
        CarMovementLogic move = new CarMovementLogic();
        if (move.isMoving(num)) {
            position = move.positionUpdate(position);
        }
    }

    public void moveRole() {
        CarMovementLogic move = new CarMovementLogic();
        int num = move.randomNumber();
        changePosition(num);
    }
}
