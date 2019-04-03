package ru.rzn.sbt.rmi.rmifilereader;

import java.io.FileNotFoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static final String UNIC_BINDING_NAME = "server.filereader";
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            System.out.println(registry.list());
            IFileReader stub = (IFileReader) registry.lookup(UNIC_BINDING_NAME);

            stub.openFile("pom.xml");
            System.out.println("File opened to read");
            System.out.println(stub.nextLine());

            stub.closeFile();
            System.out.println("File closed");

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
