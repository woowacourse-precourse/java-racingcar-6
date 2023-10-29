package service;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Cars;
import dto.UserInputCarMoveCountDto;

import java.util.stream.IntStream;

public class CarMoveService {

    public static final int DEPARTURE_CRITERIA = 4;

    public void move(Cars cars, UserInputCarMoveCountDto userInputCarMoveCountDto){
        cars.getCars().forEach(car -> car.setMoveCount(move(userInputCarMoveCountDto)));
    }

    private int move(UserInputCarMoveCountDto userInputCarMoveCountDto){
        int moveCount = userInputCarMoveCountDto.getMoveCount();

        return IntStream.range(0, moveCount)
                .mapToObj(i -> createRandom())
                .filter(this::isOver)
                .mapToInt(e -> 1)
                .sum();
    }

    private int createRandom(){
        return Randoms.pickNumberInRange(1,9);
    }

    private boolean isOver(int num){
        return num>=DEPARTURE_CRITERIA;
    }
}
