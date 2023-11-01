package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User implements UserBehavior{

    private int tryNum;
    private String[] carNames;

    public int getTryNum() {
        return tryNum;
    }

    public String[] getCarNames() {
        return carNames;
    }

    @Override
    public void input() throws IllegalAccessException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        carNames = carName.split(",");

        for(int i=0; i<carNames.length; i++) {
            if(carNames[i].length() > 5) {
                throw new IllegalAccessException("이름은 5자리 이하만 가능합니다.");
            }
        }
        System.out.println("시도할 회수는 몇회인가요?" + "\n");
        tryNum = Integer.parseInt(Console.readLine());
        System.out.println("실행 결과");

    }
}
