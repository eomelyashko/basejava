package ru.javawebinar.basejava.exception;

public class ExistStorageException extends StorageException {
    public ExistStorageException(String uuid) {
        super("В хранилище доступно Resume " + uuid, uuid);
    }
}
