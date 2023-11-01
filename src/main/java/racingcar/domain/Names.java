package racingcar.domain;

import racingcar.global.utils.generator.NamesGenerator;

public class Names {

    private final ClientNames nameList;
    private final int nameCount;

    public Names(NamesGenerator namesGenerator) {
        nameList = new ClientNames(namesGenerator.nameGenerate());
        this.nameCount = nameList.getNameCount();
    }

    public int getNameCount() {
        return nameCount;
    }

    public ClientNames getNameList() {
        return nameList;
    }
}
