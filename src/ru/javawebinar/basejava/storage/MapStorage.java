package ru.javawebinar.basejava.storage;

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
    protected void doUpdate(Resume resume, Object idx) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected void doSave(Resume resume, Object idx) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume doGet(Object idx) {
        return map.get(idx);
    }

    @Override
    protected void doDelete(Object idx) {
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
    protected boolean isExist(Object searchKey) {
        return map.containsKey(searchKey);
    }
}
