package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String[] getCarNames(){
        String[] cars = readLine().split(",");

        if(!isShortEnough(cars)){
            throw new IllegalArgumentException("자동차의 이름이 5자 보다 큽니다.");
        }
        return cars;
    }
    public int getNumberOfAttempts(){
        String inputAttempts = readLine();

        int attempts;
        try{
            attempts = Integer.parseInt(inputAttempts);
        }catch (Exception e){
            throw new IllegalArgumentException("숫자를 입력하세요. 잘못된 입력값입니다.");
        }
        return attempts;
    }

    private boolean isShortEnough(String[] cars) {
        for (String car : cars) {
            if (car.length() > 5) {
                return false;
            }
        }
        return true;
    }
}
