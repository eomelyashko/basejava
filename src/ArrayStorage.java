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
        if (index > 0) { // если значение равно количеству элементов, то элемента нет в списке
            return storage[index];
        } else {
            return null;
        }
    }

    void delete(String uuid) {
        int findIndex = find(uuid);
        if (findIndex >= 0) {
            for (int k = findIndex; k < top; k++) { // Перемещение последующих элементов
                if (k == (top - 1)) {
                    storage[k] = null;
                    break;
                }
                storage[k] = storage[k + 1];
            }
            top--;
        } else {
            //элемент для удаления не найден
        }
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
                return -1; //если элемента в списке нет возвращаем -1
            }
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, top); //думаю этот метод подойдет лучше стрима с фильтром
    }

    int size() {
        return top;
    }
}
