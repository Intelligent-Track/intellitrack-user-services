package com.architechz.project.payload.InsertionRequests;

public class Approve {

    private String username;

    private boolean accepted;

    public Approve() {
    }

    public Approve(String username, boolean accepted) {
        this.username = username;
        this.accepted = accepted;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

}
