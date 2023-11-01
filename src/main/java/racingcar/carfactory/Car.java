package racingcar.carfactory;

import racingcar.service.GameService;

public class Car {
    private String name;
    private int location;
    public Car(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public int getLocation(){
        return location;
    }

    public void advanceOnce(){
        location++;
    }

    public void advanceOnceRandomly(GameService gameService){
        if(gameService.randomNumber()>=4){
            advanceOnce();
        }
    }

}
