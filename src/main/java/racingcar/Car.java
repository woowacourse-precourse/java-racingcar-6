package racingcar;

public class Car implements Comparable<Car>{
    private String name;
    private int movingCnt;

    public Car(String name) {
        this.name = name;
        this.movingCnt = 0;
    }

    public void moveForward() {
        movingCnt++;
    }
    public String getName(){
        return this.name;
    }
    public int getMovingCnt(){
        return this.movingCnt;
    }

    public void printResult() {
        StringBuilder movingResult = new StringBuilder();
        for (int i = 0; i < this.movingCnt; i++) {
            movingResult.append("-");
        }
        System.out.println(this.name + " : " + movingResult);
    }

    @Override
    public int compareTo(Car o) {
        return this.movingCnt - o.movingCnt;
    }
}
