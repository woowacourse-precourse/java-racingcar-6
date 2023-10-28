package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class CarGenerator {
    private String[][] names;
    public CarGenerator(String[] inStr) {
        String[][] inNames = new String[inStr.length][2];
        for(int i=0; i<inStr.length;i++) {
            inNames[i][0] = inStr[i];
            inNames[i][1] = "";
        }
        this.names = inNames;
        // 예외처리 추가확인 - 글자수 5이하
        for(int i=0; i<inStr.length; i++) {
            if(inStr[i].length()>5) throw new IllegalArgumentException("5자 이하만 입력 가능합니다.");
        }

    }

    public String[][] getNames() { return this.names; }
}
