package torn.ando.budgetmaster;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Expense {
    String description;
    double amount;
    Category category;
    LocalDate expenseDate;
}
