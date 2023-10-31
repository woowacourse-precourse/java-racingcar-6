package racingcar.iosystem;

import racingcar.errorCheck.ErrorCheck;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private String[] cars;
    private int[] carsMove;
    private int tryCnt;

    public InputView() {
        String[] carList = setCarsName(inputCar());
        ErrorCheck.isCarNameFive(carList);
        ErrorCheck.isCarsNameInSpace(carList);
        ErrorCheck.isDuplicationNameCar(carList);
        OutputView.printCarList(carList);

        String cnt = inputTry();
        ErrorCheck.isTryDigit(cnt);
        int cntInt = Integer.valueOf(cnt);
        ErrorCheck.isZeroValues(cntInt);
        OutputView.printCntInt(cntInt);

        this.cars = carList;
        this.carsMove = new int[cars.length];
        this.tryCnt = cntInt;
    }

    public String[] getCars() {
        return cars;
    }

    public int[] getCarMove() {
        return carsMove;
    }

    public int getTryCnt() {
        return tryCnt;
    }

    public String[] setCarsName(String input) {
        String[] carList = input.split(",");
        return carList;
    }

    public String inputCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String inputTry() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return Console.readLine();
    }

}
