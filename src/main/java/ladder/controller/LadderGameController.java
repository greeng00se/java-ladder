package ladder.controller;

import java.util.List;
import ladder.domain.BooleanGenerator;
import ladder.domain.Items;
import ladder.domain.LadderGame;
import ladder.domain.Line;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController {

    private final BooleanGenerator booleanGenerator;
    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController(
            final BooleanGenerator booleanGenerator,
            final InputView inputView,
            final OutputView outputView
    ) {
        this.booleanGenerator = booleanGenerator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final LadderGame ladderGame = initialize();
        final List<String> players = ladderGame.getPlayers();
        final List<Line> ladder = ladderGame.getLadder();
        final List<String> items = ladderGame.getItems();

        outputView.printLadderResult(players, ladder, items);
    }

    private LadderGame initialize() {
        final Players players = readPlayers();
        final int height = readHeight();
        final Items items = readItems(players.count());

        return LadderGame.initialize(players, booleanGenerator, height, items);
    }

    private Players readPlayers() {
        try {
            return Players.from(inputView.readPlayerNames());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readPlayers();
        }
    }

    private int readHeight() {
        try {
            return inputView.readLadderHeight();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readHeight();
        }
    }

    private Items readItems(final int playerCount) {
        try {
            return Items.from(inputView.readItemNames(), playerCount);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readItems(playerCount);
        }
    }
}
