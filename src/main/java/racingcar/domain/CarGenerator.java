package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class CarGenerator {
    private String[] names;
    private String[] locations;

    public CarGenerator(String[] input) {
        String[] locations = new String[input.length];
        // 예외 확인 - 글자수 5이하
        for (int i = 0; i < input.length; i++) {
            if (input[i].length() > 5) {
                throw new IllegalArgumentException("5자 이하만 입력 가능합니다.");
            }
            locations[i] = ""; // init
        }
        this.names = input;
        this.locations = locations;
    }

    public String[] getNames() {
        return this.names;
    }

    public String[] getLocations() {
        return this.locations;
    }
}
