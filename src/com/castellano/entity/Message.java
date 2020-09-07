package com.castellano.entity;

import javax.persistence.*;

@Entity
@Table(name="message")
public class Message {


    //for Hibernate 4.3.x Users
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    // for Hibernate 5.x Users
    // if you're using Hibernate 5.x, use GenerationType.IDENTITY id generator strategy explicitly
    // for more information on "GenerationType" have a look at https://www.udemy.com/hibernate-and-jpa-fundamentals/learn/v4/questions/937412
	/*
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	*/

    @Column(name="TEXT")
    private String text;

    public Message() {}
    public Message(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message [id=" + id + ", text=" + text + "]";
    }

    public void setText(String text) {
        this.text = text;
    }
}
