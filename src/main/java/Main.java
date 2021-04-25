import programs.FirstProgram;
import programs.HomeProgram;
import programs.Program;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
//        FirstProgram firstProgram = new FirstProgram();
//        firstProgram.run();

        Program program = new HomeProgram();
        program.run();
    }
}
//rections:
//TODO: list all reactions based on twitch emotes/popular expressions/emotes/words/(also double-words as they will be used in the future, along with sub-words)
//TODO: emotes/words/expressions can be added/removed from the predefined reaction and set back to default (premium option)
//TODO: the keyword "gifted" should put the counter of pogs down so that we don't count donation-pogs
//TODO: giving wages to words so that f.e. "hello youtube" or "clip" (as in clip it) is worth more pogs than f.e. "omg"
//TODO: make it possible to count also pair of word like "hello youtube" or count sub-words like "wow!!!" as "wow" or "poggg" as "pog"
//TODO: learn which streamers have which number of pogs/luls/etc. to indicate a clip and propose this number to the User as default for that streamer (ignore if we don't have information)

//timeframes:
//TODO: make it possible to add indicators where a event starts and ends, the app then gives an additional file as output which has data just for this timeframe


//clips:
//TODO: Add a option to indicate how many timeframes/seconds before a clip the highlights starts
//TODO: Each clip consists of 1 or more timeframes. Make it possible to add previous + next timeframes (when approaching another clip on the timeline the app
//      should ask if you want proceed and merge the clips or don't.
//TODO: There is an option to choose



//deplyoment:
//TODO: (maybe) make a chrome extention out of it, so that you can view the top moments directly from your browser with chat next to the video
//TODO: make a paid web-service out of it which will be advertised as can make money out of it when you clip something and send it to YT, taking over whole streamer market (editors of streamers will use it) + the market of people wanting to make money on youtube shots (I should make a couple of channels too)

//global clipping options:
//TODO: the clip should be downloaded x seconds/timeframes before the actual clip and/y seconds/timeframes after the actual clip

//UI:
//TODO: after providing the twitch link to the VOD we go straight to the clipping screen. Later we could add clipping from more than 1 vod at once and browsing twitch VODs almost exactly as in twitch leecher
