package racingcar;

public class Car {
    private final String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void move(int random) {
        if(random >= 4) {
            position++;
            System.out.println(name + " : -");
        } else {
            if(position == 0) {
                System.out.println(name + " : ");
                return;
            }
            position--;
            System.out.println(name + " : ");
        }
    }

    public int getPosition() {
        return position;
    }
}
