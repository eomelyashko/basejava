package ru.javawebinar.basejava.storage;

import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static ru.javawebinar.basejava.ResumeTestData.*;

public abstract class AbstractStorageTest {
    protected Storage storage;

    private static final Resume RESUME_0 = getResume(UUID_0, "name_uuid0");
    private static final Resume RESUME_1 = getResume(UUID_1, "name_uuid0");
    private static final Resume RESUME_2 = getResume(UUID_2, "name_uuid0");
    private static final Resume RESUME_3 = getResume(UUID_3, "name_uuid0");

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_0);
        storage.save(RESUME_1);
        storage.save(RESUME_2);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
    }


    @Test
    public void update() {
        Resume newResume = new Resume(UUID_0, "new_name_uuid");
        storage.update(newResume);
        assertEquals(newResume, storage.get(UUID_0));
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
        storage.save(RESUME_1);
    }

    @Test
    public void getPassed() {
        assertGet(RESUME_0);
        assertGet(RESUME_1);
        assertGet(RESUME_2);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test(expected = NotExistStorageException.class)
    public void deletePassed() {
        storage.delete(UUID_2);
        assertSize(2);
        storage.get(UUID_2);
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
        List<Resume> resumes = Arrays.asList(RESUME_0, RESUME_1, RESUME_2);
        resumes.containsAll(storage.getAllSorted());
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }
}