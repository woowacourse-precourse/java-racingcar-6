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
                if(canMove()) car.move();
                Output.addResultOutput(car);
            });
            Output.addResultOutput("\n");
        });
    }

    private boolean canMove(){
        int randomNum = createRandom();
        return isOver(randomNum);
    }

    private int createRandom(){
        return Randoms.pickNumberInRange(0,9);
    }

    private boolean isOver(int num){
        return num>=DEPARTURE_CRITERIA;
    }
}
