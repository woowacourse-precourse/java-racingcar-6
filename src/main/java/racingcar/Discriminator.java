package racingcar;

public class Discriminator {

    public static void validateCarNumber(int carNumber){
        if (carNumber <= 0 || carNumber > 8) {
            throw new IllegalArgumentException("The # cars should in range (1,8) ");
        }
    }

    public static void validateCarName(String carName){
        if (carName.length() > 5 || carName.isEmpty() || carName.matches(".*\\s+.*")||carName.contains("'")||carName.contains("\"")){
            throw new IllegalArgumentException("Invalid car name.");
        }
    }
    /**
    시도 회수에 대한 유효성을 검사하는 메소드입니다.

    시도 회수가 0이하일 경우 예외 처리가 발생되며, 정수로 변환할 수 없는 경우(시도 회수 입력이 문자 등 숫자가 아닌 경우)
    예외를 발생시킵니다.
     */
    public static void validateTrialCount(String trialCount){
        try{
            int count = Integer.parseInt(trialCount);
            if (count <= 0){
                throw new IllegalArgumentException("The # trials should be a positive integer");
            }
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Invalid trial count. Please enter a valid Integer");
        }
    }
}
