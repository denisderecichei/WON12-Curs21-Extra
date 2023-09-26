package org.fasttrack.service;

import org.fasttrack.model.Parent;
import org.fasttrack.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {
    @Autowired
    private ParentRepository repository;

    public List<Parent> getAll() {
        return repository.findAll();
    }

    public int addParent(Parent parent) {
//        for (Kid kids: parent.getKids()) {
//            kids.setParent(parent);
//        }
        Parent addedOne = repository.save(parent);
        return addedOne.getParentId();
    }
}
