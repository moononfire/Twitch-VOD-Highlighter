package io.input.states;

import programs.Program;
import programs.apps.options.ClippingOptions;
import programs.apps.options.timeframelengthoptions.TimeframeLengthOptionsFactory;
import util.TimeframeUtil;

import java.util.Arrays;
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
        System.out.println("How many timeframes before cutting the clip: ");
        String howManyTimeframes = scanner.nextLine();

        System.out.println("Length of one timeframe: (15, 30 or 60, in seconds)");
        String timeframeLength = scanner.nextLine();

        if (!Arrays.stream(TimeframeUtil.availableTimeframeLengthOptions()).anyMatch(tfl -> tfl.equals(timeframeLength))) {
            System.out.println("This is not a valid timeframe length, please try again.");
            return;
        }

        TimeframeLengthOptionsFactory tfloFactory = new TimeframeLengthOptionsFactory();
        program.setClippingOptions(new ClippingOptions(Integer.parseInt(howManyTimeframes), tfloFactory.getTimeframeLengthOptions(timeframeLength)));
        System.out.println("Successfully changed clipping settings");

        program.changeStage(new FunctionInputState(program));
    }
}
