package racingcar.Model;

public class Car {
    private String name;
    private int position;

    public Car(String name){
        this.name=name;
        this.position=0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(RandomNumberGenerator randomNumberGenerator){
        int randomValue =  randomNumberGenerator.nextInt(10);
        if (randomValue >= 4) {
            position++;

        }
    }

    public String getMovement(){
        return "-".repeat(position);
    }

}
