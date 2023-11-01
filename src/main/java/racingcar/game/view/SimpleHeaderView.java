package racingcar.game.view;

import game.Output;

public class SimpleHeaderView implements View {

    private final Output out;
    private String header;
    private int count = 0;

    public SimpleHeaderView(Output out, String header) {
        this.out = out;
        this.header = header;
    }

    @Override
    public void render(String content) {
        StringBuilder builder = new StringBuilder();
        if (count == 0) {
            builder.append(header + "\n");
        }
        builder.append(content + "\n");
        count++;
        out.println(builder.toString());
    }
}
