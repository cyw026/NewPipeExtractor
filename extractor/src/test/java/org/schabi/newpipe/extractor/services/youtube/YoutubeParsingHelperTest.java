package org.schabi.newpipe.extractor.services.youtube;

import org.junit.BeforeClass;
import org.junit.Test;
import org.schabi.newpipe.DownloaderTestImpl;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.utils.Utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper.*;

public class YoutubeParsingHelperTest {
    @BeforeClass
    public static void setUp() {
        NewPipe.init(DownloaderTestImpl.getInstance());
    }

    @Test
    public void testIsHardcodedClientVersionValid() throws IOException, ExtractionException {
        assertTrue("Hardcoded client version is not valid anymore",
                isHardcodedClientVersionValid());
    }

    @Test
    public void testAreHardcodedYoutubeMusicKeysValid() throws IOException, ExtractionException {
        assertTrue("Hardcoded YouTube Music keys are not valid anymore",
                areHardcodedYoutubeMusicKeysValid());
    }

    @Test
    public void testIsYoutubeUrl() throws MalformedURLException {
        final URL url = Utils.stringToURL("https://youtube.com");
        assertTrue(isYoutubeURL(url));
        assertFalse(isInvidiousURL(url));
        assertFalse(isHooktubeURL(url));
    }
}
