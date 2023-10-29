package racingcar.model;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    // 객체의 distance 업데이트
    public void updateDistance(int distance){

    }

    @Override
    // "pobi : -----" 이렇게 넘기도록
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                '}';
    }

    // ----- 리턴
    public String bar(){
        return "";
    }
}
