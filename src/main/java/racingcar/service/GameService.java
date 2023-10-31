package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.PlayGameRequestDto;
import racingcar.dto.PlayGameResponseDto;
import racingcar.model.Car;

public class GameService {
    private static final int MIM_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int PIVOT_NUMBER = 4;

    private final ConsolePrintServiceImpl printService;

    public GameService(ConsolePrintServiceImpl printService) {
        this.printService = printService;
    }

    public PlayGameResponseDto playGame(PlayGameRequestDto dto){//PlayGameRequestDto, PlayGameResponseDto
        List<Car> carList = initCarList(dto.getCarNameString());

        printService.printResultNotice();

        //game 진행
        int count = dto.getTryNumber();
        while(count > 0){
            carList.forEach(car -> playEachCarGame(car));
            printService.printGameResult(carList);
            count--;
        }

        return new PlayGameResponseDto(getGameWinner(carList));
    }

    private List<Car> initCarList(List<String> carNameList){
        List<Car> carList = carNameList.stream().map(Car::new).collect(Collectors.toList());
        return carList;
    }

    private Car playEachCarGame(Car car){
        if(canForward(makeRandomNumber())){
            car.forward();
        }
        return car;
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(MIM_NUMBER, MAX_NUMBER);
    }

    private boolean canForward(int number) {
        if(number < PIVOT_NUMBER) return false;
        return true;
    }

    private List<String> getGameWinner(List<Car> carList) {
        Car max = carList.get(0);
        //최종 우승자 선정
        for (Car car : carList) {
            max = car.maxDistanceCar(max);
        }

        List<String> winnerList = new ArrayList<>();
        for(Car car : carList){
            if(max.isSameDistance(car)){
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

}
