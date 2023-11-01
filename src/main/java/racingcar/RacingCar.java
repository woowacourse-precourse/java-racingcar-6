package racingcar;

public class RacingCar {
    private String name;
    private int position = 0;

    public RacingCar(String name) {
        this.name = name;
    }

    public void move(int radomValue) {
        if(radomValue >= 4){
            position++;
        }
    }

    public String getName(){
        return name;
    }

    public int getPosition(){
        return position;
    }
}
