package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<>();

    public void clear() {
        list.clear();
    }

    @Override
    protected Resume getElement(Object idx) {
        return list.get((Integer) idx);
    }

    @Override
    protected void updateElement(Resume resume, Object idx) {
        list.set((Integer) idx, resume);
    }

    @Override
    protected void deleteElement(Object idx) {
        int idxRemove = (Integer) idx;
        list.remove(idxRemove);
    }

    @Override
    protected void saveElement(Resume resume, Object idx) {
        list.add(resume);
    }

    @Override
    protected Object find(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid.toLowerCase()))
                return i;
        }
        return null;
    }

    @Override
    protected boolean isExistElement(Object searchKey) {
        return searchKey == null;
    }

    public Resume[] getAll() {
        return list.toArray(new Resume[list.size()]);
    }

    public int size() {
        return list.size();
    }
}
