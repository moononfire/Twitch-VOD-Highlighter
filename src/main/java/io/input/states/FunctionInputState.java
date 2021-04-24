package io.input.states;

import programs.Program;

import java.util.Scanner;

public class FunctionInputState implements InputState {

    private Program program;
    private Scanner scanner;

    public FunctionInputState(Program program) {
        this.program = program;
        scanner = new Scanner(System.in);
    }

    @Override
    public void getInput() {
        System.out.println("Please type Generate to generate clips.txt,\n" +
                "Clips to go to clips settings,\n" +
                "Reactions to go to reaction settings");

        String function = scanner.nextLine();
        if (function.equals("Generate")) {
            System.out.println("Generating clips.txt...");
            program.generateClips();
            program.changeStage(new TwitchVodIDInputState(program));
        }
    }
}
