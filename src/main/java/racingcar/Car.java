package racingcar;

public class Car {
    public String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void forward() {
        distance ++;
    }

    public int getDistance() {
        return distance;
    }

    public void printForwardDistance() {
        System.out.print(name + " : " );
        for(int i=0;i<distance;i++) {
            System.out.print(Constants.PRINT_CAR_FORWARD);
        }
        System.out.println();
    }
}
