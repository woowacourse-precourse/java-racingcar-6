package racingcar.model;

public class Car {
    private final String name;
    private int position;
    private final static int CAR_MOVEABLE_VALUE = 4;

    public Car(String name, int position){
        this.name = name;
        this.position = position;
    }

    public void moveOrStop(int moveCommand){
        if (isCarMoveable(moveCommand)) {
            this.position += 1;
        }
    }
    //차 이름과 포지션의 출력 형태를 String으로 보내주는 메소드
    public String provideCarNameAndPositionState(){
        String carNameAndPostionString = this.name + " : ";
        for(int i = 0; i < position; i++){
            carNameAndPostionString += "-";
        }
        return carNameAndPostionString;
    }
    public int getPosition(){
        return this.position;
    }
    private static boolean isCarMoveable(int moveCommand){
        return moveCommand >= CAR_MOVEABLE_VALUE;
    }
}
