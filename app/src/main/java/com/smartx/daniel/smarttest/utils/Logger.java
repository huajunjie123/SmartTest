package com.smartx.daniel.smarttest.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class Logger {
    private static String mTag = "";

    private final static boolean DEBUG = true;// build 里面设置

    public Logger(Class clazz, String mAppTag) {
        mTag = mAppTag + clazz.getSimpleName();
    }

    private static String className;
    private static String methodName;
    private static int    lineNumber;

    public static boolean isDebuggable() {
        return DEBUG;
    }


    private static String createLog(String log) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        buffer.append(methodName);
        buffer.append(":");
        buffer.append(lineNumber);
        buffer.append("]");
        buffer.append(log);

        return buffer.toString();
    }

    private static String createTag(String tag) {
        return "[" + className + "]" + tag;
    }

    private static void getMethodNames(StackTraceElement[] sElements) {
        className = sElements[1].getFileName();
        methodName = sElements[1].getMethodName();
        lineNumber = sElements[1].getLineNumber();
    }

    public static void d(String message) {
        if (!isDebuggable()) return;

        getMethodNames(new Throwable().getStackTrace());
        if (mTag.equals("")) {
            //Log.d(className, createLog(message));
            //for leshi phone
            Log.i(className, createLog(message));
        } else {
            //Log.d(createTag(mTag), createLog(message));
            //for leshi phone
            Log.i(createTag(mTag), createLog(message));
        }


    }

    public static void d(String tag, String message) {
        if (!isDebuggable()) return;
        getMethodNames(new Throwable().getStackTrace());
        Log.d(createTag(tag), createLog(message));
    }

    public static void v(String message) {
        if (!isDebuggable()) return;

        getMethodNames(new Throwable().getStackTrace());
        if (mTag.equals("")) {
            Log.v(className, createLog(message));
        } else {
            Log.v(createTag(mTag), createLog(message));
        }
    }

    public static void v(String tag, String message) {
        if (!isDebuggable()) return;

        getMethodNames(new Throwable().getStackTrace());
        Log.v(createTag(tag), createLog(message));
    }

    public static void w(String message) {
        if (!isDebuggable()) return;
        getMethodNames(new Throwable().getStackTrace());
        if (mTag.equals("")) {
            Log.w(className, createLog(message));
        } else {
            Log.w(createTag(mTag), createLog(message));
        }

    }

    public static void w(String tag, String message) {
        if (!isDebuggable()) return;

        getMethodNames(new Throwable().getStackTrace());
        Log.w(createTag(tag), createLog(message));
    }

    public static void wtf(String message) {
        if (!isDebuggable()) return;

        getMethodNames(new Throwable().getStackTrace());
        if (mTag.equals("")) Log.wtf(className, createLog(message));
        else Log.wtf(createTag(mTag), createLog(message));
    }

    public static void wtf(String tag, String message) {
        if (!isDebuggable()) return;
        getMethodNames(new Throwable().getStackTrace());
        Log.wtf(createTag(tag), createLog(message));
    }

    public static void toast(String message, Context context) {
        Toast.makeText(context, createLog(message), Toast.LENGTH_SHORT).show();
    }

}