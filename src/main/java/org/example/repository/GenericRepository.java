package org.example.repository;



import org.example.model.Post;

import java.util.List;

public interface GenericRepository<T,ID> {
    List<T> create(String content);
    Object getById(ID id);
    void updateById (ID id, String content);
    void deleteById(ID id);
}