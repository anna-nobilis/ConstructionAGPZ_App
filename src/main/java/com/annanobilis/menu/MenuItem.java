package com.annanobilis.menu;

public interface MenuItem {
    void run();
    default String getTitle() {
        return "Exit";
    }
}
