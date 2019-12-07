package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> map = new HashMap<>();

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
    public List<Resume> getAllSorted() {
        return new ArrayList<>(map.values());
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
