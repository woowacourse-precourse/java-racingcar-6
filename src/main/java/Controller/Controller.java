package Controller;

import Model.Car;
import View.Mc;
import camp.nextstep.edu.missionutils.Console;
import validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final List<Car> carList;
    private final Mc mc;
    private static final List<Car> winners = new ArrayList<>();

    private int tryNum;

    public Controller(Mc mc, List<Car> carList) {
        this.mc = mc;
        this.carList = carList;
    }

    public void gameStart() {
        addCar(enterCarName());
        enterTry();
        raceStart();
        calRank();
        mc.showWinner(winners);
    }

    public String[] enterCarName() { // 경주 할 자동차 이름 입력하는 기능 -> 자동차 개수(List의 size)를 model에게 전달
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");
        Validator.checkValidateCarNames(carNames);
        return carNames;
    }

    public void addCar(String[] carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }
    }

    public void enterTry() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String num = Console.readLine();
        System.out.println();
        tryNum = Integer.parseInt(num);
    }

    public void raceStart() {
        System.out.println("실행 결과");
        for (int i = 0; i < tryNum; i++) {
            for (Car car : carList) {
                car.forward();
            }
            mc.showResult(carList);
        }
    }

    public void calRank() {
        int maxPosition = -1;
        for (Car car : carList) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winners.clear();
                winners.add(car);
            } else if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
    }
}
