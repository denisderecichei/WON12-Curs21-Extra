package org.fasttrack;

import org.fasttrack.model.Kid;
import org.fasttrack.model.Parent;
import org.fasttrack.model.ParentDetails;
import org.fasttrack.model.Teacher;
import org.fasttrack.repository.KidRepository;
import org.fasttrack.repository.ParentDetailsRepository;
import org.fasttrack.repository.ParentRepository;
import org.fasttrack.repository.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner atStartup(ParentRepository parentRepo,
                                KidRepository kidRepo,
                                ParentDetailsRepository detailsRepo,
                                TeacherRepository teacherRepository) {
        return args -> {
            Parent p1 = new Parent("A1", 20, 30, null);
            ParentDetails details = new ParentDetails(p1, "test-all@gmail.com", 1984);
            p1.setParentDetails(details);
//            parentRepo.save(p1);
            Kid k1 = new Kid("K1", 1, p1);
//            k1 = kidRepo.save(k1);
            Kid k2 = new Kid("K2", 2, p1);
//            k2 = kidRepo.save(k2);
            Kid k3 = new Kid("K3", 3, p1);
//            k3 = kidRepo.save(k3);
            Teacher t1 = new Teacher("math", 40, "Cicortas", Set.of(k1, k2, k3));
            Teacher t2 = new Teacher("english", 20, "Bandici", Set.of(k2));
            k1.setTeachers(Set.of(t1));
            k2.setTeachers(Set.of(t1, t2));
            k3.setTeachers(Set.of(t1));
            p1.setKids(List.of(k1, k2, k3));
            parentRepo.save(p1);
        };
    }
}