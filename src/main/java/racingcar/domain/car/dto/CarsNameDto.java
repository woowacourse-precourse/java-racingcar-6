package racingcar.domain.car.dto;

public record CarsNameDto(String names) {
    private static final String COMMA = ",";

    public CarsNameDto {
        validateNamesIsNull(names);
        validateOneOfNameIsNull(names);
        validateCommasContinuousInput(names);
    }
    //dto의 유효성 검증 범위를 어디까지 해야 하는가?


    private void validateNamesIsNull(String names) {
        if (names == null) {
            throw new IllegalArgumentException("names cannot be null");
        }
    }
    private void validateOneOfNameIsNull(String names) {
        String first = names.substring(0,1);
        String last = names.substring(names.length()-1);

        if(first.equals(COMMA) || last.equals(COMMA)) {
            throw new IllegalArgumentException("이름 입력시 처음과 끝이 , 로 끝나면 안됩니다.");
        }
    }

    private void validateCommasContinuousInput(String names) {
        char[] namesArr = names.toCharArray();

        int commasCnt = 0;
        for (char c : namesArr) {
            commasCnt = countCommas(commasCnt, c);

            checkCommasCount(commasCnt);
        }
    }

    private int countCommas(int commasCnt, char c) {
        if(c == ',') {
            commasCnt += 1;
        } else {
            commasCnt = 0;
        }
        return commasCnt;
    }

    private void checkCommasCount(int commasCnt) {
        if(commasCnt > 1) {
            throw new IllegalArgumentException("이름 입력시 처음과 끝이 , 로 끝나면 안됩니다.");
        }
    }

}
