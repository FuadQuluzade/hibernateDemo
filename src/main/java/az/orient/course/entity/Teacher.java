package az.orient.course.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name ="teacher")
@DynamicInsert
@DynamicUpdate
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String address;
    private String phone;
    private Date dob;
    private Integer experience;
    private Date dataDate;
    @ColumnDefault(value = "1")
    private Integer active;

}
