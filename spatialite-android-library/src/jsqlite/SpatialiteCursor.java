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
        String[] names = null;
        try {
            names = new String[getCount()];
            for (int i = 0; i < names.length; ++i) {
                names[i] = stmt.column_database_name(i);
            }
        } catch (jsqlite.Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }

        return names;
    }

    @Override
    public int getCount() {
        try {
            return stmt.column_count();
        } catch (jsqlite.Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }

        return -1;
    }

    @Override
    public double getDouble(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float getFloat(int column) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getInt(int column) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public long getLong(int column) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public short getShort(int column) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getString(int column) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isNull(int column) {
        // TODO Auto-generated method stub
        return false;
    }

}
