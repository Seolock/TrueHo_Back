package com.example.holiday.login;

import com.example.holiday.user.service.UserService;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;


    @PostMapping("/main/login")
    public ResponseEntity<LoginResponse> googleLogin(@RequestParam String credential, HttpSession session){
        HttpTransport transport = new NetHttpTransport();
        JsonFactory jsonFactory = new GsonFactory();
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setAudience(Collections.singletonList("YOUR_CLIENT_ID"))
                .build();

        try {
            GoogleIdToken idToken = verifier.verify(credential);
            if (idToken != null) {
                GoogleIdToken.Payload payload = idToken.getPayload();

                String hd=payload.getHostedDomain();

                if(!"handong.ac.kr".equals(hd)){
                    return ResponseEntity.badRequest().body(new LoginResponse("Invalid ID token"));
                }

                String userId = payload.getSubject();
                String email = payload.getEmail();
                String name = (String) payload.get("name");

                Long exist=userService.addUser(userId,email,name);

                session.setAttribute("userId", userId);
                session.setAttribute("email", email);
                session.setAttribute("name", name);

                return ResponseEntity.ok().body(new LoginResponse(exist==null?"0":"1"));
            } else {
                return ResponseEntity.badRequest().body(new LoginResponse("Invalid ID token"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new LoginResponse("Server error occurred"));
        }
    }
}
