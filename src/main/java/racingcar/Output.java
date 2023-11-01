package racingcar;

public class Output {

    public enum Message {
        PROMPT_FOR_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        PROMPT_FOR_TRY_COUNT("시도할 회수는 몇회인가요?")
        ;

        private final String label;

        Message(String label) {
            this.label = label;
        }

        public String label() {
            return label;
        }
    }

    // 경주할 자동차 이름을 입력하라는 메세지를 출력합니다.
    public void promptForCarName()
    {
        System.out.println(Message.PROMPT_FOR_CAR_NAME.label());
    }

    // 시도할 회수를 입력하라는 메세지를 출력합니다.
    public void promptForTryCount() {
        System.out.println(Message.PROMPT_FOR_TRY_COUNT.label());
    }

    // TODO : 각 차수별 실행 결과를 출력합니다.

    // TODO : 우승자를 출력합니다. 공동 우승자일 경우 쉼표를 이용하여 구분합니다.

}
