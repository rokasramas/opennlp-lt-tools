package opennlp.tools.namefind.lang.lt;

import org.junit.jupiter.api.Test;

import opennlp.tools.util.Span;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class NameFinderMETests {
    private final NameFinderMEPerson PERSON_NER = new NameFinderMEPerson();
    private final NameFinderMELocation LOC_NER = new NameFinderMELocation();
    private final NameFinderMEOrganization ORG_NER = new NameFinderMEOrganization();
    private final NameFinderMETime TIME_NER = new NameFinderMETime();

    @Test
    void getPerson() {
        assertArrayEquals(
                new Span[]{new Span(11, 13, "person")},
                PERSON_NER.find(
                        new String[]{
                                "Tai", "gali", "būti", "didžiausia", "visų", "laikų", "evakuacija", "Indijoje", ",", "–", "sakė", "P.K.", "Mohapatra", "."
                        }
                )
        );
    }

    @Test
    void getLocation() {
        assertArrayEquals(
                new Span[]{new Span(0, 1, "location"), new Span(2, 4, "location")},
                LOC_NER.find(
                        new String[]{
                                "Vilniuje", ",", "Rugių", "gatvėje", ",", "visureigis", "„", "Toyota", "Hilux", "“", "taranavo", "kelis", "kitus", "automobilius", "."
                        }
                )
        );
    }

    @Test
    void getOrganization() {
        assertArrayEquals(
                new Span[]{new Span(7, 8, "organization")},
                ORG_NER.find(
                        new String[]{
                         "Žinome", ",", "kad", "Baltijos", "regione", "greitai", "vyks", "NATO", "pratybos", "."
                        }
                )
        );
    }

    @Test
    void getTime() {
        assertArrayEquals(
                new Span[]{new Span(3, 6, "time")},
                TIME_NER.find(
                        new String[]{
                                "Prekyboje", "prietaisai", "pasirodys", "rugsėjo", "25", "dieną", "."
                        }
                )
        );
    }
}
