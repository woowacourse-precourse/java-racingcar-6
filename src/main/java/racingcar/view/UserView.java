package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class UserView {
    static final String NAME_INPUT_MASSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static final String COIN_INPUT_MASSAGE = "시도할 회수는 몇회인가요?";

    public String inputNameValue() {
        System.out.println(NAME_INPUT_MASSAGE);
        String nameValue = Console.readLine();

        validateNullValue(nameValue);
        return nameValue;
    }

    public int inputCoinValue() {
        System.out.println(COIN_INPUT_MASSAGE);
        String coinValue = Console.readLine();
        int coin = Integer.parseInt(coinValue);

        validCoinValue(coin);
        return coin;
    }

    public void validateNullValue(String carName){
        if (carName == "") throw new IllegalArgumentException("유효하지 않은 이름입니다.");
    }

    public void validCoinValue(int coin){
        if(coin <= 0) throw new IllegalArgumentException("코인을 다시 입력해 주세요.");
    }
}
