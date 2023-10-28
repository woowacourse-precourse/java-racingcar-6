package racingcar;

public class RacingCar {
    final String name;

    public RacingCar(String name) {
        checkName(name);
        this.name = name;
    }

    private static void checkName(String name){
        if(name.length() == 0 || name.length() > 5)
            throw new IllegalArgumentException("각 자동차의 이름은 1글자 이상 5글자 이하의 글자여야 합니다.");
    }


}
