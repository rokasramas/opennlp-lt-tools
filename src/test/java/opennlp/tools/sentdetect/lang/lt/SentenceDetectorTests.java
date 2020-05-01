package opennlp.tools.sentdetect.lang.lt;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SentenceDetectorTests {
    private final SentenceDetector SENTENCE_DETECTOR = new SentenceDetector();

    @Test
    void tokenizeSimpleSentences() {
        assertArrayEquals(
                new String[]{
                        "Kainos yra vienas iš būdų keičiant elgesį.",
                        "Žinome, kad yra labai daug žmonių, ypač vyresnių."
                },
                SENTENCE_DETECTOR.sentDetect(
                        "Kainos yra vienas iš būdų keičiant elgesį. " +
                                "Žinome, kad yra labai daug žmonių, ypač vyresnių."
                )
        );
        assertArrayEquals(
                new String[]{
                        "Eidamas į sceną, tu ir ieškai populiarumo.",
                        "Kaip pats vertini savo muzikinius sugebėjimus?",
                        "Tu turi talentą?",
                        "Aš tikiu talentu geram laikui scenoje.",
                        "Todėl tikiu, kad mano dainos kažkam tiks."
                },
                SENTENCE_DETECTOR.sentDetect(
                        "Eidamas į sceną, tu ir ieškai populiarumo. " +
                                "Kaip pats vertini savo muzikinius sugebėjimus? " +
                                "Tu turi talentą? " +
                                "Aš tikiu talentu geram laikui scenoje. " +
                                "Todėl tikiu, kad mano dainos kažkam tiks."
                )
        );
        assertArrayEquals(
                new String[]{
                        "\"Reikia priminti visiems šios unikalios vietos istoriją.",
                        "Aš pats mokiausi šiame universitete prieš maždaug penkiasdešimt metų\", - sakė jis."
                },
                SENTENCE_DETECTOR.sentDetect(
                        "\"Reikia priminti visiems šios unikalios vietos istoriją. " +
                                "Aš pats mokiausi šiame universitete prieš maždaug penkiasdešimt metų\", - sakė jis."
                )
        );
    }

}