package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10_000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void updateElement(Resume resume, Object idx) {
        storage[(Integer) idx] = resume;
    }

    @Override
    protected Object getExistElement(String uuid) {
        int idx = (Integer) find(uuid);
        if (idx < 0) {
            throw new NotExistStorageException(uuid);
        }
        return idx;
    }

    @Override
    protected Object getNotExistElement(String uuid) {
        int idx = (Integer) find(uuid);
        if (idx >= 0) {
            throw new ExistStorageException(uuid);
        }
        return idx;
    }

    @Override
    public void saveElement(Resume resume, Object idx) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("В хранилище нет места", resume.getUuid());
        } else {
            addResume(resume, idx);
            size++;
        }
    }

    @Override
    public Resume getElement(Object idx) {
        return storage[(Integer) idx];
    }

    @Override
    public final void deleteElement(Object idx) {
        removeResume((Integer) idx);
        storage[size - 1] = null;
        size--;
    }

    public int size() {
        return size;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected abstract void removeResume(Object idx);

    protected abstract void addResume(Resume resume, Object idx);
}
