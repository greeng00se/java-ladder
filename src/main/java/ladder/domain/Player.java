package ladder.domain;

import java.util.Objects;

public class Player {
    private final PlayerName name;
    private final Position position;

    public Player(final String name, final Position position) {
        this.name = new PlayerName(name);
        this.position = position;
    }

    public Player(final String name) {
        this.name = new PlayerName(name);
        this.position = Position.valueOf(0);
    }

    public boolean isSamePosition(final Position position) {
        return this.position == position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name.getValue();
    }
}
