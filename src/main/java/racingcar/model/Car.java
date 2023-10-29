package racingcar.model;

public class Car {
    private String name;
    private int distance;
    private String bar;

    public Car(String name) {
        this.name = name;
    }

    // 객체의 distance 업데이트
    public void updateDistance(int distance){
        for (int i = 0; i<distance; i++){
            this.bar += "-";
        }
        this.distance += distance;

    }

    @Override
    // "pobi : -----" 이렇게 넘기도록
    public String toString() {
        return name + " : " + bar+"\n";
    }

}
