package racingcar.utils.output;

public enum SystemOutputManager implements OutputManager{
   NAME_INPUT{
       @Override
       public void output() {
           System.out.println(NAME_INPUT_MESSAGE);
       }
   },
    GAME_COUNT_INPUT{
        @Override
        public void output() {
            System.out.println(GAME_COUNT_INPUT_MESSAGE);
        }
    };
    private static final String NAME_INPUT_MESSAGE="경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GAME_COUNT_INPUT_MESSAGE="시도할 회수는 몇회인가요?";
}
