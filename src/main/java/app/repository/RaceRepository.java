package app.repository;

import app.template.InputTemplate;

public class RaceRepository {

    private final Valid valid = new Valid();
    private final InputTemplate template = new InputTemplate();

    public String getCarName() {
        return template.execute("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)", text -> valid.validCarName(text));
    }

    public String getRaceCount() {
        return template.execute("시도할 회수는 몇회인가요?", text -> valid.validCount(text));
    }
}
