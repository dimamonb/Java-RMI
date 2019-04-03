package ru.rzn.sbt.rmi.rmifilereader;

import java.io.*;
import java.rmi.RemoteException;
import java.util.Scanner;

public class FileReaderImpl implements IFileReader {
    BufferedReader reader;

    @Override
    public boolean openFile(String filename) throws RemoteException {
        try {
            reader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public String nextLine() throws RemoteException {
        StringBuilder sb = new StringBuilder();
        try {
            if (reader.readLine() != null) {
                sb.append(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    @Override
    public boolean closeFile() throws RemoteException {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
