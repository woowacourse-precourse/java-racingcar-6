package racingcar;

public class ExeptionProcess {

    //(예외 처리1)입력 차 이름이 문자가 아닐 경우
    // 이름이 비어 있지 않고, 공백 문자 만으로 구성 되지 않는지, 숫자 인지 확인
    public boolean isValidCarName(String name) {return name != null && !name.trim().isEmpty();}



    //(예외 처리2)입력된 자동차 이름의 길이가 5 이하 인지 검사






    //(예외 처리3)실행 횟수 정수가 아닐때 검사
    public void isInputDataInteger(String tryCountInput)
    {
        int count;
        try {
            count = Integer.parseInt(tryCountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력하세요");
        }
    }





}
