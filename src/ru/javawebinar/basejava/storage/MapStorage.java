package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Map;
import java.util.TreeMap;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> map = new TreeMap<>();

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    protected void updateElement(Resume resume, Object idx) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected void saveElement(Resume resume, Object idx) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getElement(Object idx) {
        return map.get(idx);
    }

    @Override
    protected void deleteElement(Object idx) {
        map.remove(idx);
    }


    @Override
    protected Object find(String uuid) {
        return uuid;
    }

    @Override
    public Resume[] getAll() {
        return map.values().toArray(new Resume[map.size()]);
    }

    @Override
    public int size() {
        return map.size();
    }


    @Override
    protected Object getExistsElementStorage(Object idx, String uuid) {
        if (!map.containsKey(uuid)) {
            throw new NotExistStorageException(uuid);
        }
        return find(uuid);
    }

    @Override
    protected Object getNotExistsElementStorage(Object idx, String uuid) {
        if (map.containsKey(uuid)) {
            throw new ExistStorageException(uuid);
        }
        return find(uuid);
    }
}
