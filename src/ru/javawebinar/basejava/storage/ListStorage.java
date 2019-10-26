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
    protected Resume getElement(Integer idx) {
        return list.get(idx);
    }

    @Override
    protected void updateElement(Resume resume, Integer idx) {
        list.set(idx, resume);
    }

    @Override
    protected void deleteElement(Integer idx) {
        list.remove(idx.intValue());
    }

    @Override
    protected void saveElement(Resume resume, Integer idx) {
        list.add(resume);
    }

    @Override
    protected int find(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid.toLowerCase()))
                return i;
        }
        return -1;
    }

    public Resume[] getAll() {
        return list.toArray(new Resume[list.size()]);
    }

    public int size() {
        return list.size();
    }
}
