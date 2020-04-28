package ru.javawebinar.basejava.storage;

import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.ResumeTestData;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public abstract class AbstractStorageTest {
    protected Storage storage;

    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME_3;

    static {
        RESUME_3 = new Resume(UUID_3, "name_uuid3");
    }

    protected AbstractStorageTest(Storage storage) throws Exception {
        this.storage = ResumeTestData.getResume(storage);
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        this.storage = ResumeTestData.getResume(storage);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
    }


    @Test
    public void update() {
        Resume newResume = new Resume("uuid0", "new_name_uuid");
        storage.update(newResume);
        assertEquals(newResume, storage.get("uuid0"));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(RESUME_3);
    }

    @Test
    public void savePassed() {
        storage.save(RESUME_3);
        assertSize(4);
        assertGet(RESUME_3);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(storage.get("uuid1"));
    }

    @Test
    public void getPassed() {
        assertGet(storage.get("uuid0"));
        assertGet(storage.get("uuid1"));
        assertGet(storage.get("uuid2"));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test(expected = NotExistStorageException.class)
    public void deletePassed() {
        storage.delete("uuid2");
        assertSize(2);
        storage.get("uuid2");
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(UUID_3);
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test
    public void getAll() {
        List<Resume> resumes = Arrays.asList(storage.get("uuid0"), storage.get("uuid1"), storage.get("uuid2"));
        resumes.containsAll(storage.getAllSorted());
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }
}