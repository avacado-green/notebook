package presenter;

import model.Note;
import model.Notebook;
import model.IFileHandler;
import view.NotebookView;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class NotebookPresenter {
    private Notebook notebook;
    private NotebookView view;
    private IFileHandler<Notebook> fileHandler;

    public NotebookPresenter(Notebook notebook, NotebookView view, IFileHandler<Notebook> fileHandler) {
        this.notebook = notebook;
        this.view = view;
        this.fileHandler = fileHandler;
    }

    public void addNote(String title, String content, Date date) {
        Note note = new Note(title, content, date);
        notebook.addNote(note);
    }

    public void displayNotes() {
        view.displayNotes(notebook);
    }

    public void saveNotebook(String filename) {
        try {
            fileHandler.saveToFile(notebook, filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadNotebook(String filename) {
        try {
            notebook = fileHandler.readFromFile(filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sortByTitle() {
        Collections.sort(notebook.getNotes(), Comparator.comparing(Note::getTitle));
    }

    public void sortByDate() {
        Collections.sort(notebook.getNotes(), Comparator.comparing(Note::getDate));
    }

    public List<Note> searchByDate(Date date) {
        return notebook.getNotes().stream()
                .filter(note -> note.getDate().equals(date))
                .collect(Collectors.toList());
    }

    public List<Note> searchByWeek(Date startDate) {
        Date endDate = new Date(startDate.getTime() + (7 * 24 * 60 * 60 * 1000));
        return notebook.getNotes().stream()
                .filter(note -> !note.getDate().before(startDate) && !note.getDate().after(endDate))
                .collect(Collectors.toList());
    }
}

