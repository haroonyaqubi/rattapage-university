package Haroon_YAQUBI.serivce.interfaces;


import java.util.List;

public interface ListServiceInterface<T> {
    List<T> list();
    T findById(String id);
}
