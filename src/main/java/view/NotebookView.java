package view;

import model.Note;
import model.Notebook;

public class NotebookView {
    public void displayNotes(Notebook notebook) {
        for (Note note : notebook) {
            System.out.println("Title: " + note.getTitle() + ", Date: " + note.getDate());
            System.out.println("Content: " + note.getContent());
            System.out.println();
        }
    }
}

