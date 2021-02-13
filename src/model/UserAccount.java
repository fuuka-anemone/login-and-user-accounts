package model;

import java.time.LocalDate;
import java.util.Objects;

public class UserAccount {


    private LocalDate birthday;

    private String username, password, profilePhoto, careers, favoriteBrowser, gender;

    public UserAccount(LocalDate bd, String un, String pw, String pfp, String cr, String fb, String gn) {
        this.birthday = Objects.requireNonNull(bd);
        this.username = Objects.requireNonNull(un);
        this.password = Objects.requireNonNull(pw);
        this.profilePhoto = Objects.requireNonNull(pfp);
        this.careers = Objects.requireNonNull(cr);
        this.favoriteBrowser = Objects.requireNonNull(fb);
        this.gender = Objects.requireNonNull(gn);
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public String getCareers() {
        return careers;
    }

    public String getFavoriteBrowser() {
        return favoriteBrowser;
    }

    public String getGender() {
        return gender;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public void setCareers(String careers) {
        this.careers = careers;
    }

    public void setFavoriteBrowser(String favoriteBrowser) {
        this.favoriteBrowser = favoriteBrowser;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
