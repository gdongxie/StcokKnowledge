package com.stock.answer.ui.login.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.stock.answer.ui.login.data.model.LoggedInUser;
import com.stock.answer.utils.AssetsDatabaseManager;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {
    private AssetsDatabaseManager assetsDatabaseManager = AssetsDatabaseManager.getManager();

    public Result<LoggedInUser> login(String username, String password) {

        SQLiteDatabase sqLiteDatabase = assetsDatabaseManager.getDatabase("gupiao.db");
        StringBuilder sb = new StringBuilder();
        sb.append("select * from user where mobile='");
        sb.append(username);
        sb.append("' and password='");
        sb.append(password);
        sb.append("'");
        final Cursor cursor = sqLiteDatabase.rawQuery(sb.toString(), null);
        String userName = "";
        while (cursor != null && cursor.moveToNext()) {
            if (cursor.getCount() > 0) {
                userName = cursor.getString(cursor.getColumnIndex("mobile"));
            }
        }
        if (!userName.isEmpty()) {
            LoggedInUser inUser =
                    new LoggedInUser(java.util.UUID.randomUUID().toString(), userName);
            cursor.close();
            assetsDatabaseManager.closeDatabase("gupiao.db");
            return new Result.Success<>(inUser);
        } else {
            return new Result.Error(new Exception());
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
