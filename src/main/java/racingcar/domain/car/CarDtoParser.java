package racingcar.domain.car;

public final class CarDtoParser {
    private CarDtoParser(){}

    // 공백제거 후, ","를 통해 구분
    public static String[] trimAndSplit(String carNamesWithCommas){
        String trimedCarNames = carNamesWithCommas.trim();
        return trimedCarNames.split("\\s*,\\s*");
    }
}
