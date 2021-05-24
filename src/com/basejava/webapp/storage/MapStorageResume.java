package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.*;

public class MapStorageResume extends AbstractStorage {
    private Map<String, Resume> resumeMap = new HashMap<>();

    @Override
    public void clear() {
        resumeMap.clear();
    }

    @Override
    public int size() {
        return resumeMap.size();
    }

    @Override
    public List<Resume> getAll() {
        return new ArrayList<>(resumeMap.values());
    }

    @Override
    public Resume getFrom(Object searchKey) {
        return resumeMap.get(((Resume) searchKey).getUuid());
    }

    @Override
    public void updateTo(Object searchKey, Resume resume) {
        resumeMap.put(((Resume) searchKey).getUuid(), resume);
    }

    @Override
    void deleteFrom(Object searchKey) {
        resumeMap.remove((((Resume) searchKey).getUuid()), ((Resume) searchKey));
    }

    @Override
    void saveTo(Resume resume, Object searchKey) {
        resumeMap.put(((Resume) searchKey).getUuid(), resume);
    }

    @Override
    boolean isExist(Object searchKey) {
        return resumeMap.containsValue(((Resume) searchKey));
    }

    @Override
    public Object findSearchKey(String uuid) {
        return new Resume(uuid);
    }
}
