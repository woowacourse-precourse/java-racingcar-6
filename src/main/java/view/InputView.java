package view;

import view.validator.CarNamesValidator;

public class InputView {
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPTS = "시도할 회수는 몇회인가요?";
    private final Reader reader;

    public InputView(Reader reader){
        this.reader = reader;
    }

    public String[] readCarNames(){
        System.out.println(INPUT_CAR_NAMES);
        String carNameInput = reader.readLine().trim();
        return CarNamesValidator.validate(carNameInput);
    }
}
