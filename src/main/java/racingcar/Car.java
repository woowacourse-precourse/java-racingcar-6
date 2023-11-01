package racingcar;

public class Car {
    private String name;
    private int movingCnt;

    public Car(String name) {
        this.name = name;
        this.movingCnt = 0;
    }

    public void moveForward() {
        movingCnt++;
    }

    public void printResult() {
        String movingResult = "";
        for (int i = 0; i < this.movingCnt; i++) {
            movingResult += "-";
        }
        System.out.println(this.name + " : " + movingResult);
    }
}
