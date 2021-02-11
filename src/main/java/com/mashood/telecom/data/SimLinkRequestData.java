package com.mashood.telecom.data;

import java.util.List;

public class SimLinkRequestData {
    public SimLinkRequestData() {
    }

    List<Long> id;

    public SimLinkRequestData(List<Long> id) {
        this.id = id;
    }

    public List<Long> getId() {
        return id;
    }

    public void setId(List<Long> id) {
        this.id = id;
    }
}
