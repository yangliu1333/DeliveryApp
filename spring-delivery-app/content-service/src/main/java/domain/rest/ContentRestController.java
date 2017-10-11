package domain.rest;

import domain.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentRestController {
    @Autowired
    private ContentService service;


}
