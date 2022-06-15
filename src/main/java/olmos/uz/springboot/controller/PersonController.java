package olmos.uz.springboot.controller;


import olmos.uz.springboot.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

// C R* U D
//


@RestController
public class PersonController {
  // C R* U D

    List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1,"Jahongir","Yoldoshev", new Date(),"+998991101193"),
            new Student(2,"Javoxir","Alisherov", new Date(),"+998991101197"),
            new Student(3,"Atham","Alijonov", new Date(),"+998991101198"),
            new Student(4,"Alisher","Karimov", new Date(),"+998991101192")
            ));

    // STUDENT RO'YXATINI OLISH
    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public List<Student> getStudents(){
        return students;
    }


// @PathVariable  bu yoldagi o'zgaruvchini ushlash uchun anatatsiya hisoblanadi
    // yani getStudentBuId fuctionda ushladi student/{id} ushladi

    // BITTA STUDENT BERISH ID ORQALI
    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
    public Student getStudentById(@PathVariable Integer id){
        for (Student student : students) {
            if (student.getId()==id){
                return student;
            }
        }
        return new Student();
    }


    // cleant tomonida servir tomonga json yoki form DATE KORINISHIDA MA'LUMOT YUBORSAK BO'LADI
    // RequestBody bu sTUDENT CLASSGA pars qilib beradi

    // STUDENT LISTIGA YANGI STUDENT QO'SHISH  ADDED IN STUDENT LISY nomner bir bolmagan holda
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public String addStudent(@RequestBody Student student){
        student.setId(students.get(students.size() - 1).getId() + 1);
        for (Student item : students) {
            if (item.getPhoneNumber().equals(student.getPhoneNumber())) {
                return "Boshqa raqam kiriting";
            }
        }
        students.add(student);
        return "new Student Added";
    }

    // student dan object o'chirish
    @RequestMapping(value = "/student/{id}",method = RequestMethod.DELETE)
    public String deleteString(@PathVariable Integer id){
        boolean delete = false;
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                delete = true;
                break;
            }
        }
        return delete ? "Student delete" : "Student not delete";
    }

    // edit Student id orqali va telfon nomerni har hil bolsa
    @RequestMapping(value = "/student/{id}",method = RequestMethod.PUT)
    public String editStudent(@PathVariable Integer id, @RequestBody Student student){
        boolean edited = false;
        boolean isPhone = true;
        for (Student item : students) {
            if ((item.getPhoneNumber().equals(student.getPhoneNumber()))) {
               isPhone = false;
               break;
            }
        }
            if (isPhone){
                for (Student student1 : students) {
                    if (student1.getId()==id){
                        student1.setFirstName(student.getFirstName());
                        student1.setLastName(student.getLastName());
                        student1.setBirthDate(student.getBirthDate());
                        student1.setPhoneNumber(student.getPhoneNumber());
                    }
                }
                edited = true;
            }
        return  (edited && isPhone)? "added Student":"added not Student, Enter new phoneNumber";
     }
}
