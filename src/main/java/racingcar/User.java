package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;

public class User implements UserBehavior{

    private int tryNum;
    private String[] carNames;
    private final HashMap<String, Integer> map = new HashMap<>();

    public int getTryNum() {
        return tryNum;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public HashMap<String, Integer> getMap() {
        return map;
    }

    @Override
    public void input() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        carNames = carName.split(",");

        for(int i=0; i<carNames.length; i++) {
            if(carNames[i].length() > 5) {
                throw new IllegalArgumentException("이름은 5자리 이하만 가능합니다.");
            }
        }
        saveCarNameToMap();

        System.out.println("시도할 회수는 몇회인가요?");
        try {
            tryNum = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자만 입력 가능합니다.");
        }
        System.out.println("\n" + "실행 결과");
    }

    @Override
    public void saveCarNameToMap() {
        for (String carName : carNames) {
            map.put(carName, 0);
        }
    }
}
