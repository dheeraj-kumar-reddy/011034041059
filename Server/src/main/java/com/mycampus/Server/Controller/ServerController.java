package com.mycampus.Server.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4400")
@RestController
@RequestMapping("/mycampus")
public class ServerController {

}
