package org.frenzy.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Context {
    private final Logger logger = LogManager.getLogger(Context.class);

    private Map<Class<?>, Object> context = new HashMap<Class<?>, Object>();

    public void add(Class<?> clazz, Object object) {
        if (context.containsKey(clazz)) {
            //TODO: catch this
        }
        context.put(clazz, object);
        logger.info("Successfully add object of class {} by key {}", object.getClass().getSimpleName(), clazz.getSimpleName());
    }

    public <T> T get(Class<T> clazz) {
        //TODO: catch the situation without key value or null
        return (T)context.get(clazz);
//        T value;
//        try {
//            value = (T) context.get(clazz);
//        }
//        catch (ClassCastException ex) {
//            throw new FrenzyRuntimeException(ex);
//        }
//
//        return value;
    }
}
