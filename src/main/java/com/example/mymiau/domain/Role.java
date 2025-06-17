package com.example.mymiau.domain;

public enum Role {ADMIN, USER;

    public static boolean contiene(String valor) {
        for (Role e : values()) {
            if (e.name().equalsIgnoreCase(valor)) {
                return true;}}
        return false;}}