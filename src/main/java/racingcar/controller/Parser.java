package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 입력받은 문자열과 숫자를 일단 파싱해주는 메소드
public class Parser {
    public List<String> parseCar(String input){
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    public int parseNumberOfTry (String input){
        return Integer.parseInt(input);
    }
}
