package com.example.mymiau.domain;

public enum GatitoColor {blanco, negro, marron, gris, naranja, manchas;

    public static boolean contiene(String valor) {
        for (GatitoColor e : values()) {
            if (e.name().equalsIgnoreCase(valor)) {
                return true;}}
        return false;}}