package programs;

import chat.Timeframe;
import io.file.FileHandler;
import io.printers.MomentsConsolePrinter;
import io.printers.MomentsFilePrinter;
import io.printers.writers.MomentsConsoleWriter;
import io.printers.writers.MomentsFileWriter;
import reactions.Reaction;
import util.Parser;
import util.ReactionUtil;
import util.TimeframeUtil;

import java.io.IOException;
import java.util.List;

public class FirstProgram {

    public static final String CHAT_FILENAME = "tsm_imperialhal_995964727";

    public void run() throws IOException {
        FileHandler fileHandler = new FileHandler(CHAT_FILENAME);
        Parser parser = new Parser();
        List<Timeframe> timeframes = parser.parse(fileHandler.getInputFilePath());

        MomentsFilePrinter filePrinter = new MomentsFilePrinter(new MomentsFileWriter());
        MomentsConsolePrinter consolePrinter = new MomentsConsolePrinter(new MomentsConsoleWriter());

        consolePrinter.printFullMoments(TimeframeUtil.getFilteredSout(timeframes, ReactionUtil.getAllReactions()));
        filePrinter.printFullMoments(fileHandler.getMomentsOutputPath(), TimeframeUtil.getFilteredFile(timeframes, ReactionUtil.getAllReactions()));

        consolePrinter.printShortMoments(TimeframeUtil.getFilteredSout(timeframes, Reaction.Pog()), Reaction.Pog());
        filePrinter.printShortMoments(fileHandler.getPogsOutputPath(), TimeframeUtil.getFilteredFile(timeframes, Reaction.Pog()), Reaction.Pog());

        consolePrinter.printShortMoments(TimeframeUtil.getFilteredSout(timeframes, Reaction.Lul()), Reaction.Lul());
        filePrinter.printShortMoments(fileHandler.getLulsOutputPath(), TimeframeUtil.getFilteredFile(timeframes, Reaction.Lul()), Reaction.Lul());

        consolePrinter.printHighlights(TimeframeUtil.getFilteredHighlightedFile(timeframes, ReactionUtil.getAllReactions()), ReactionUtil.getAllReactions());
        filePrinter.printHighlights(fileHandler.getHighlightedOutputPath(), TimeframeUtil.getFilteredHighlightedFile(timeframes, ReactionUtil.getAllReactions()), ReactionUtil.getAllReactions());

        consolePrinter.printClips(TimeframeUtil.getClipsFromTimeframes(TimeframeUtil.getFilteredHighlightedFile(timeframes, ReactionUtil.getAllReactions())));
        filePrinter.printClips(fileHandler.getClipsOutputPath(), TimeframeUtil.getClipsFromTimeframes(TimeframeUtil.getFilteredHighlightedFile(timeframes, ReactionUtil.getAllReactions())));

//        util.ChartSketcher chartSketcher = new util.ChartSketcher();
//        chartSketcher.sketchQuickChart(timeframes, reaction.Reaction.reactions.Pog());
    }
}
