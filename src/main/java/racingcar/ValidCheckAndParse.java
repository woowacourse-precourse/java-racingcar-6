package racingcar;

public class ValidCheckAndParse {

    public static String[] carNameParseAndValidCheck(String carNames){
        String[] strings = carNames.split(",");
        for(String carName:strings){
            if(carName.length()>5){
                throw new IllegalArgumentException("차의 이름이 너무 깁니다.");
            }
        }
        return strings;
    }

    public static int trialParseAndValidCheck(String trialString){
        try{
            return Integer.parseInt(trialString);
        }catch(Exception e){
            throw new IllegalArgumentException("잘못된 시행 횟수입니다.");
        }
    }
}
