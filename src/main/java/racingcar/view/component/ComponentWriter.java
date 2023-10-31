package racingcar.view.component;

import io.writer.Writer;

public final class ComponentWriter {
    private final Writer writer;

    public ComponentWriter(final Writer writer) {
        this.writer = writer;
    }

    public void write(final Component component) {
        writer.write(component.render());
    }
}
