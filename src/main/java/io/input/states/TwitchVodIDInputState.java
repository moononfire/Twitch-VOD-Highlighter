package io.input.states;

import io.file.FileHelper;
import programs.Program;

import java.util.Scanner;

public class TwitchVodIDInputState implements InputState {

    private Program program;
    private Scanner scanner;

    public TwitchVodIDInputState(Program program) {
        this.program = program;
        scanner = new Scanner(System.in);
    }

    @Override
    public void getInput() {
        FileHelper fileHelper = new FileHelper();

        System.out.println("Please provide the Twitch VOD ID:");

        String id = scanner.nextLine();
        if (fileHelper.isFileAvailable(id)) {
            program.setTwitchVODId(id);
            program.changeStage(new FunctionInputState(program));
        } else {
            System.out.println("Sorry, the file: " + id + ".txt is not available.");
        }
    }
}
