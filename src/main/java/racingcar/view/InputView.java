package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    public String[] getCarNames(){
        String[] cars = readLine().split(",");
        validateCarNames(cars);
        return cars;
    }

    public int getNumberOfAttempts(){
        String inputAttempts = readLine();
        return validateNumberOfAttempts(inputAttempts);
    }

    private void validateCarNames(String[] cars) {
        if(!isShortEnough(cars)){
            throw new IllegalArgumentException("자동차의 이름이 5자 보다 큽니다.");
        }
    }

    private static int validateNumberOfAttempts(String inputAttempts) {
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
            if (car.length() > MAX_CAR_NAME_LENGTH) {
                return false;
            }
        }
        return true;
    }
}
