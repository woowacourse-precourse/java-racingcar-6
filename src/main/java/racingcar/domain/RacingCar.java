package racingcar.domain;

import racingcar.dto.CarPositionDto;

class RacingCar {
    private final CarName carName;
    private Position position;

    public RacingCar(String carName){
        this.carName= new CarName(carName);
        position = Position.init();
    }

    public void move(){
        position = position.next();
    }

    public int getPosition(){
        return position.getMoveCount();
    }

    public String getCarName(){
        return carName.getName();
    }

    public CarPositionDto toDto() {
        return new CarPositionDto(position.getMoveCount(), carName.getName());
    }

    public boolean matchPosition(int position) {
        return this.position.getMoveCount() == position;
    }


}
