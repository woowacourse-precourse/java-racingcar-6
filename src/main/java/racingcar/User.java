package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private int playNum;
    private Car[] carList;
    
    public String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String getCarNameList = Console.readLine();
        Verify verify = new Verify();
        
        getCarNameList = getCarNameList.replaceAll(" ", "");
        String[] splitCarNameList = getCarNameList.split(",", -1);

        verify.checkDuplicateCarName(splitCarNameList);
        verify.checkEmptyOrOnlySpaceCarName(splitCarNameList);
        verify.checkCorrectLengthCarName(splitCarNameList);
        
        int carCount = splitCarNameList.length;
        carList = new Car[carCount];
        for (int i = 0; i < carList.length; i++) {
            carList[i] = new Car(splitCarNameList[i]);
        }
        System.out.println("생성완료");
        return getCarNameList;
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
        playNum = Integer.parseInt(getplayNum);
    }

    public int getPlayNum() {
        return playNum;
    }

    public Car[] getCarList() {
        return carList;
    }
}