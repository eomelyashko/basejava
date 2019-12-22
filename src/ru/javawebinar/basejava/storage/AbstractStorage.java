package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage implements Storage {
    protected static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getFullName);

    @Override
    public final void update(Resume resume) {
        Object searchKey = getExistedKey(resume.getUuid());
        doUpdate(resume, searchKey);
    }

    @Override
    public final void save(Resume resume) {
        Object searchKey = getNotExistedKey(resume.getUuid());
        doSave(resume, searchKey);
    }

    @Override
    public final Resume get(String uuid) {
        Object searchKey = getExistedKey(uuid);
        return doGet(searchKey);
    }

    @Override
    public final void delete(String uuid) {
        Object searchKey = getExistedKey(uuid);
        doDelete(searchKey);
    }

    public final Comparator<Resume> getComparatorArrayAndList() {
        return RESUME_COMPARATOR.thenComparing(Resume::getUuid);
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> collectionStorage = getCollectionStorage();
        Collections.sort(collectionStorage, getComparatorArrayAndList());
        return collectionStorage;
    }

    private Object getExistedKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getNotExistedKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    protected abstract Object getSearchKey(String uuid);

    protected abstract void doUpdate(Resume resume, Object searchKey);

    protected abstract void doSave(Resume resume, Object searchKey);

    protected abstract Resume doGet(Object searchKey);

    protected abstract void doDelete(Object searchKey);

    protected abstract boolean isExist(Object searchKey);

    protected abstract List<Resume> getCollectionStorage();
}
