package racingcar.game.view;

import game.Output;

public class SimpleTagView implements View{

    private final Output out;
    private final String tag;

    public SimpleTagView(Output out, String tag) {
        this.out = out;
        this.tag = tag;
    }

    public void render(String content) {
        out.println(String.format("%s : %s",tag,content));
    }
}
