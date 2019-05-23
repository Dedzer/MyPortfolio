package project.dao;

import project.model.Studies;

import java.util.List;

public interface StudiesDao {
    List<Studies> findAll();
    Studies getDescriptionByName(String name);
}
