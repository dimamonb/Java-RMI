package ru.rzn.sbt.rmi.rmifilereader;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RmiServer {
    public static final String UNIC_BINDING_NAME = "server.filereader";

    public static void main(String[] args) {
        FileReaderImpl fileReader = new FileReaderImpl();
        try {
            IFileReader stub = (IFileReader) UnicastRemoteObject.exportObject(fileReader, 0);
            Registry registry = LocateRegistry.createRegistry(1099);//getRegistry("localhost");

            registry.bind(UNIC_BINDING_NAME, stub);
            System.err.println("Server ready");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }

    }
}
