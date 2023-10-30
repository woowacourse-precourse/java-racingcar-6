package racingcar;

public class ValidCheckAndParse {

    /**
     * 쉽표로 구분된 전체 String을 분석하고, 이를 리스트로 반환하는 함수.
     * 자동차의 이름 길이를 테스트한다.
     */
    public static String[] carNameParseAndValidCheck(String carNames){
        try{
            String[] strings = carNames.split(",");
            for(String carName:strings){
                if(carName.length()>5){
                    throw new IllegalArgumentException("차의 이름이 너무 깁니다.");
                }
            }
            return strings;
        }catch(Exception e){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

    }

    /**
     * String으로 저장된 시행 횟수를 분석하고 유효성 검사를 진행하는 함수.
     * 에러가 없다면 int로 반환한다.
     */
    public static int trialParseAndValidCheck(String trialString){
        try{
            return Integer.parseInt(trialString);
        }catch(Exception e){
            throw new IllegalArgumentException("잘못된 시행 횟수입니다.");
        }
    }
}
