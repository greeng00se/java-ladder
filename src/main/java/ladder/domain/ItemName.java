package ladder.domain;

public class ItemName {
    private static final int NAME_LENGTH_UPPER_BOUND = 5;
    private static final String INVALID_NAME_LENGTH_MESSAGE =
            "실행 결과명은 1자 이상, " + NAME_LENGTH_UPPER_BOUND + "자 이하여야 합니다.";

    private final String value;

    public ItemName(final String name) {
        validate(name);
        this.value = name;
    }

    private void validate(final String name) {
        if (isInvalidNameLength(name)) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE);
        }
    }

    private boolean isInvalidNameLength(final String name) {
        return name == null || name.isBlank() || NAME_LENGTH_UPPER_BOUND < name.length();
    }

    public String getValue() {
        return value;
    }
}
