package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    public int getExistElement(String uuid) {
        int idx = find(uuid);
        if (idx < 0) {
            throw new NotExistStorageException(uuid);
        }
        return idx;
    }

    public int getNotExistElement(String uuid) {
        int idx = find(uuid);
        if (idx >= 0) {
            throw new ExistStorageException(uuid);
        }
        return idx;
    }

    @Override
    public final void update(Resume resume) {
        int idx = getExistElement(resume.getUuid());
        updateElement(resume, idx);
    }

    @Override
    public final void save(Resume resume) {
        int idx = getNotExistElement(resume.getUuid());
        saveElement(resume, idx);
    }

    @Override
    public final Resume get(String uuid) {
        int idx = getExistElement(uuid);
        return getElement(idx);
    }

    @Override
    public final void delete(String uuid) {
        int idx = getExistElement(uuid);
        deleteElement(idx);
    }

    protected abstract int find(String uuid);

    protected abstract void updateElement(Resume resume, Integer idx);

    protected abstract void saveElement(Resume resume, Integer idx);

    protected abstract Resume getElement(Integer idx);

    protected abstract void deleteElement(Integer idx);
}
