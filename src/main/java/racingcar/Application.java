package racingcar;

public class Application {
    public static void main(String[] args) {
        // 입력값 받기
        InputValue inputValue  = new InputValue();
        InputValue inputTime  = new InputValue();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] value = inputValue.getInputValue();
        System.out.println("시도할 회수는 몇회인가요?");
        String time = inputTime.getInputTime();
        
    }
}
