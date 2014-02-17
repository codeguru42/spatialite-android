package jsqlite;

import android.database.AbstractCursor;
import android.util.Log;

public class SpatialiteCursor extends AbstractCursor {

    private static final String TAG = SpatialiteCursor.class.getName();

    private final Stmt stmt;

    public SpatialiteCursor(Stmt stmt) {
        this.stmt = stmt;
    }

    @Override
    public String[] getColumnNames() {
        try {
            String[] names = new String[getCount()];
            for (int i = 0; i < names.length; ++i) {
                names[i] = stmt.column_database_name(i);
            }

            return names;
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            throw new SpatialiteException("Unable to retrieve column names", e);
        }
    }

    @Override
    public int getCount() {
        try {
            return stmt.column_count();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            throw new SpatialiteException("Unable to retrieve column count", e);
        }
    }

    @Override
    public double getDouble(int column) {
        try {
            return stmt.column_double(column);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            throw new SpatialiteException("Unable to retrieve column value", e);
        }
    }

    @Override
    public float getFloat(int column) {
        try {
            return (float) stmt.column_double(column);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            throw new SpatialiteException("Unable to retrieve column value", e);
        }
    }

    @Override
    public int getInt(int column) {
        try {
            return stmt.column_int(column);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            throw new SpatialiteException("Unable to retrieve column value", e);
        }
    }

    @Override
    public long getLong(int column) {
        try {
            return stmt.column_long(column);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            throw new SpatialiteException("Unable to retrieve column value", e);
        }
    }

    @Override
    public short getShort(int column) {
        try {
            return (short) stmt.column_int(column);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            throw new SpatialiteException("Unable to retrieve column value", e);
        }
    }

    @Override
    public String getString(int column) {
        try {
            return stmt.column_string(column);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            throw new SpatialiteException("Unable to retrieve column value", e);
        }
    }

    @Override
    public boolean isNull(int column) {
        try {
            return stmt.column(column) == null;
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            throw new SpatialiteException("Unable to retrieve column value", e);
        }
    }

}
