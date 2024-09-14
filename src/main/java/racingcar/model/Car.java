package racingcar.model;

public class Car {
    private String name;
    private int position;
    Car(String msg){
        this.name = msg;
        position = 0;
    }

    public String getName(){
        return this.name;
    }

    public void movePosition(){
        position++;
    }

    public int getPositionInt(){
        return position;
    }
    public String getPosition() {
        StringBuilder positionStr = new StringBuilder(); // StringBuilder로 변경
        for(int i = 0; i < position; i++) {
            positionStr.append("-"); // append 메서드 사용
        }
        return positionStr.toString(); // 문자열로 변환하여 반환
    }


}
