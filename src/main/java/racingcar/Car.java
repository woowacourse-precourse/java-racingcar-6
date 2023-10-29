package racingcar;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    protected void move(int number) {
        if (number >= 4){
            position += 1;
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
