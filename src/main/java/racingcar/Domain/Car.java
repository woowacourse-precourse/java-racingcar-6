package racingcar.Domain;

public class Car {

    private static final Integer MOVE_LENGTH_START = 0;
    private static final Integer MOVE_LENGTH_END = 9;

    public String name;
    public Integer point;

    public Car(String name, Integer point){

    }

    public String getName() {
        return name;
    }

//    private void setName(String name) {
//        this.name = name;
//    }

    public Integer getPoint() {
        return point;
    }

    private void setPoint(Integer point) {
        this.point = point;
    }

    public void move(){

    }

    private Integer createRandomValue(){
        return null;
    }

    private boolean checkRandomValueValidation(Integer randomValue){

        return false;
    }

}
