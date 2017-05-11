package com.example.suny.notifykeep.Service;

import android.app.Notification;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import com.example.suny.notifykeep.utils.databases.DatabaseManager;

import java.util.Date;

/**
 * Created by suny on 2017/5/10.
 * 获取应用名称，消息内容，时间，应用图标等数据
 */

public class NotifyListenerService extends NotificationListenerService {


    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {

        Bundle info = sbn.getNotification().extras;
        String notiPKName = sbn.getPackageName();
        String notifyBody = info.getString(Notification.EXTRA_TEXT);
        long notifyDate = sbn.getPostTime();
        

        DatabaseManager manager = new DatabaseManager(this);
        int check = notifyBody.indexOf("快递");
        if (check != -1) {
            manager.insert(notiPKName, notifyBody, notifyDate);
        } else {
//            Log.i("tag", "包名：" + notiPKName + "  内容：" + notifyBody + "  时间：" + notifyDate);
        }




    }
}
