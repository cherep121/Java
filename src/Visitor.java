import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visitor {
    private String name;
    private String surname;
    private String phone;
    private boolean isSubscribed;
    private List<Book> favoriteBooks;
}