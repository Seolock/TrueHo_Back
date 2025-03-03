package com.example.holiday.user.service;

import com.example.holiday.login.LoginResponse;
import com.example.holiday.user.controller.request.UserRequest;
import com.example.holiday.user.controller.response.UserShowingResponse;
import com.example.holiday.user.domain.Like;
import com.example.holiday.user.domain.User;
import com.example.holiday.user.dto.UserDto;
import com.example.holiday.user.repository.LikeRepository;
import com.example.holiday.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final LikeRepository likeRepository;

    private String[] list={"국제어문학부","경영경제학부","법학부","커뮤니케이션학부","상담심리사회복지학부","생명과학부","공간환경시스템공학부","전산전자공학부","콘텐츠융합디자인학부","기계제어공학부","ICT창업학부"};


    public UserDto findUserById(Long id) {
        UserDto userDto = UserDto.from(userRepository.findById(id).orElse(null));
        return userDto;
    }


    @Transactional
    public UserDto updateUser(Long id, UserRequest userRequest) {
        User user = userRepository.findById(id).orElse(null);
        user.update(userRequest);
        return UserDto.from(user);
    }


    public List<UserDto> findAllHausums(Long id) {
        List<UserDto> userDtoList = new ArrayList<>(userRepository.findAllByHansumAndShowing(1L, 1L).stream().map(UserDto::from).toList());
        if(id==0) {
            Collections.shuffle(userDtoList);
            return userDtoList;
        }
        List<UserDto> userDtoList2 = new ArrayList<>();
        for (UserDto userDto : userDtoList) {
            if(userDto.getMajor().equals(list[id.intValue()-1])) userDtoList2.add(userDto);
        }
        Collections.shuffle(userDtoList2);
        return userDtoList2;
    }


    public Long checkExist(String userId, String email, String name) {
        User user=userRepository.findByGoogleUserIdAndGoogleEmailAndGoogleName(userId,email,name).orElse(null);
        if(user!=null) return user.getId();
        return null;
    }


    public Long addUser(String userId, String email, String name) {
        User user=userRepository.findByGoogleUserIdAndGoogleEmailAndGoogleName(userId,email,name).orElse(null);
        if(user==null){
            User newUser=new User(userId,email,name);
            userRepository.save(newUser);
            return null;
        }
        return user.getId();
    }


    @Transactional
    public void saveImage(String uploadUrl, Long userId) {
        User user=userRepository.findById(userId).orElse(null);
        if(user!=null) user.setImageUrl(uploadUrl);
    }


    @Transactional
    public Long showingProfile(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            Long newShowing = (long) (user.getShowing() == 1 ? 0 : 1);
            user.setShowing(newShowing);
            userRepository.save(user);
            return newShowing;
        }
        throw new RuntimeException("User not found");
    }


    public Long addLike(Long userId, Long id) {
        Like like=likeRepository.findByFromUserAndToUser(userId, id).orElse(null);
        if(like==null) {
            Like newLike=new Like(userId,id);
            likeRepository.save(newLike);
            return 1L;
        }
        else{
            likeRepository.delete(like);
            return 0L;
        }
    }
}
