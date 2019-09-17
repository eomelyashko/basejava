import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int top;

    void clear() {
        for (int i = 0; i < top; i++) {
            storage[i] = null;
        }
        top = 0;
    }

    void save(Resume r) {
        if (storage[find(r.uuid)] == null) {
            storage[top] = r;
            top++;
        } else {
            //Дубликат
        }
    }

    Resume get(String uuid) {
        int index = find(uuid);
        if (index != top) // если значение равно количеству элементов, то элемента нет в списке
            return storage[find(uuid)];
        else
            return null;
    }

    void delete(String uuid) {
        int findIndex = find(uuid);
        storage[findIndex] = null;
        for (int k = findIndex; k < top; k++) // Перемещение последующих элементов
            storage[k] = storage[k + 1];
        top--;
    }

    int find(String searchKey) {
        int currentIn = 0;
        while (true) {
            if (currentIn < top) {
                if (storage[currentIn].uuid.equals(searchKey.toLowerCase()))
                    return currentIn; // Элемент найден
                else
                    ++currentIn; // Элемент не найден
            } else {
                return top; //если элемента в списка нет возвращаем общее кол-во имеющихся элементов
            }
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.stream(storage).filter(r -> r != null).toArray(Resume[]::new);
    }

    int size() {
        return top;
    }
}
