package com.example.UserServices.Controller;

import com.example.UserServices.DTO.MsgResponse;
import com.example.UserServices.DTO.UserDTO;
import com.example.UserServices.DTO.UserResponse;
import com.example.UserServices.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/user")
public class UserController {

    private final UserService userService;
    MsgResponse msgResponse = new MsgResponse();

    @GetMapping
    public List<UserResponse> findAll(){
        return userService.findAll();
    }

    @PostMapping
    public void addUser(@RequestBody UserDTO userDTO){
        userService.save(userDTO);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
        Optional<UserResponse> user = userService.findById(id);
        if (user.isPresent()){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}")
    public void enableIt(@PathVariable String id){
        userService.enableId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteIt(@PathVariable String id){
        userService.deleteById(id);
    }

    @PostMapping("/upByImg")
    public ResponseEntity<?> upByimg(@RequestParam("file") MultipartFile file,
                                     @RequestParam("id") String id) throws IOException {

        String msg = userService.addImg(file,id);
        if (Objects.equals(msg, "Success")){
            msgResponse.setMessage("Image uploaded successfully");
            return ResponseEntity.ok(msgResponse);
        }else{
            ResponseEntity.status(500).body(msg);
        }
        return null;
    }

}
