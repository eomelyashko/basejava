package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage<String> {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    protected void doUpdate(Resume resume, String uuid) {
        map.put(uuid, resume);
    }

    @Override
    protected void doSave(Resume resume, String uuid) {
        map.put(uuid, resume);
    }

    @Override
    protected Resume doGet(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected void doDelete(String uuid) {
        map.remove(uuid);
    }


    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    public List<Resume> getAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public int size() {
        return map.size();
    }


    @Override
    protected boolean isExist(String uuid) {
        return map.containsKey(uuid);
    }
}
