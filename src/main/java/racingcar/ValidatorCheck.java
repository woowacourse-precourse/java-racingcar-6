package racingcar;

public class ValidatorCheck {

    public void inputOnlyNumber(int playRound) {
        if (!(playRound > 0)) {
            throw new IllegalArgumentException("0이상의 정수를 입력해주세요.");
        }
    }

    public void namingRacingCar_lengthCheck(String player) {
        if (player.length() < 6 && player.length() > 0) {
            throw new IllegalArgumentException("플레이어 이름은 5자 이하만 가능합니다.");
        }
    }

    public void namingRacingCar_check(String inputPlayers) {
        int count = 0;
        for (int i = 0; i < inputPlayers.length(); i++) {
            if (inputPlayers.contains(",")) {
                count++;
            }
        }

        if (count != 2) {
            throw new IllegalArgumentException("이름 구분은 쉼표로 합니다. ',' 를 넣어 입력해주세요");
        }
    }
}
