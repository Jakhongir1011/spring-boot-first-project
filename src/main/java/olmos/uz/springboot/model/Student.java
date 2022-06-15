package olmos.uz.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String phoneNumber;
}
