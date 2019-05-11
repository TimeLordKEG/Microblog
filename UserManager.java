package com.jetbrains;

import java.util.*;

public class UserManager {
    //Using map to keep users unique using a key.
    private Map<String, User> users = new HashMap<String, User>();

    public void addUser(User user)
    {
        if (!users.containsKey(user.getUserName()))
        {

            users.put(user.getUserName(), user);
        }

    }

    public void addUser(String userName, String avatar, String firstName, String lastName, String email) {
        addUser(new User(userName, avatar, firstName, lastName, email));

    }

    public User getUser(String username) {
        return users.get(username);
    }

    public String getUserList()
    {
        return users.keySet().toString();
    }

    public boolean containsUserName(String userName)
    {
        return users.containsKey(userName);
    }

    public ArrayList<User> getAllUsersByEmail(String email)
    {
        ArrayList<User> rtn = new ArrayList<User>();
        Collection<User> values = users.values();

        for (User value:values)
        {
            if (value.getEmail().equals(email))
            {
                rtn.add(value);
            }
        }
        return rtn;
    }

}