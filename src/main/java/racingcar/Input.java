package racingcar;

public class Input { //입력 값에 대한 검증및 예외 발생 담당
    static Car setRacingCarLineup(String name) { //입력한 자동차 이름은 쉼표로 구분 기능
        isStringEmpty(name);
        hasOtherCharacters(name);
        String noBlankName= removeBlank(name);
        String[] names = noBlankName.split(",");
        validateName(names);
        return new Car(names);
    }
    private static void isStringEmpty(String name) { //이름 공백 체크
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }
    }
    private static String removeBlank(String name) { //이름 사이 공백 제거
        return name.replace(" ","");
    }
    private static void hasOtherCharacters(String name) { //쉼표를 제외한 다른 문자의 존재 체크
        String checkString = name.replace(",","");
        if (checkString.isBlank()){
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }
    }
    private static void validateName(String[] names) { //구분한 이름마다 검증
        for (String name : names) {
            checkNameLengthLimit(name);
        }
    }
    private static void checkNameLengthLimit(String name) { //이름을 5자 이하로 제한하는 기능
        if(name.length() > 5) {
            throw new IllegalArgumentException("입력되는 이름은 5자 이하여야 합니다.");
        }
    }

    static int inputNumberOfGame(String number) throws IllegalArgumentException{ //몇번 반복할 지 입력 및 검증
        try {
            int repeatNumber = Integer.parseInt(number);
            validateNumberAtLeast(repeatNumber);
            return repeatNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1 이상의 숫자만 입력해야 합니다.");
        }
    }
    private static void validateNumberAtLeast(int number) { //입력된 숫자가 1이상의 숫자인지 검증
        if (number < 1) {
            throw new IllegalArgumentException("1 이상의 숫자만 입력해야 합니다.");
        }
    }
    //잘못된 값을 입력시 예외 발생 후 애플리케이션 종료 기능을 각 메소드 별로 나눠서 검증 메소드 추가
}