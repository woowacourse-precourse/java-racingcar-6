package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {
    public View(){

    }

    public String inputConsole(){
        return readLine();
    }

    public void printCurrentCarsResult(Cars cars){
        for(Car car:cars.getCars()){
            printCurrentCarResult(car);
        }
    }

    public void printCurrentCarResult(Car car){
        System.out.println(car.getNameValue()+" : "+car.getCurrentPositionStatus());
    }
}
