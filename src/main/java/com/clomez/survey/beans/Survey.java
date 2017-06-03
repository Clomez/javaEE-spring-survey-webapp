package com.clomez.survey.beans;

import java.time.Instant;
import java.util.List;

/**
 * Created by clomez on 27.5.2017.
 */
public class Survey {

    int id;
    int userId;
    String name;
    String description;
    boolean enabled;

    public Survey() {
        this.id = 0;
        this.userId = 0;
        this.name = "";
        this.description = "";
        this.enabled = true;
    }

    public Survey(int id, int userId, String name, String description, boolean enabled) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
