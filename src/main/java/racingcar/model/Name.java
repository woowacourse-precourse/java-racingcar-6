package racingcar.model;

public class Name {
    private String name;

    /**
     * 주어진 이름으로 자동차를 생성한다. 초기 주행 거리는 0이다.
     * @param unsure 양 끝에 공백을 포함하지 않는 1자 이상 5자 이하인 문자열
     * @throws IllegalArgumentException 유효하지 않은 name 형식
     */
    public Name(String unsure) throws IllegalArgumentException {

        if (unsure == null) {
            throw new IllegalArgumentException("자동차의 이름은 null 일 수 없습니다.");
        }

        boolean isNameStartOrEndWithSpace = (unsure.trim().length() != unsure.length());
        boolean isNameLengthOutOfRange = (unsure.length() < 1 || 5 < unsure.length());
        if (isNameStartOrEndWithSpace || isNameLengthOutOfRange) {
            throw new IllegalArgumentException("자동차의 이름은 양 끝에 공백을 포함하거나, 비어있거나, 5자를 초과할 수 없습니다.");
        }

        this.name = unsure;
    }

    @Override
    public boolean equals(Object name) {
        // and 단축평가 고려할 것
        return (name instanceof Name) && (((Name) name).name.equals(this.name));
    }

    @Override
    public String toString() {
        return name;
    }
}
