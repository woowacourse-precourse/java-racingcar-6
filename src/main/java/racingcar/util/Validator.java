package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;

/**
 * 입력값들을 검증 하는 클래스
 */
public class Validator {
    /**
     * 이름들을 검증
     * <p>
     * 개별 이름의 사이즈는 5이하, 공백 및 ,의 이름 및 중복된 이름은 금지
     *
     * @param nameList
     * @throws IllegalArgumentException
     */
    public void names(List<String> nameList) {
        try {
            size(nameList);
            blank(nameList);
            duplicate(nameList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            Console.close();
            throw e;
        }
    }

    /**
     * 시도 횟수 검증
     * <p>
     * 공백 금지, 양의 정수만 허용
     *
     * @param trial
     * @throws IllegalArgumentException
     */
    public void trial(String trial) {
        try {
            blank(trial);
            positive(trial);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            Console.close();
            throw e;
        }
    }

    private void size(List<String> nameList) {
        for (String name : nameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다");
            }
        }
    }

    private void blank(List<String> nameList) {
        for (String name : nameList) {
            if (name.equals("")) {
                throw new IllegalArgumentException("이름에 공백이나 ,은 불가합니다.");
            }
        }
    }

    private void blank(String trial) {
        if (trial.equals("")) {
            throw new IllegalArgumentException("양의 정수를 입력하십시오.");
        }
    }

    private void duplicate(List<String> nameList) {
        HashSet<String> nonDuplicate = new HashSet<>(nameList);
        if (nonDuplicate.size() != nameList.size()) {
            throw new IllegalArgumentException("중복된 이름은 불가합니다.");
        }
    }

    private void positive(String trial) {
        for (int i = 0; i < trial.length(); i++) {
            if (notNum(trial.charAt(i), i)) {
                throw new IllegalArgumentException("양의 정수를 입력하십시오.");
            }
        }
    }

    private boolean notNum(char element, int index) {
        if (index == 0) {
            if (element >= '1' && element <= '9') {
                return false;
            }
            return true;
        }
        if (element >= '0' && element <= '9') {
            return false;
        }
        return true;
    }

}
