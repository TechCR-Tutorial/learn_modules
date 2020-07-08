package dowhile.lakmini2;

import java.util.Optional;

public class CustomTypeInt implements CustomDoWhileInterface<CustomTypeInt> {
    private int value;

    CustomTypeInt(int value) {
        this.value = value;
    }
    @Override
    public Optional<CustomTypeInt> nextValue() {
        return value < 10 ? Optional.of(new CustomTypeInt(value + 1)) : Optional.empty();
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
