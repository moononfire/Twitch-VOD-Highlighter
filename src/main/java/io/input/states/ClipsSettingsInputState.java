package io.input.states;

import programs.Program;
import programs.apps.options.ClippingOptions;

import java.util.Scanner;

public class ClipsSettingsInputState implements InputState {

    Program program;
    Scanner scanner;

    public ClipsSettingsInputState(Program program) {
        this.program = program;
        scanner = new Scanner(System.in);
    }

    @Override
    public void getInput() {
        ClippingOptions clippingOptions = new ClippingOptions();

        System.out.println("Timeframe length in seconds: ");
        String timeFrameLength = scanner.nextLine();

        System.out.println("How many timeframes before cutting the clip: ");
        String howManyTimeframes = scanner.nextLine();

        program.setClippingOptions(new ClippingOptions(Integer.parseInt(timeFrameLength), Integer.parseInt(howManyTimeframes)));
        System.out.println("Successfully changed clipping settings");

        program.changeStage(new FunctionInputState(program));
    }
}
