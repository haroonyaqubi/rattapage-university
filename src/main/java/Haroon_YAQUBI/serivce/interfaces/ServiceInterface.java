package Haroon_YAQUBI.serivce.interfaces;


public interface ServiceInterface<T, ID> {
    T findById(ID id);
}
