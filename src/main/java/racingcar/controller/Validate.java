package racingcar.controller;


import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Validate {

    public boolean validateName(List<String> nameList){
        for (String name: nameList){
            if (name.length() > 5){
                throw new IllegalArgumentException("잘못된 값을 입력했습니다. 프로그램이 종료됩니다.");
            }
        }
        return true;
    }

    public boolean validateNumber(String number){
        try{
            parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다. 프로그램이 종료됩니다.");
        }
        return true;
    }

    public List<Integer> replaceZeroAndOne(List<Integer> randomNumms){
        List<Integer> result = randomNumms.stream().map(s -> {
            if (s >= 4) return 1;
            return 0;
        }).collect(Collectors.toList());
        return result;
    }
}
