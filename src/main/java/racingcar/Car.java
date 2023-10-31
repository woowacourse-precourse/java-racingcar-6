package racingcar;

public class Car {
    public final String name;
    public int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(int distance) {
        System.out.print(this.name+" : ");
        if (distance >= 4) {
            position++;
        }
        for(int i=0; i<position; i++)
        {
            System.out.print("-");
        }
    }
}

