package model;

import java.time.LocalDate;

public class UserAccount {


    private LocalDate birthday;

    private String username, password, profilePhoto, careers, favoriteBrowser, gender;

    public UserAccount(LocalDate birthday, String username, String password, String profilePhoto, String careers, String favoriteBrowser, String gender) {
        this.birthday = birthday;
        this.username = username;
        this.password = password;
        this.profilePhoto = profilePhoto;
        this.careers = careers;
        this.favoriteBrowser = favoriteBrowser;
        this.gender = gender;
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
}
