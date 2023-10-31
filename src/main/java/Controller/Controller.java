package Controller;

import Model.Car;
import View.Mc;
import camp.nextstep.edu.missionutils.Console;
import validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final List<Car> carList; // 왜 new ArrayList<>()가 불필요한 이니셜라이저? -> 이미 Application에서 생성, List에 모델을 담는다는 생각을 못함
    private static final List<Car> winners = new ArrayList<>(); // private vs private static vs private static final
    private final Mc mc; // private vs private static vs private static final -> private static final은 오류,

    private int tryNum;

    public Controller(Mc mc, List<Car> carList) {
        this.mc = mc;
        this.carList = carList;
    }

    public void gameStart() {
        enterCarName();
        enterTry();
        raceStart();
        calRank();
        mc.showWinner(winners);
    }

    public void enterCarName() { // 경주 할 자동차 이름 입력하는 기능 -> 자동차 개수(List의 size)를 model에게 전달
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");
        Validator.checkValidateCarNames(carNames);

        for(String carName :carNames) { // 경주할 자동차를 어떻게 나누고, List에 집어넣지?, 컬렉션 다루는 연습 좀 더
            Car car = new Car(carName);
            carList.add(car);
        }
    }

    public void enterTry() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String num = Console.readLine();
        System.out.println();

        tryNum = Integer.parseInt(num);
            // 이후에 숫자로 처리할 로직을 추가
    }

    public void raceStart() {
        System.out.println("실행 결과");
        for(int i = 0; i<tryNum; i++) {
            // 자동차 움직이고
            // 결과 보여주는 mc 함수 호출
            for (Car car : carList) {
                car.forward();
            }
            mc.showResult(carList);
        }
    }

    public void calRank() {  // 얘를 model에다가 넣어야 하나?
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
