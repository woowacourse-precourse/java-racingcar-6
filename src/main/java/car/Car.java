package car;

public class Car {
    private final String name;
    private int location; // 초기값 0
    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
    public void move(){
        this.location++;
    }

    public void moveByIntValue(int number) { // 변수명 바꿔야한다.
        if (number >= 4){
            move();
        }
    }

    public void moveByStrategy(MovingStrategy movingStrategy){
        if (movingStrategy.move()){
            this.move();
        }
    }

    public void moveByGivenCondition(int randomValue){
        this.moveByStrategy(() -> randomValue >= 4);
    }
}
