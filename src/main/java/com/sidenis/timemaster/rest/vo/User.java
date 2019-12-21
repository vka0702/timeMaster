package com.sidenis.timemaster.rest.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class User {
    private int id;
    private String uid;
    private String full_name;
    private String email;
    private List<String> user_permissions;
    private boolean is_superuser;
    private boolean is_anonymous;
    private boolean is_staff;
    private boolean is_active;

    @Override
    public String toString() {
            return "User{" + "\n" +
                    "id=" + id + "\n" +
                    ", uid='" + uid + '\'' + "\n" +
                    ", full_name='" + full_name + '\'' + "\n" +
                    ", email='" + email + '\'' + "\n" +
                    ", user_permissions=" + user_permissions.stream().map(s -> "\n"+s).collect(Collectors.toList()) + "\n" +
                    ", is_superuser=" + is_superuser + "\n" +
                    ", is_anonymous=" + is_anonymous + "\n" +
                    ", is_staff=" + is_staff + "\n" +
                    ", is_active=" + is_active + "\n" +
                    '}';
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getUid() { return uid; }

    public void setUid(String uid) { this.uid = uid; }

    public String getFull_name() { return full_name; }

    public void setFull_name(String full_name) { this.full_name = full_name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public List<String> getUser_permissions() { return user_permissions; }

    public void setUser_permissions(List<String> user_permissions) { this.user_permissions = user_permissions; }

    public boolean getIs_superuser() { return is_superuser; }

    public void setIs_superuser(boolean is_superuser) { this.is_superuser = is_superuser; }

    public boolean getIs_anonymous() { return is_anonymous; }

    public void setIs_anonymous(boolean is_anonymous) { this.is_anonymous = is_anonymous; }

    public boolean getIs_staff() { return is_staff; }

    public void setIs_staff(boolean is_staff) { this.is_staff = is_staff; }

    public boolean getIs_active() { return is_active; }

    public void setIs_active(boolean is_active) { this.is_active = is_active; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                is_superuser == user.is_superuser &&
                is_anonymous == user.is_anonymous &&
                is_staff == user.is_staff &&
                is_active == user.is_active &&
                Objects.equals(uid, user.uid) &&
                Objects.equals(full_name, user.full_name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(user_permissions, null);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, full_name, email, user_permissions, is_superuser, is_anonymous, is_staff, is_active);
    }
}
