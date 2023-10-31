package racingcar.service;

import racingcar.repository.RacingcarRepository;

public class RacingcarPossibleCheck {

    private final RacingcarRepository racingcarRepository;
    private final String name;

    public RacingcarPossibleCheck(RacingcarRepository racingcarRepository, String name) {
        this.racingcarRepository = racingcarRepository;
        this.name = name;
    }

    // 전부 체크
    public void allCheck() {
        nameLengthOK();
        nameDuplicatedOK();
        nameStartWithBlank();
        nameContainLineBreak();
    }

    // 이름이 5글자 이하인지 확인
    void nameLengthOK() {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름은 5자 이하만 가능합니다.");
        }
    }

    // 이름이 중복됐는지 확인
    void nameDuplicatedOK() {
        if (racingcarRepository.findByName(name) != null) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름입니다.");
        }
    }

    // 이름이 띄어쓰기로 시작하는지 확인
    void nameStartWithBlank() {
        if (name.startsWith(" ")) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 공백으로 시작해서는 안 됩니다.");
        }
    }

    // 이름에 줄바꿈이 포함됐는지 확인
    void nameContainLineBreak() {
        if (name.contains("\n")) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름 입력 시 줄바꿈 사용을 금지합니다.");
        }
    }

}
