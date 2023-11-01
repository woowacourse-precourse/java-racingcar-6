package racingcar.common.validator;

import java.util.List;
import racingcar.common.type.Name;

public class NamesValidator {

    private static final String POBI = "pobi";
    private static final String JAVAJI = "javaji";
    private static final int MINIMUM_PARTICIPANTS = 2;

    public static void validate(List<Name> nameList) {
        validateEmpty(nameList);
        validateUniqueNames(nameList);
        validateMinimumParticipants(nameList);
        validateNotBothPobiAndJavaji(nameList);
    }

    // 이름이 아예 없는 경우
    private static void validateEmpty(List<Name> nameList) {
        if (nameList.isEmpty()) {
            throw new IllegalArgumentException("적어도 하나 이상의 이름을 입력해야 합니다.");
        }
    }

    // 중복 이름 체크
    private static void validateUniqueNames(List<Name> nameList) {
        long distinctCount = nameList
                .stream()
                .distinct()
                .count();

        if (distinctCount < nameList.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    // 이름 목록 길이 체크
    private static void validateMinimumParticipants(List<Name> nameList) {
        if (nameList.size() < MINIMUM_PARTICIPANTS) {
            throw new IllegalArgumentException("적어도 두 명 이상의 참가자가 있어야 합니다.");
        }
    }

    // pobi와 javaji는 동일 인물인 경우
    private static void validateNotBothPobiAndJavaji(List<Name> nameList) {
        boolean containsPobi = containsName(nameList, POBI);
        boolean containsJavaji = containsName(nameList, JAVAJI);

        if (containsPobi && containsJavaji) {
            throw new IllegalArgumentException(POBI + "와 " + JAVAJI + "는 동일 인물입니다.");
        }
    }

    private static boolean containsName(List<Name> nameList, String targetName) {
        return nameList.stream().anyMatch(name -> name.getName().equals(targetName));
    }
}
