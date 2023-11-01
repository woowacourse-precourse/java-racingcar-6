package racingcar.util.convert;

import java.util.List;

public class ConverterHolder {

    private static final ThreadLocal<List<Converter<?, ?>>> converterHolder = new ThreadLocal<>();

    private ConverterHolder() { }

    public static void setConverters(List<Converter<?, ?>> converters) {
        converterHolder.set(converters);
    }

    public static <T> T convert(Object target, Class<?> convertTo) {
        List<Converter<?, ?>> converters = converterHolder.get();
        for (Converter converter : converters) {
            if (converter.supports(target, convertTo)) {
                return (T) converter.convert(target);
            }
        }
        throw new IllegalArgumentException();
    }

    public static void clearHolder() {
        converterHolder.remove();
    }
}
