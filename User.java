package com.jetbrains;

public class User
{

    private String userName;
    private String avatar;
    private String firstName;
    private String lastName;
    private String email;



    public User(){}

    public User(String userName, String avatar, String firstName, String lastName, String email)
    {
        setUserName(userName);
        setAvatar(avatar);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        //if (email.contains("@")){
            this.email = email;
        //}
    }
    public String toString()
    {
        return getLastName() + ", " + getFirstName() + " [" +getUserName() + "]";
    }

    public String getAllUserData()
    {
        return
                "Username: " + getUserName() + "\n" +
                "First Name: "  + getFirstName() + "\n" +
                "Last Name: " + getLastName() + "\n" +
                "Avatar: " + getAvatar() +"\n" +
                "Email: " + getEmail() + "\n\n";

    }
}
