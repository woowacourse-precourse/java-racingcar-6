package game.car;

public class Car {
    private final CarName carName;
    private int position;

    public Car(String inputSting) {
        this.carName = new CarName(inputSting);
        this.position = 0;
    }

    public void moveForward() {

    }

    public void printPosition(){
        System.out.printf("%s : %s\n",carName.getCarName(),"-".repeat(position));
    }
}
