package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.validation.Validation;
import racingcar.view.InputView;
import racingcar.view.OutPutView;
import racingcar.constant.Constant;

import java.util.*;
import java.util.stream.Collectors;

public class GameService {
    private final InputView inputView = new InputView();
    private final OutPutView outPutView = new OutPutView();
    private final Validation validation = new Validation();
    private final List<Car> cars = new ArrayList<>();

    public int randomNum() {
        return Randoms.pickNumberInRange(Constant.MIN_NUM, Constant.MAX_NUM);
    }

    public void carMove() {
        for (Car car : cars) {
            if (randomNum() >= Constant.POSSIBLE_MOVE_NUM) {
                car.setMove(car.getMove() + Constant.CAR_MOVE);
            }
        }
    }

    public void enterCar() {
        String name = inputView.inputCar();
        for (String n : validation.nameCheck(name)) {
            cars.add(new Car(n, Constant.DEFAULT_MOVE));
        }
    }

    public int enterChance() {
        String chance = inputView.inputChance();
        validation.chanceCheck(chance);
        return Integer.parseInt(chance);
    }

    public StringBuilder printStick(int index) {
        StringBuilder sb = new StringBuilder();
        sb.append("-".repeat(Math.max(Constant.DEFAULT_MOVE, cars.get(index).getMove())));
        return sb;
    }

    public void gameResult(int chance) {
        outPutView.outputResult();
        for (int i = 0; i < chance; i++) {
            carMove();
            for (int index = 0; index < cars.size(); index++) {
                if(index == cars.size() - 1){
                    outPutView.outputCar(cars.get(index).getName() + " : " + printStick(index)+ '\n');  //한 라운드가 종료 되었을 경우 줄 바꿈
                }else {
                    outPutView.outputCar(cars.get(index).getName() + " : " + printStick(index));
                }
            }
        }
    }

    public void winnerList() {
        List<Car> winners = cars.stream().filter(car -> car.getMove() == searchMaxValue()).toList();

        String printWinners = winners.stream().map(Car::getName).collect(Collectors.joining(", "));

        outPutView.outputWinner(printWinners);
    }

    public int searchMaxValue() {
        return cars.stream().mapToInt(Car::getMove).max().orElse(0);
    }
}
