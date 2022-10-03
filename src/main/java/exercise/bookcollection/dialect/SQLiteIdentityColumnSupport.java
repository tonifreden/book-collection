package exercise.bookcollection.dialect;

import org.hibernate.MappingException;
import org.hibernate.dialect.identity.IdentityColumnSupportImpl;

/*
 * Hibernate needs to be told how SQLite handles @Id columns, thus this custom
 * IdentityColumnSupport implementation is needed.
 * 
 * Copied from Baeldung.
 */
public class SQLiteIdentityColumnSupport extends IdentityColumnSupportImpl {
    
    @Override
    public boolean supportsIdentityColumns() {
        return true;
    }

    @Override
    public String getIdentitySelectString(String table, String column, int type) throws MappingException {
        return "select last_insert_rowid()";
    }

    @Override
    public String getIdentityColumnString(int type) throws MappingException {
        return "integer";
    }
}
