package racingcar.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validation {
    private final int MAX_LENGTH = 5;

    public void lengthCheck(String [] names){
        for(String name : names){
            if (name.length() > MAX_LENGTH)
                throw new IllegalArgumentException("문자 열의 크기가 5를 초과 합니다.");
        }
    }

    public void duplicateCheck(String [] names){
        Set<String> dup = new HashSet<>(Arrays.asList(names));
        if (dup.size() != names.length)
            throw new IllegalArgumentException("입력한 이름 중에 중복된 값이 존재 합니다.");
    }

    public void blankCheck(String name, String [] names){
        int cnt = 0;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == (','))
                cnt++;
        }
        if (names.length != (cnt + 1))
            throw new IllegalArgumentException("입력한 문자열 중에 연속해서 ','가 입력 되었습니다 .");

        for (String n : names) {
            if (n.isBlank())
                throw new IllegalArgumentException("입력한 문자열 중에 공백이 존재 합니다.");
        }
    }

    public String[] nameCheck(String name) {
        String[] names = name.split(",");
        lengthCheck(names);
        duplicateCheck(names);
        blankCheck(name, names);
        return names;
    }

    public void chanceCheck(String c) {
        try {
            Integer.parseInt(c);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 올 바르게 입력 하세요.");
        }
    }
}
