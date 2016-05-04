package com.excilys.cdb.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.excilys.cdb.model.PageParameters;

/**
 * abstract class describing methods of a dao object.
 *
 * @author simon
 *
 * @param <T>
 */
public interface DAO<T> {

    static final Logger LOGGER = LoggerFactory.getLogger(DAO.class);

    /**
     * find an object by its id.
     *
     * @param id
     *            of the object
     * @return instance of the object found
     */
    public abstract T find(Long id);

    /**
     * create a new object.
     *
     * @param obj
     *            object to create
     * @return instance of the object created
     */
    public abstract T create(T obj);

    /**
     * update an object.
     *
     * @param obj
     *            object to update
     * @return instance of the object updated
     */
    public abstract T update(T obj);

    /**
     * remove an object.
     *
     * @param obj
     *            object to remove
     */
    public abstract void delete(T obj);

    /**
     * remove multiple object by their IDs
     */
    public abstract void deleteAll(List<Long> objs);

    /**
     * return all object.
     *
     * @return list containing the objects
     */
    public abstract List<T> findAll();

    /**
     * return all object with an offset and a limit.
     *
     * @param params
     *            page parameters
     * @return the list of object
     */
    public abstract List<T> findAll(PageParameters params);

    /**
     * count the number of object in the table.
     *
     * @return number of object as long
     */
    public abstract long count();

    /**
     * close the list of resources given as parameters.
     *
     * @param resources
     *            varargs containing the AutCloseable resources to close
     */
    default void closeAll(AutoCloseable... resources) {
        for (AutoCloseable resource : resources) {
            if (resource != null) {
                try {
                    resource.close();
                } catch (Exception e) {
                    LOGGER.error("couldn't close resource : " + resource.toString());
                }
            }
        }
    }

    /**
     * add params contained in the varargs to the prepared statement.
     *
     * @param stmt
     *            prepared statement where to set the params
     * @param params
     *            varargs of Object to be added to the prepared statement
     * @return same instance of the prepared statement (for conveniance)
     * @throws SQLException
     *             exception
     */
    default PreparedStatement setParams(PreparedStatement stmt, Object... params) throws SQLException {

        int cnt = 0;

        for (final Object o : params) {
            stmt.setObject(++cnt, o);
        }

        return stmt;

    }
}
