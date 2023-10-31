package racingcar.car;

import racingcar.system.SystemConstant;

public class CarPositionDto {

    private String position;

    public CarPositionDto(){
        position = SystemConstant.WAIT_LINE_POSITION;
    }
    public CarPositionDto(String position){
        this.position = position;
    }

    public String getPosition() {
        return position;
    }
    public int getPositionLength(){
        return position.length();
    }
}
