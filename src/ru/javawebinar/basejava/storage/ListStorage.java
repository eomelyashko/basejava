package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {
    private List<Resume> list = new ArrayList<>();

    public void clear() {
        list.clear();
    }

    @Override
    protected Resume doGet(Integer idx) {
        return list.get(idx);
    }

    @Override
    protected void doUpdate(Resume resume, Integer idx) {
        list.set(idx, resume);
    }

    @Override
    protected void doDelete(Integer idx) {
        list.remove(idx.intValue());
    }

    @Override
    protected void doSave(Resume resume, Integer idx) {
        list.add(resume);
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid.toLowerCase()))
                return i;
        }
        return null;
    }

    @Override
    protected boolean isExist(Integer idx) {
        return idx != null;
    }

    @Override
    protected List<Resume> getAll() {
        return new ArrayList<>(list);
    }

    public int size() {
        return list.size();
    }
}
