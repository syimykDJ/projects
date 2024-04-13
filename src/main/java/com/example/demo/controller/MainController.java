package com.example.demo.controller;
import com.example.demo.Readfile;
import com.example.demo.WriteFile;
import com.example.demo.models.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.*;
@RestController
public class MainController {
    @GetMapping("/ReadDataFromFile")
    public ResponseEntity<List<Emloyes>> readFile() {
        List<Emloyes> employees = Readfile.read();
        return ResponseEntity.ok(employees);
    }
    @PostMapping("/addDataToFilePost")
    public static ResponseEntity<String> addDataToFile(@RequestBody Emloyes emloyes) {
        return WriteFile.addDataToFile(emloyes);
    }
}
