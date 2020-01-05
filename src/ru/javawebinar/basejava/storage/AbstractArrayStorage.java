package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.*;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {

    protected static final int STORAGE_LIMIT = 10_000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void doUpdate(Resume resume, Integer idx) {
        storage[idx] = resume;
    }

    @Override
    public void doSave(Resume resume, Integer idx) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("В хранилище нет места", resume.getUuid());
        } else {
            addResume(resume, idx);
            size++;
        }
    }

    @Override
    public Resume doGet(Integer idx) {
        return storage[idx];
    }

    @Override
    public final void doDelete(Integer idx) {
        removeResume(idx);
        storage[size - 1] = null;
        size--;
    }

    public int size() {
        return size;
    }

    @Override
    protected boolean isExist(Integer idx) {
        return idx >= 0;
    }

    @Override
    protected List<Resume> getAll() {
        return Arrays.asList(Arrays.copyOf(storage, size));
    }

    protected abstract void removeResume(int idx);

    protected abstract void addResume(Resume resume, int idx);

    protected abstract Integer getSearchKey(String uuid);
}
