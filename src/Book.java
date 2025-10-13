import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String name;
    private String author;
    private Integer publishingYear;
    private String isbn;
    private String publisher;
}