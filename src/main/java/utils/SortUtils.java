package utils;

import model.Note;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortUtils {
    public static void sortByTitle(List<Note> notes) {
        Collections.sort(notes, Comparator.comparing(Note::getTitle));
    }

    public static void sortByDate(List<Note> notes) {
        Collections.sort(notes, Comparator.comparing(Note::getDate));
    }
}
