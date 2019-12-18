package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected void doUpdate(Resume resume, Object idx) {
        Resume searchResume = (Resume) idx;
        map.put(searchResume.getUuid(), searchResume);
    }

    @Override
    protected void doSave(Resume resume, Object idx) {
        Resume searchResume = (Resume) idx == null ? resume : (Resume) idx;
        map.put(searchResume.getUuid(), searchResume);
    }

    @Override
    protected Resume doGet(Object resume) {
        return (Resume) resume;
    }

    @Override
    protected void doDelete(Object idx) {
        map.remove(((Resume)idx).getUuid());
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return map.containsValue(searchKey);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        return new ArrayList<>(map.values());
    }

    @Override
    public int size() {
        return map.size();
    }
}
