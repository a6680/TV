package com.xunlei.downloadlib.parameter;

import java.io.File;

public class GetTaskId {

    private long mTaskId;
    private File mSavePath;
    private String mFileName;

    public GetTaskId() {
    }

    public GetTaskId(File savePath) {
        this.mSavePath = savePath;
    }

    public GetTaskId(File savePath, String fileName) {
        this.mSavePath = savePath;
        this.mFileName = fileName;
    }

    public long getTaskId() {
        return this.mTaskId;
    }

    public File getSavePath() {
        return mSavePath;
    }

    public String getFileName() {
        return mFileName;
    }

    public void setFileName(String fileName) {
        this.mFileName = fileName;
    }

    public File getSaveFile() {
        return new File(getSavePath(), getFileName());
    }
}
