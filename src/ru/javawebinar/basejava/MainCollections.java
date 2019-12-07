package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Resume;

import java.util.*;

public class MainCollections {

    private static final String UUID_0 = "uuid0";
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    private static final String FULLNAME_0 = "uuid0";
    private static final String FULLNAME_1 = "uuid1";
    private static final String FULLNAME_2 = "uuid2";
    private static final String FULLNAME_3 = "uuid3";

    private static final Resume RESUME_0 = new Resume(UUID_0, FULLNAME_0);
    private static final Resume RESUME_1 = new Resume(UUID_1, FULLNAME_1);
    private static final Resume RESUME_2 = new Resume(UUID_2, FULLNAME_2);
    private static final Resume RESUME_3 = new Resume(UUID_3, FULLNAME_3);

    public static void main(String[] args) {
        Collection<Resume> collection = new ArrayList<>();
        collection.add(RESUME_0);
        collection.add(RESUME_2);
        collection.add(RESUME_3);

        for (Resume resume : collection) {
            System.out.println(resume);
            // ConcurrentModificationException
            /*if (Objects.equals(resume.getUuid(), UUID_0)) {
                collection.remove(resume);
            }*/
        }

        Iterator<Resume> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Resume resume = iterator.next();
            System.out.println(resume);
            if (Objects.equals(resume.getUuid(), UUID_0)) {
                iterator.remove();
            }
        }
        System.out.println(collection.toString());

        Map<String, Resume> map = new HashMap<String, Resume>();
        map.put(UUID_0, RESUME_0);
        map.put(UUID_1, RESUME_1);
        map.put(UUID_2, RESUME_2);

        // Bad!
        for (String uuid : map.keySet()) {
            System.out.println(map.get(uuid));
        }

        for (Map.Entry<String, Resume> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }

        List<Resume> resumes = Arrays.asList(RESUME_1, RESUME_2, RESUME_3);
        resumes.remove(1);
        System.out.println(resumes);
    }
}
