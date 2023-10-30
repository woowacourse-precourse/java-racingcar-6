package racingcar.model;

public class Car {
    private String name;
    private int distance;
    private String bar ="";

    // test
    public Car(String name, int distance){
        this.name = name;
        this.distance = distance;
        String b = "";
        for (int i= 0; i<distance; i++){
            b += "-";
        }
        this.bar = b;
    }
    public Car(String name) {
        this.name = name;
    }

    // 객체의 distance 업데이트
    public void updateDistance(int distance){
        if (distance == 1){
            this.bar += "-";
        }
        this.distance += distance;

    }

    @Override
    // "pobi : -----" 이렇게 넘기도록
    public String toString() {
        return name + " : " + bar+"\n";
    }

    public int getDistance() {
        int returnDis = distance;
        return returnDis;
    }

    public String getName() {
        return name;
    }
}
