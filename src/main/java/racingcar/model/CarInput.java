package racingcar.model;

import java.util.Arrays;
import java.util.List;

/**
 * CarInput 클래스는 자동차 목록 입력을 저장하고 다른 형식으로 변환한다.
 *
 * @author haiseong
 */
public class CarInput {
    private static final int MINIMUM_NAME_LIST_SIZE = 2;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String SEPARATOR = ",";
    private static final String NAME_LIST_SIZE_ERROR = "플레이어는 2명 이상이여야 합니다.";
    private static final String NAME_LENGTH_ERROR = "이름의 길이는 0일 수 없고 5보다 길 수 없습니다.";
    private static final String NAME_DUPLICATED_ERROR = "중복된 이름이 있습니다.";

    private final List<String> nameList;

    /**
     * @param userInput 사용자가 입력한 String 입력값
     */
    public CarInput(String userInput) {
        this.nameList = split(userInput);
        validate();
    }

    /**
     * ','으로 나눠진 문자열을 리스트 형태로 파싱한다.
     *
     * @param userInput 사용자가 입력한 String 입력값
     * @return ','으로 나눈 결과를 List 형식으로 리턴한다.
     */
    private List<String> split(String userInput) {
        return Arrays.asList(userInput.split(SEPARATOR));
    }

    /**
     * ','으로 나눠진 문자열을 검사한다.
     */
    private void validate() {
        validateMinimumSize();
        validateNameLength();
        validateDuplicateName();
    }

    /**
     * 플레이어는 최소 2명 이상이여야 한다.
     */
    private void validateMinimumSize() {
        if (nameList.size() < MINIMUM_NAME_LIST_SIZE) {
            throw new IllegalArgumentException(NAME_LIST_SIZE_ERROR);
        }
    }

    /**
     * 이름은 길이가 0일 수 없고 5보다 길 수 없다.
     */
    private void validateNameLength() {
        for (String name : nameList) {
            int nameLength = name.length();
            if (nameLength == 0 || nameLength > MAXIMUM_NAME_LENGTH) {
                throw new IllegalArgumentException(NAME_LENGTH_ERROR);
            }
        }
    }

    /**
     * 중복된 이름이 없어야 한다.
     */
    private void validateDuplicateName() {
        long count = nameList.stream()
                .distinct()
                .count();
        if (nameList.size() != count) {
            throw new IllegalArgumentException(NAME_DUPLICATED_ERROR);
        }
    }

    /**
     * 이름 리스트를 제공한다.
     *
     * @return 이름 리스트
     */
    public List<String> getNameList() {
        return nameList;
    }
}
