package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.*;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    private static final Comparator<Resume> RESUME_SORTED = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);

    protected static final int STORAGE_LIMIT = 10_000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void doUpdate(Resume resume, Object searchKey) {
        storage[(Integer) searchKey] = resume;
    }

    @Override
    public void doSave(Resume resume, Object searchKey) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("В хранилище нет места", resume.getUuid());
        } else {
            addResume(resume, (Integer) searchKey);
            size++;
        }
    }

    @Override
    public Resume doGet(Object searchKey) {
        return storage[(Integer) searchKey];
    }

    @Override
    public final void doDelete(Object searchKey) {
        removeResume((Integer) searchKey);
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

    @Override
    protected List<Resume> getCollectionStorage() {
        return new ArrayList<Resume>(Arrays.asList(Arrays.copyOfRange(storage, 0, size)));
    }

    protected abstract void removeResume(int idx);

    protected abstract void addResume(Resume resume, int idx);

    protected abstract Integer getSearchKey(String uuid);
}
