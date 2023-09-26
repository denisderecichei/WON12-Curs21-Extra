package org.fasttrack.controller;

import org.fasttrack.service.ParentService;
import org.fasttrack.model.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("parents")
public class ParentController {
    @Autowired
    private ParentService service;

    @GetMapping
    public List<Parent> getAllParents() {
        return service.getAll();
    }

    @PostMapping
    public int saveParents(@RequestBody Parent parent) {
        return service.addParent(parent);
    }
}
