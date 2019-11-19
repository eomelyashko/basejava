package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected Object getExistElement(String uuid) {
        Object idx = find(uuid);
        if (idx == null || (Integer) idx < 0) {
            throw new NotExistStorageException(uuid);
        }
        return idx;
    }

    protected Object getNotExistElement(String uuid) {
        Object idx = find(uuid);
        if (idx != null && (Integer) idx >= 0) {
            String s = "";
            throw new ExistStorageException(uuid);
        }
        return idx;
    }

    @Override
    public final void update(Resume resume) {
        Object idx = getExistElement(resume.getUuid());
        updateElement(resume, idx);
    }

    @Override
    public final void save(Resume resume) {
        Object idx = getNotExistElement(resume.getUuid());
        saveElement(resume, idx);
    }

    @Override
    public final Resume get(String uuid) {
        Object idx = getExistElement(uuid);
        return getElement(idx);
    }

    @Override
    public final void delete(String uuid) {
        Object idx = getExistElement(uuid);
        deleteElement(idx);
    }

    protected abstract Object find(String uuid);

    protected abstract void updateElement(Resume resume, Object idx);

    protected abstract void saveElement(Resume resume, Object idx);

    protected abstract Resume getElement(Object idx);

    protected abstract void deleteElement(Object idx);
}
