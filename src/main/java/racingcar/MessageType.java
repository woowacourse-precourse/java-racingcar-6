package racingcar;

public enum MessageType{
    INPUT_CAR_NAME_PRINT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_CAR_RACING_COUNT_PRINT("시도할 회수는 몇회인가요?"),
    INPUT_DATA_PRINT("%s"),

    OUTPUT_RACE_RESULT_PRINT("실행 결과"),
    OUTPUT_IMPLEMENTATION_RESULT_PRINT("%s : %s"),
    OUTPUT_WINNERS("최종 우승자 : %s")
    ;

    private final String value;

    MessageType(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
