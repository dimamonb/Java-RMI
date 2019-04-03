package ru.rzn.sbt.rmi.rmichat;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Интерфейс локального узла чата
 */
public interface IChatLocalNode extends Remote {
    /**
     * Получение входящего сообщения
     *
     * @param message входящее сообщение
     * @throws RemoteException
     */
    void receive(String message) throws RemoteException;
}
