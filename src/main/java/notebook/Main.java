package notebook;

import model.Note;
import model.Notebook;
import model.FileHandler;
import model.IFileHandler;
import presenter.NotebookPresenter;
import view.NotebookView;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Notebook notebook = new Notebook();
        NotebookView view = new NotebookView();
        IFileHandler<Notebook> fileHandler = new FileHandler<>();
        NotebookPresenter presenter = new NotebookPresenter(notebook, view, fileHandler);

        presenter.addNote("Dentist", "Appointment with dentist at 19:00", new Date(2024, 8, 26, 19, 0));
        presenter.addNote("Meeting", "Team meeting at 10:00", new Date(2024, 8, 27, 10, 0));
        presenter.displayNotes();

        presenter.saveNotebook("notebook.ser");
        presenter.loadNotebook("notebook.ser");
        presenter.displayNotes();

        presenter.sortByTitle();
        presenter.displayNotes();

        List<Note> notesOnDate = presenter.searchByDate(new Date(2024, 8, 26));
        for (Note note : notesOnDate) {
            System.out.println("Found Note: " + note.getTitle() + " on " + note.getDate());
        }

        List<Note> notesInWeek = presenter.searchByWeek(new Date(2024, 8, 26));
        for (Note note : notesInWeek) {
            System.out.println("Found Note: " + note.getTitle() + " on " + note.getDate());
        }
    }
}

