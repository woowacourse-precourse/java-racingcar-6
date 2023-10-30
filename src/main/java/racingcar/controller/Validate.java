package racingcar.controller;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Validate {

    public void validateOverNameorZero(List<String> nameList){
        for (String name: nameList){
            if (name.length() > 5 || name.length() == 0){
                throw new IllegalArgumentException("잘못된 값이 입력되었습니다. 프로그램이 종료됩니다.");
            }
        }
    }

    public void validateDuplicate(List<String> nameList){
        // set과 길이가 다른지 확인
        Set<String> set = new HashSet<>(nameList);
        try{
            if (set.size() != nameList.size()) throw new Exception();
        } catch (Exception e){
            throw new IllegalArgumentException("중복된 값이 입력되었습니다. 프로그램이 종료됩니다.");
        }
    }


    public boolean validateNumber(String number){
        try{
            // 123a들어오면 123이 나옴
            parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다. 프로그램이 종료됩니다.");
        }
        return true;
    }

    public List<Integer> replaceZeroAndOne(List<Integer> randomNumms){
        return randomNumms.stream().map(s -> {
            if (s >= 4) return 1;
            return 0;
        }).collect(Collectors.toList());
    }


}
