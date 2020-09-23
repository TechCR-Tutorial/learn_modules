package techcr.learn.code.first.problem;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Employee {

    private String name;
    private Long employeeId;
    private String designation;
    private boolean enable;
}
