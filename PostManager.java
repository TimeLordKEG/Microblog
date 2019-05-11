package com.jetbrains;

import java.util.*;

public class PostManager
{
    private Map<UUID, Post> posts = new HashMap<UUID, Post>();
    private Map<String, ArrayList<UUID>> userPosts = new HashMap<String, ArrayList<UUID>>();

    public void addPost(Post post)
    {
        if (!posts.containsKey(post.getId()))
        {
            posts.put(post.getId(), post);

            if (userPosts.containsKey(post.getMessageAuthor().getUserName()))
            {
                userPosts.get(post.getMessageAuthor().getUserName()).add(post.getId());
            }
            else
            {
                ArrayList<UUID> list = new ArrayList<UUID>();
                list.add(post.getId());
                userPosts.put(post.getMessageAuthor().getUserName(), list);
            }
        }
    }

    public void addPost(User messageAuthor, int postOrder, String messageContent)
    {
        addPost(new Post(messageAuthor, postOrder, messageContent));
    }

    public void addPost(User messageAuthor, int postOrder, String messageContent, String link)
    {
        if (link == null)
        {
            addPost(new Post(messageAuthor, postOrder, messageContent));
        }
        else
        {
            addPost(new Post(messageAuthor, postOrder, messageContent, link));
        }

    }

    public Post getPost(UUID id)
    {
       return posts.get(id);
    }

    public ArrayList<UUID> getPostsByUser(String userId)
    {
        return userPosts.get(userId);
    }

    public Collection<Post> getAllPosts()
    {
        return posts.values();
    }

    public Post getUserLastPost(String userId) {
        ArrayList<UUID> userPosts = getPostsByUser(userId);
        if (userPosts == null) { return null; }

        return getPost(userPosts.get(userPosts.size()-1));
    }

    public int nextPostOrder(String userId)
    {
        ArrayList<UUID> userPosts = getPostsByUser(userId);
        if (userPosts == null) { return 0; }

        return userPosts.size();
    }

}


