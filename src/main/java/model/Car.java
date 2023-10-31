package model;

public class Car {
    String name;
    int stepCount;

    Car(){}
    Car(String name){
        this.name = name;
    }

    //경주 할 자동차 이름 받아오기()

    /**
     *자동차 이름을 받아와 Car객체를 리턴한다.
     *
     * @param name 자동차 이름
     * @return 자동차 객체를 리턴
     */
    public Car setCarName(String name){
        return new Car(name);
    }

    //전진 가능한 랜덤 수 얻기()

    //전진 랜덤 수 판단하기()

}
