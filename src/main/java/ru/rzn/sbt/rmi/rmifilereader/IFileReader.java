package ru.rzn.sbt.rmi.rmifilereader;

import java.io.FileNotFoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Интерфейс удалённого читателя файлов
 */
public interface IFileReader extends Remote {
    /**
     * Открытие файла
     *
     * @param filename путь к файлу
     * @return true, если удалось открыть файл
     */
    boolean openFile(String filename) throws RemoteException, FileNotFoundException;

    /**
     * Чтение строки файла
     *
     * @return считанная сторка
     */
    String nextLine() throws RemoteException;

    /**
     * Закрытие файла
     *
     * @return true, если удалось закрыть файл
     */
    boolean closeFile() throws RemoteException;
}
