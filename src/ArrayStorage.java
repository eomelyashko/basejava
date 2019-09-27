import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size;

    void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    void save(Resume r) {
        int idx = find(r.uuid);
        if (idx < 0) {
            if (size >= storage.length) {
                System.out.println("В хранилище нет места");
            } else {
                storage[size] = r;
                size++;
            }
        } else {
            //дубль
        }
    }

    void update(Resume r) {
        int idx = find(r.uuid);
        if (idx < 0) {
            System.out.println("Resume не найдено");
        } else {
            storage[idx] = r;
        }
    }

    Resume get(String uuid) {
        int idx = find(uuid);
        if (idx >= 0) { // если значение меньше 0 то Resume нет в списке
            return storage[idx];
        } else {
            System.out.println("Resume не найдено");
            return null;
        }
    }

    void delete(String uuid) {
        int findIdx = find(uuid);
        if (findIdx < 0) {
            System.out.println("Resume не найдено");
        } else {
            storage[findIdx] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    int find(String searchKey) {
        int currentIdx = 0;
        for (int i = currentIdx; currentIdx < size; currentIdx++) {
                if (storage[currentIdx].uuid.equals(searchKey.toLowerCase())) {
                    return currentIdx; // Элемент найден
                }
        }
        return -1; //если элемента в списке нет возвращаем -1
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size); //думаю этот метод подойдет лучше стрима с фильтром
    }

    int size() {
        return size;
    }
}
