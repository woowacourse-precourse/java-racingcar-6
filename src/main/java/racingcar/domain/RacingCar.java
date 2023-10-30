package racingcar.domain;

class RacingCar {
    private static final int FORWARD = 4;
    private final CarName carName;
    private Position position;

    public RacingCar(String carName){
        this.carName= new CarName(carName);
        position = Position.init();
    }

    public void move(int number){
        if(number >= FORWARD){
            position = position.next();
        }
    }

    public int getPosition(){
        return position.getMoveCount();
    }

    public String getCarName(){
        return carName.getName();
    }

}
