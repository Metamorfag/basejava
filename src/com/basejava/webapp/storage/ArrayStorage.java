package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    static final String R_PRESENT = " already exists";
    static final String R_NOT_PRESENT = " is not present";
    private Resume[] storage = new Resume[10_000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null); //заполняем все size with null
    }


    public void update(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (checkResume(resume)) {
                storage[i] = resume;
                System.out.println("Resume " + storage[i].getUuid() + " is updated");
            } else {
                System.out.println(resume.getUuid() + R_NOT_PRESENT);
            }
        }
    }

    public void save(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (checkResume(resume)) {
                System.out.println(resume.getUuid() + R_PRESENT);
                break;
            }
        }
        if (size < storage.length) {
            storage[size] = resume;
            size++;
        } else {
            System.out.println("List is full");
        }
    }

    public Resume get(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (checkResume(resume)) {
                return storage[i];
            }
            System.out.println(resume.getUuid() + R_NOT_PRESENT);
        }
        return null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    public void delete(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (checkResume(resume)) { // если uuid равен i-ому гэтuuid
                storage[i] = storage[size - 1]; //  мы i-ому элементу присваиваем значение последнего
                storage[size - 1] = null; // а последнего делаем null
                size--; //уменьшаем размер
                return;
            }
            System.out.println(resume.getUuid() + R_NOT_PRESENT);
        }
    }

    public boolean checkResume(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (resume.getUuid() == storage[i].getUuid()) {
                return true;
            }
        }
        return false;
    }
}
