package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameController {

    public void inputComputerName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarName = Console.readLine();

        Set<String> uniqueWords = new HashSet<>();
        List<String> carName = new ArrayList<>();

        for (String word : inputCarName.split(",")) {
            System.out.println("word = " + word);
            if (!uniqueWords.add(word)) {
                throw new IllegalArgumentException("중복된 단어가 있습니다.");
            } else if(word.isEmpty()) {
                throw new IllegalArgumentException("빈 문자는 입력할 수 없습니다.");
            } else if(word.contains(" ")) {
                throw new IllegalArgumentException("자동차 이름에 공백은 포함될 수 없습니다.");
            } else if(!word.matches("^[A-Za-z0-9]+$")) {
                throw new IllegalArgumentException("자동차 이름에 특수 문자는 포함될 수 없습니다.");
            }
            carName.add(word);
        }
    }
}
