package com.ITOTracker.ITOITSupportTracker.DAO;

import com.ITOTracker.ITOITSupportTracker.entity.Tickets;
import com.ITOTracker.ITOITSupportTracker.entity.User;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="Comment")
@NoArgsConstructor
public class CommentDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer comment_id;
    @OneToOne
    @JoinColumn(name = "ticket_id")
    private Tickets tickets;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String message;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tickets getTickets() {
        return tickets;
    }

    public void setTickets(Tickets tickets) {
        this.tickets = tickets;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
