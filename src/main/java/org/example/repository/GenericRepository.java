package org.example.repository;



import java.util.List;

public interface GenericRepository<T,ID> {

     List<T> readerCollection(List<T> listElement);
     void writerCollection(List<T> listElement);

}
