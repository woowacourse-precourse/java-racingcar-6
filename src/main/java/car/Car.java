package car;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int step) {
        if (step >= 4) {
            position++;
            System.out.println(step+" "+name + " 직진");
        }else{
            System.out.println(step+" "+name + " 정지");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}