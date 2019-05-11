package com.jetbrains;


import java.util.UUID;

public class Post
{

    private UUID id;
    private User messageAuthor;
    private int postOrder;
    private String messageContent;
    private String link;


    public Post(User messageAuthor, int postOrder, String messageContent)
    {
        this.id = UUID.randomUUID();
        setMessageAuthor(messageAuthor);
        setPostOrder(postOrder);
        setMessageContent(messageContent);
    }

    public Post(User messageAuthor, int postOrder, String messageContent, String link)
    {
        this(messageAuthor, postOrder, messageContent);
        setLink(link);
    }


    public UUID getId() { return id; }

    public User getMessageAuthor() {
        return messageAuthor;
    }

    public void setMessageAuthor(User messageAuthor) {
        this.messageAuthor = messageAuthor;
    }
    public int getPostOrder() {
        return postOrder;
    }

    public void setPostOrder(int postOrder) {
        this.postOrder = postOrder;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String toString()
    {
        String link = "";
        if (getLink()!=null)
        {
            link = getLink() + "\n";
        }
        return getMessageAuthor().toString() + "\n" + getMessageContent() + "\n" + link + "---------------------------------------\n";
    }

}
