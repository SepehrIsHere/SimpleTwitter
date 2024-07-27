package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Tweet.TABLE_NAME)
public class Tweet {
    public static final String TABLE_NAME = "tweets";
    public static final String TEXT = "text";

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = TEXT)
    private String text;

    @ManyToOne
    private User user;

    public Tweet(String text, User user) {
        this.text = text;
        this.user = user;
    }
}
