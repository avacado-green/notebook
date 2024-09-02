package model;

import java.io.IOException;

public interface IFileHandler<T> {
    void saveToFile(T object, String filename) throws IOException;
    T readFromFile(String filename) throws IOException, ClassNotFoundException;
}

