package ru.rzn.sbt.rmi.rmichat;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Интерфейс центрального узла чата
 */
public interface IChatCentralNode extends Remote {
    /**
     * Регистрация клиента локального чата
     *
     * @param port     номер порта, на котором открыт {@link java.rmi.registry.Registry}
     * @param nickname никнэйм
     * @throws RemoteException
     */
    void register(Integer port, String nickname) throws RemoteException;

    /**
     * Отправка исходящего сообщения
     *
     * @param message исходящее сообщение
     * @throws RemoteException
     */
    void send(String message) throws RemoteException;
}
