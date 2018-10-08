package com.kuptsov.databasecoursework.service.common;

import java.util.List;

public interface CommonService<Entity> {

    List<Entity> findAll();

    Entity create(Entity entity);

    Entity update(Entity entity);

    Entity delete(Entity entity);

    Entity merge(Entity current, Entity merge);
}
