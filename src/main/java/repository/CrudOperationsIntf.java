package repository;

import exception.EntityNotFound;

public interface CrudOperationsIntf<Attribution> {

    void add(Attribution a);

    void update(int id, Attribution a) throws EntityNotFound;


}
