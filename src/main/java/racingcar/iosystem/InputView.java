package racingcar.iosystem;

import racingcar.errorCheck.ErrorCheck;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private String[] cars;
    private int[] carsMove;
    private int tryCnt;

    public InputView() {
        String[] carList = setCarsName(inputCar());
        int cnt = Integer.valueOf(inputTry());

        ErrorCheck.isCarNameFive(carList);
        ErrorCheck.isDuplicationNameCar(carList);

        ErrorCheck.isZeroValues(cnt);

        this.cars = carList;
        this.carsMove = new int[cars.length];
        this.tryCnt = cnt;
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
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

}
