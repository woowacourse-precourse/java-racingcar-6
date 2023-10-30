package racingcar.model;

public class Car {

    private String name;
    private int go = 0;

    public Car(String name){

        if (name == null || name.length() > 5) { // 자동차 입력값이 null, 5이상일 때 예외 호출
            throw new IllegalArgumentException("사용자 입력 오류");
        }
        this.name = name;
    }

    public void move(int number){
        if (number >= 4) {
            go++;
        }
    }

    public int getMove(){
        return go;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(go);
    }

}
