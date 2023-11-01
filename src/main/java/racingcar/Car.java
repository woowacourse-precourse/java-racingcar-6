package racingcar;

public class Car {
    private final String name;
    private int position =0;


    public Car(String name) {
        validateNull(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }

    public void validateNull(String str){
        if(str == null) {
            throw new IllegalArgumentException("null을 입력하지 마세요.");
        }
    }
}