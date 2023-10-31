package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameRuleValidator {
    public static void validateName(final String givenName) {
        if(givenName.isEmpty()) throw new IllegalArgumentException("Name is Empty");
        Integer nameSize = givenName.split("").length;
        if (nameSize > 5 || nameSize < 1) throw new IllegalArgumentException("Wrong Size Of Name");
    }

    public static void validateNames(final List<String> carNames) {
        checkDuplicateName(carNames);
        //  최대 객체 생성 가능 수 ? 실행환경을 알아야할 것 같다. + 메모리 확인이 필요하다.
        carNames.forEach(GameRuleValidator::validateName);
    }
    public static void checkDuplicateName(final List<String> carNames){
        Set<String> uniqueNames = new HashSet<>();
        carNames.stream()
                .filter(name -> !uniqueNames.add(name))
                .findAny()
                .ifPresent(duplicateName -> {
                    throw new IllegalArgumentException("중복된 자동차 이름이 있습니다: " + duplicateName);
                });
    }
}
