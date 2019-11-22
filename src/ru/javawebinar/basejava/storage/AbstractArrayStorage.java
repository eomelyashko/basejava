package ru.javawebinar.basejava.storage;

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
    public void doUpdate(Resume resume, Object idx) {
        storage[(Integer) idx] = resume;
    }

    @Override
    public void doSave(Resume resume, Object idx) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("В хранилище нет места", resume.getUuid());
        } else {
            addResume(resume, (Integer) idx);
            size++;
        }
    }

    @Override
    public Resume doGet(Object idx) {
        return storage[(Integer) idx];
    }

    @Override
    public final void doDelete(Object idx) {
        removeResume((Integer) idx);
        storage[size - 1] = null;
        size--;
    }

    public int size() {
        return size;
    }

    @Override
    protected boolean isExist(Object idx) {
        return (Integer) idx >= 0;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected abstract void removeResume(int idx);

    protected abstract void addResume(Resume resume, int idx);

    protected abstract Integer find(String uuid);
}
