package com.fongmi.android.tv.bean;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.fongmi.android.tv.utils.ImgUtil;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Channel {

    @SerializedName("urls")
    private List<String> urls;
    @SerializedName("number")
    private String number;
    @SerializedName("icon")
    private String icon;
    @SerializedName("name")
    private String name;
    @SerializedName("ua")
    private String ua;

    private boolean activated;
    private int index;

    public static Channel objectFrom(JsonElement element) {
        return new Gson().fromJson(element, Channel.class);
    }

    public static Channel create(int number) {
        return new Channel().setNumber(number);
    }

    public static Channel create(String name) {
        return new Channel(name, Collections.emptyList());
    }

    public Channel() {
    }

    public Channel(String name, String... urls) {
        this(name, new ArrayList<>(Arrays.asList(urls)));
    }

    public Channel(String name, List<String> urls) {
        this.name = name;
        this.urls = urls;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public String getNumber() {
        return TextUtils.isEmpty(number) ? "" : number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getIcon() {
        return TextUtils.isEmpty(icon) ? "" : icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return TextUtils.isEmpty(name) ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUa() {
        return TextUtils.isEmpty(ua) ? "" : ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public int getVisible() {
        return getIcon().isEmpty() ? View.GONE : View.VISIBLE;
    }

    public void loadIcon(ImageView view) {
        if (!getIcon().isEmpty()) ImgUtil.load(getIcon(), view);
    }

    public String getUrl() {
        return getUrls().get(getIndex());
    }

    public Channel setNumber(int number) {
        setNumber(String.format(Locale.getDefault(), "%03d", number));
        return this;
    }

    public Map<String, String> getHeaders() {
        HashMap<String, String> map = new HashMap<>();
        if (getUa().isEmpty()) return map;
        map.put("User-Agent", getUa());
        return map;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Channel)) return false;
        Channel it = (Channel) obj;
        return getName().equals(it.getName()) || (!getNumber().isEmpty() && getNumber().equals(it.getNumber()));
    }
}