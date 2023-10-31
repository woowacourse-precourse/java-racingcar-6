package racingcar.exception;

import racingcar.domain.Car;
import racingcar.util.GameUtil;

import java.util.ArrayList;
import java.util.Set;

public class InputException {
    GameUtil gameUtil;

    public InputException() {
        gameUtil = new GameUtil();
    }

    public void inputEmpty(String carName) {
        try {
            if (carName.equals("")) {
                throw new IllegalArgumentException("입력값 없음");
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            throw illegalArgumentException;
        }
    }

    public void nameLengthOver(String name) {
        try {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름이 5글자 이하 아님");
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            throw illegalArgumentException;
        }
    }

    public void sameName(ArrayList<Car> carArrayList) {
        try {
            Set<String> nameSet = gameUtil.splitNameSet(carArrayList);
            if (nameSet.size() != carArrayList.size()) {
                throw new IllegalArgumentException("같은 이름 중복");
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            throw illegalArgumentException;
        }
    }

    public void splitNameEmpty(String name){
        try {
            if(name.trim().equals("")){
                throw new IllegalArgumentException("쉼표(,) 기준으로 구분시 이름이 비어있음");
            }
        }catch (IllegalArgumentException illegalArgumentException){
            throw illegalArgumentException;
        }
    }
    public int toNumber(String numberString) {
        try {
            return Integer.parseInt(numberString);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw illegalArgumentException = new IllegalArgumentException("숫자를 입력하지 않음");
        }
    }
}
