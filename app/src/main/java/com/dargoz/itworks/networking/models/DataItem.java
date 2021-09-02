package com.dargoz.itworks.networking.models;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class DataItem {
    @SerializedName("id")
    private int id;
    @SerializedName("email")
    private String email;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("avatar")
    private String avatar;

    @NotNull
    @Override
    public String toString() {
        return "DataItem{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
