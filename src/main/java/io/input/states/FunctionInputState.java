package io.input.states;

import programs.Program;

import java.io.IOException;
import java.util.Scanner;

public class FunctionInputState implements InputState {

    private Program program;
    private Scanner scanner;

    public FunctionInputState(Program program) {
        this.program = program;
        scanner = new Scanner(System.in);
    }

    @Override
    public void getInput() throws IOException {
        System.out.println("Type G to generate clips.txt,\n" +
                "C to change clips settings,\n" +
                "R to change reaction settings, \n" +
                "or B to go back");

        String function = scanner.nextLine();
        if (function.equals("G")) {
            System.out.println("Generating clips.txt...");
            program.generateClips();
            program.changeStage(new TwitchVodIDInputState(program));
            System.out.println("Done!");
        } else if (function.equals("C")){
            System.out.println("Entering Clips settings...");
            program.changeStage(new ClipsSettingsInputState(program));
        } else if (function.equals("R")) {
            System.out.println("Entering Reaction settings...");
            program.changeStage(new ReactionSettingsInputState(program));
        } else if (function.equals("B")){
            System.out.println("Going back...");
            program.changeStage(new TwitchVodIDInputState(program));
        } else {
            System.out.println("Incorrect input, please try again.");
        }
    }
}
