package service;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Car;
import domain.Cars;
import dto.UserInputCarMoveCountDto;
import ui.Output;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class CarMoveService {

    public static final int DEPARTURE_CRITERIA = 4;

    public void move(Cars cars, UserInputCarMoveCountDto userInputCarMoveCountDto){
        IntStream.range(0,(int)userInputCarMoveCountDto.getMoveCount()).forEach(i -> {
            cars.getCars().forEach(car -> {
                move(car);
                Output.addResultOutput(car);
            });
            Output.addResultOutput("\n");
        });
    }

    private void move(Car car){
        int randomNum = createRandom();
        if(isOver(randomNum)) car.setMoveCount(car.getMoveCount()+1);
    }

    private int createRandom(){
        return Randoms.pickNumberInRange(1,9);
    }

    private boolean isOver(int num){
        return num>=DEPARTURE_CRITERIA;
    }
}
