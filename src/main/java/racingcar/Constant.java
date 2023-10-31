package racingcar;

public class Constant {
    public enum UserRequestMessage {
        CAR_NAME_REQUEST_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        Repeat_REQUEST_MESSAGE("시도할 회수는 몇회인가요?");
        private final String message;

        UserRequestMessage(String message){
            this.message = message;
        }

        @Override
        public String toString(){
            return message;
        }
    }

    public enum UserResponeMessage{
        EXECUTION_RESULT_MESSAGE("실행 결과"),
        FINAL_WINNER_MESSAGE("최종 우승자 : ");
        private final String message;

        UserResponeMessage(String message){
            this.message = message;
        }

        @Override
        public String toString(){
            return message;
        }
    }

    public enum GameConfig{
        CAR_NAME(5, ",");

        private final int limitLength;
        private final String seperator;

        GameConfig(int limitLength, String seperator){
            this.limitLength = limitLength;
            this.seperator = seperator;
        }

        public int getLimitLength(){
            return this.limitLength;
        }

        public String getSeperator(){
            return this.seperator;
        }

    }
}
