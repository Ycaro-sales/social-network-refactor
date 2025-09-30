package model;

import java.time.LocalDateTime;

// NOTE: Builder
public class UserBuilder {
    private String name;
    private String email;
    private String password;
    private Privacy privacySetting = Privacy.PUBLIC;

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public String getName() {
        return name;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }
    public String getEmail() {
        return email;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }
    public String getPassword() {
        return password;
    }

    public UserBuilder setPrivacy(Privacy privacy) {
        this.privacySetting = privacy;
        return this;
    }
    public Privacy getPrivacySetting() {
        return privacySetting;
    }

    public User build() {
        // Validation logic here
        if (name == null || email == null || password == null) {
            throw new IllegalArgumentException("Name, email, and password are required");
        }
        return new User(this);
    }
}