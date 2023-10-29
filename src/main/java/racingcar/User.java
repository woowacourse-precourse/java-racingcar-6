package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private int playnum;
    private Car[] carList;

    public void inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String getCarNameList = Console.readLine();
        getCarNameList = getCarNameList.replaceAll(" ", "");
        String[] splitCarNameList = getCarNameList.split(",", -1);
        for (String carName : splitCarNameList) {
            if (carName.isEmpty()) {
                throw new IllegalArgumentException("이름은 공백이 아니거나 반드시 존재해야 합니다.");
            } else if (carName.length() > 4) {
                throw new IllegalArgumentException("이름은 네글자 이하이어야 합니다.");
            }
        }
        int carCount = splitCarNameList.length;
        carList = new Car[carCount];
        for (int i = 0; i < carList.length; i++) {
            carList[i] = new Car(splitCarNameList[i]);
        }
        System.out.println("생성완료");
    }

    public void setPlayNum() {
        System.out.println("시도할 횟수는 몇번인가요?");
        String getplayNum = Console.readLine();
        for (int i = 0; i < getplayNum.length(); i++) {
            char c = getplayNum.charAt(i);
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("정수만 입력하세요.");
            }
        }
        playnum = Integer.parseInt(getplayNum);
    }

    public Car[] getCarList() {
        return carList;
    }
}