package racingcar;

public class Car {
    private String carName;
    private int position;
    public Car(String carName) {
        this.carName = carName;
    }

    public void move(){
        this.position++;
    }

    @Override
    public String toString() {
        StringBuilder outputBuilder = new StringBuilder();
        outputBuilder.append(this.carName).append(" : ");
        for (int currentPos = 0; currentPos < this.position; currentPos++) {
            outputBuilder.append("-");
        }
        return outputBuilder.toString();
    }

}
