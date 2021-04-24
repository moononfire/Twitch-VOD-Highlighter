import chat.Timeframe;
import io.FileHandler;
import reactions.Reaction;
import util.Parser;
import util.ReactionUtil;
import io.printers.MomentsConsolePrinter;
import io.printers.MomentsFilePrinter;
import io.printers.writers.MomentsConsoleWriter;
import io.printers.writers.MomentsFileWriter;
import util.TimeframeUtil;

import java.io.IOException;
import java.util.List;

public class Main {

    public static final String CHAT_FILENAME = "tsm_imperialhal_995964727";

    public static void main(String[] args) throws IOException {
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

//TODO: the keyword "gifted" should put the counter of pogs down so that we don't count donation-pogs
//TODO: giving wages to words so that f.e. "hello youtube" or "clip" (as in clip it) is worth more pogs than f.e. "omg"
//TODO: make it possible to count also pair of word like "hello youtube" or count sub-words like "wow!!!" as "wow" or "poggg" as "pog"
//TODO: (maybe) make a chrome extention out of it, so that you can view the top moments directly from your browser with chat next to the video
//TODO: make it possible to add indicators where a event starts and ends, the app then gives an additional file as output which has data just for this timeframe
//TODO: lastly finally the clip could be downloaded starting 20-30 seconds before the Potential Gold Moment and lasting however long pogs last.
//TODO: each streamer will have a different number of pogs/luls/etc. indicating a Gold Moment, but they do not vary so much between streams I suppose
//      (they can be higher, which does not hurt the algorithm). The number which is multiplied by the average reaction indicating a highlighted moment behaves similar.
//      Find these number for each streamer and make a database.
//TODO: make a list of streamers from which you will take clips
//TODO: list all reactions based on twitch emotes/popular expressions/emotes/words/(also double-words as they will be used in the future, along with sub-words)

