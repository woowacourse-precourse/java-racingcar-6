package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class CarGenerator {
    private String[][] names;
    public CarGenerator() {
        String[] inStr = Console.readLine().split(",");
        String[][] inNames = new String[inStr.length][2];
        for(int i=0; i<inStr.length;i++) {
            inNames[i][0] = inStr[i];
            inNames[i][1] = "";
        }
        this.names = inNames;
    }

    public String[][] getNames() { return this.names; }
}
