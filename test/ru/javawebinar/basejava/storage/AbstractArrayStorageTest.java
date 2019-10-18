package ru.javawebinar.basejava.storage;

import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {
    private Storage storage;

    private static final String UUID_0 = "uuid0";
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    private static final Resume resume_uuid0 = new Resume(UUID_0);
    private static final Resume resume_uuid1 = new Resume(UUID_1);
    private static final Resume resume_uuid2 = new Resume(UUID_2);
    private static final Resume resume_uuid3 = new Resume(UUID_3);

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(resume_uuid1);
        storage.save(resume_uuid2);
        storage.save(resume_uuid3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(resume_uuid0);
    }

    @Test
    public void savePassed() {
        storage.save(resume_uuid0);
        assertEquals(4, storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(resume_uuid1);
    }

    @Test(expected = StorageException.class)
    public void saveStackOver() {
        try {
            storage.getAll();
            for (int i = 4; i <= 10_000; i++) {
                storage.save(new Resume("uuid" + i));
            }
        } catch (StorageException e) {
            fail();
        }
        storage.save(new Resume("uuid10001"));
    }

    @Test
    public void getPassed() {
        assertEquals(resume_uuid3, storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test
    public void deletePassed() {
        storage.delete(UUID_3);
        assertEquals(2, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(UUID_0);
    }

    @Test
    public void size() {
        assertEquals(3, storage.size());
    }

    @Test
    public void getAll() {
        Resume[] resumes = new Resume[] {resume_uuid1, resume_uuid2, resume_uuid3};
        assertEquals(resumes, storage.getAll());
    }
}