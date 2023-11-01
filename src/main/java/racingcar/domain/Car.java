package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private final NumberGenerator numberGenerator;
    private int position;

    public Car(String name) {
        this(name, () -> Randoms.pickNumberInRange(0, 9));
    }

    public Car(String name,
               NumberGenerator numberGenerator) {
        vailidateName(name);
        this.name = name;
        this.position = 0;
        this.numberGenerator = numberGenerator;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int randomSpeed() {
        return numberGenerator.generate();
    }

    public void move() {
        position++;
    }

    private static void vailidateName(String name) {
        isEmptyOrBlankName(name);
        isNameLengthExceedsFive(name);
        isNumeric(name);
    }

    private static void isEmptyOrBlankName(String name) {
        if (name.equals(" ") || name.equals("")) {
            throw new IllegalArgumentException("빈 문자열 입력하셨습니다.");
        }
    }

    private static void isNameLengthExceedsFive(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름 길이는 5글자 이하로 입력하세요.");
        }
    }

    private static void isNumeric(String name) {
        boolean isDigit = name.chars().allMatch(Character::isDigit);
        if (isDigit) {
            throw new IllegalArgumentException("숫자를 입력하셨습니다.");
        }
    }



}
