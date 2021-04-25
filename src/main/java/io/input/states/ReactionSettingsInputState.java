package io.input.states;

import programs.Program;
import programs.apps.options.ReactionOptions;
import reactions.Reaction;
import util.ReactionUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ReactionSettingsInputState implements InputState {

    Program program;
    private Scanner scanner;

    public ReactionSettingsInputState(Program program) {
        this.program = program;
        scanner = new Scanner(System.in);
    }

    @Override
    public void getInput() {
        System.out.println("Available reactions: " + ReactionUtil.getAllReactions());

        Map<Reaction, Integer> minReactionsInTimeframeToAddAsClip = new HashMap<>();
        Map<Reaction, Integer> maxReactionsToCountIn1Comment = new HashMap<>();

        for (Reaction reaction : ReactionUtil.getAllReactions()) {
            System.out.println("Current reaction: " + reaction);

            System.out.println("How many reactions must be in a timeframe to add to clip: ");
            String minReactionsPerTimeframe = scanner.nextLine();

            System.out.println("How many reactions should be counted on 1 comment at most?");
            String maxReactionsPerComment = scanner.nextLine();

            minReactionsInTimeframeToAddAsClip.put(reaction, Integer.parseInt(minReactionsPerTimeframe));
            maxReactionsToCountIn1Comment.put(reaction, Integer.parseInt(maxReactionsPerComment));
        }

        program.setReactionOptions(new ReactionOptions(minReactionsInTimeframeToAddAsClip, maxReactionsToCountIn1Comment));
        System.out.println("Successfully changed reaction settings.");

        program.changeStage(new FunctionInputState(program));
    }
}
